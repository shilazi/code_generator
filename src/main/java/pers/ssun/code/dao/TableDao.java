package pers.ssun.code.dao;


import pers.ssun.code.model.Table;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.02
 */
public interface TableDao {

	public List<Table> selectTableList(String table_names) throws SQLException;

	public List<Table> selectAllTableList() throws SQLException;

	public Long selectTableCount(String table_names) throws SQLException;

	public Long selectAllTableCount() throws SQLException;

}
