package pers.ssun.code.service;


import pers.ssun.code.model.Table;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.02
 */
public interface TableService {

	public List<Table> getTableList(String table_names) throws SQLException;

	public List<Table> getAllTableList() throws SQLException;

	public Long getTableCount(String table_names) throws SQLException;

}
