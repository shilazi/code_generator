package pers.ssun.code.service.impl;

import freemarker.template.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.ssun.code.service.TemplateService;

import java.io.*;
import java.util.Map;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.02
 */
public class TemplateServiceFreeMarkerDefaultImpl implements TemplateService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String templateLoaderPath;

	public String getContent(String templateName, Map<String, Object> model) {
		try {
			/* Create and adjust the configuration */
			Configuration cfg = new Configuration();

			// this.getClass().getResource("/").getPath()
			String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

			String path = classpath + templateLoaderPath;

			FileUtils.forceMkdir(new File(path));
			cfg.setDirectoryForTemplateLoading(new File(path));
			cfg.setObjectWrapper(new DefaultObjectWrapper());

			/* Get or create a template */
			Template template = cfg.getTemplate(templateName);

			/* Merge data-model with template */
			StringWriter writer = new StringWriter();
			template.process(model, writer);

			return writer.toString();
		} catch (TemplateException e) {
			logger.error("Error while processing FreeMarker template ", e);
		} catch (FileNotFoundException e) {
			logger.error("Error while open template file ", e);
		} catch (IOException e) {
			logger.error("Error while generate Email Content ", e);
		}
		return null;
	}

	public void setTemplateLoaderPath(String templateLoaderPath) {
		this.templateLoaderPath = templateLoaderPath;
	}
}
