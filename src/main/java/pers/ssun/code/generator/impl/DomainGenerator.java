package pers.ssun.code.generator.impl;

import org.apache.commons.lang.StringUtils;
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
public class DomainGenerator extends AbstractGenerator {

	public void generate() throws SQLException {
		
		for (Table t : tableFactory.getTableList()) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("table", t);
			model.put("config", config);
			model.put("now", new Date());

			// import package
			Set<String> packageImportList = new HashSet<String>();
			for (Column c : t.getColumnList()) {
				String type = c.getJavaTypeFullName();
				if (!StringUtils.startsWith(type, "java.lang.")) {
					packageImportList.add(type);
				}
			}
			Arrays.sort(packageImportList.toArray());
			model.put("packageImportList", packageImportList);

			String content = super.getTemplateService().getContent("domainWithUpperCase.ftl", model);

			// write to file
			StringBuilder nameBuilder = new StringBuilder();
			nameBuilder.append(t.getJavaObjectCamelName()).append(Constants.EXTEND_JAVA);

			StringBuilder pathBuilder = new StringBuilder();
			pathBuilder.append( config.getRealpath_dao()+t.getJavaObjectCamelNametoLowerCase()+"\\model").append(File.separator).append(nameBuilder);
			System.err.println(pathBuilder.toString());
			logger.info(internal.getString("log.generator.run.file", nameBuilder.toString(), pathBuilder.toString()));

			super.writeToFile(pathBuilder.toString(), content);

		}
	}

}
