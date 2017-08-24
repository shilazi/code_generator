package pers.ssun.code.init;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ssun.code.generator.GeneratorFactory;
import pers.ssun.code.internal.config.Configuration;
import pers.ssun.code.utils.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    /**
     * 工具类Main方法，执行入口
     * @param args nothing
     */
    public static void main(String[] args)  {
        try {
            new Main().run();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    public void run() throws SQLException, IOException {
        Date startTime = new Date();
        // 初始化spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:META-INF/spring/spring-context.xml" });
        BeanFactory factory = (BeanFactory) context;
        // 获取config.properties文件的值
        Configuration config = (Configuration) factory.getBean("config");
        // 获取message.properties文件的值
        Messages internal = (Messages) factory.getBean("internal");
        // 生成文件前是否清空目标文件夹
        if ("true".equalsIgnoreCase(config.getEmpty_before_files().trim())) {
            FileUtils.forceDelete(new File(config.getRealpath()));
        }

        GeneratorFactory generatorFactory = (GeneratorFactory) factory.getBean("generatorFactory");

        // Generator displays, you could choose unused to note
        generatorFactory.getDomainGenerator().generate();
        generatorFactory.getDaoGenerator().generate();
        //generatorFactory.getDaoImplGenerator().generate();
        generatorFactory.getIbatisSqlMapXmlGenerator().generate();
        generatorFactory.getServiceGenerator().generate();
        generatorFactory.getServiceImplGenerator().generate();
        generatorFactory.getFacadeGenerator().generate();
        generatorFactory.getFacadeImplGenerator().generate();
        generatorFactory.getIbatisSqlMapConfigXmlGenerator().generate();

        // if you pick up zip
        if (new Boolean(UtilsString.removeQuote(config.getWorkspace_zip()).trim())) {
            System.out.println(internal.getString("log.zip.going"));

            Date zipStartTime = new Date();
            String zipFilePath = config.getWorkspace() + config.getName() + "_v"
                    + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".zip";
            ZipUtil.zip(config.getRealpath(), zipFilePath);
            Date zipEndTime = new Date();

            System.out.println(internal.getString("log.zip.end", DateUtils.getTimeInterval(zipStartTime, zipEndTime),
                    zipFilePath));
        }

        Date endTime = new Date();
        System.out.println(internal.getString("log.generator.run.time", DateUtils.getTimeInterval(startTime, endTime),
                config.getRealpath()));

    }

}
