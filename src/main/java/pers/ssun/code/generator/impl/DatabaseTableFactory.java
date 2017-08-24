package pers.ssun.code.generator.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import pers.ssun.code.internal.config.Configuration;
import pers.ssun.code.model.Table;
import pers.ssun.code.service.Facade;
import pers.ssun.code.utils.UtilsString;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.08
 */
@Controller("databaseTableFactory")
public class DatabaseTableFactory {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	protected Configuration config;

	@Resource
	private Facade facade;

	public List<Table> tableList;

	@PostConstruct
	protected void init() throws SQLException {
		logger.info("Internal Resource Initialising starting...");
		List<Table> tableList = new ArrayList<Table>();
		if (isGenerateAllTables()) {
			tableList = facade.getTableService().getAllTableList();
		} else {
			tableList = facade.getTableService().getTableList(config.getTable_names());
		}
		this.tableList = tableList;
		logger.info("Internal Resource Initialising ended.");
	}

	protected Boolean isGenerateAllTables() {
		String tablenames = UtilsString.removeQuote(config.getTable_names()).trim();
		return StringUtils.isBlank(tablenames) || StringUtils.equalsIgnoreCase(tablenames, "all");
	}

	public List<Table> getTableList() {
		return tableList;
	}

}
