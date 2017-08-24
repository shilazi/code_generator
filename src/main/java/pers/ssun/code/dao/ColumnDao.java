package pers.ssun.code.dao;


import pers.ssun.code.model.Column;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.02
 */
public interface ColumnDao {

	public List<Column> selectColumnList(String tableName) throws SQLException;

}
