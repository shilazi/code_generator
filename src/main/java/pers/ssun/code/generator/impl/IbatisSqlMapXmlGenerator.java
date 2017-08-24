package pers.ssun.code.generator.impl;

import org.springframework.stereotype.Controller;
import pers.ssun.code.internal.Constants;
import pers.ssun.code.model.Column;
import pers.ssun.code.model.Table;

import java.io.File;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.04
 */
@Controller
public class IbatisSqlMapXmlGenerator extends AbstractGenerator {

	public void generate() throws SQLException {
		for (Table t : tableFactory.getTableList()) {
			for (Column c : t.getColumnList()) {
				if ("DATE".equalsIgnoreCase(c.getJdbcTypeShortName())) {
					c.setJdbcTypeShortName("DATETIME");
				}
			}

			Map<String, Object> model = new HashMap<String, Object>();
			model.put("table", t);
			model.put("config", config);
			model.put("now", new Date());

			String content = super.getTemplateService().getContent("daoImplSqlMap.ftl", model);

			// write to file
			StringBuilder nameBuilder = new StringBuilder();
			nameBuilder.append(t.getTable_name()).append(FILE_SUFFIX_IBATIS_SQLMAP_XML).append(Constants.EXTEND_XML);

			StringBuilder pathBuilder = new StringBuilder();
			pathBuilder.append(config.getRealpath_dao()+t.getJavaObjectCamelNametoLowerCase()+"\\mapper\\mybatis\\mapper").append(File.separator).append(nameBuilder);
			System.err.println(pathBuilder.toString());
			logger.info(internal.getString("log.generator.run.file", nameBuilder.toString(), pathBuilder.toString()));

			super.writeToFile(pathBuilder.toString(), content);

		}
	}

}
