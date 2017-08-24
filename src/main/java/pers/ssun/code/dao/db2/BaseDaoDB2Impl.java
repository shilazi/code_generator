package pers.ssun.code.dao.db2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.02
 */
public class BaseDaoDB2Impl {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected Connection conn = null;

	@Resource
	protected DriverManagerDataSource dataSource;

	@PostConstruct
	public void init() {
		getConnection();
	}

	@PreDestroy
	public void destroy() {
		closeConnection();
	}

	protected Connection getConnection(boolean createNew) {
		if (createNew) {
			try {
				if (null != conn) {
					conn.close();
				}
				conn = dataSource.getConnection();
			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}
		return conn;
	}

	protected Connection getConnection() {
		return getConnection(true);
	}

	protected Connection closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return conn;
	}
}
