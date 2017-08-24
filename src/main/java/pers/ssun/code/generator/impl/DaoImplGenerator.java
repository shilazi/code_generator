package pers.ssun.code.generator.impl;

import org.springframework.stereotype.Controller;
import pers.ssun.code.internal.Constants;
import pers.ssun.code.model.Table;

import java.io.File;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.04
 */
@Controller
public class DaoImplGenerator extends AbstractGenerator {

	public void generate() throws SQLException {
		for (Table t : tableFactory.getTableList()) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("table", t);
			model.put("config", config);
			model.put("now", new Date());

			String content = super.getTemplateService().getContent("daoImpl.ftl", model);

			// write to file
			StringBuilder nameBuilder = new StringBuilder();
			nameBuilder.append(t.getJavaObjectCamelName()).append(FILE_SUFFIX_DAO_IMPL).append(Constants.EXTEND_JAVA);

			StringBuilder pathBuilder = new StringBuilder();
			pathBuilder.append(config.getRealpath_dao() +t.getJavaObjectCamelNametoLowerCase()+"\\mapper\\mybatis").append(File.separator).append(nameBuilder);
			System.err.println(pathBuilder.toString());
			logger.info(internal.getString("log.generator.run.file", nameBuilder.toString(), pathBuilder.toString()));

			super.writeToFile(pathBuilder.toString(), content);
		}
	}

}
