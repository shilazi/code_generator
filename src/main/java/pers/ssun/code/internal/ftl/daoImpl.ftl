package ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.mapper.mybatis;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.mapper.${table.javaObjectCamelName}Mapper;
import ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.model.${table.javaObjectCamelName};
import ${config.package_prefix_commons}.mapper.mybatis.EntityMybatisSqlMapImpl;

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Jiang,JiaYong
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Component(value="${table.javaObjectCamelNametoLowerCase}Mapper")
public class ${table.javaObjectCamelName}MapperSqlMapImpl extends EntityMybatisSqlMapImpl<${table.javaObjectCamelName}> implements ${table.javaObjectCamelName}Mapper {

}
