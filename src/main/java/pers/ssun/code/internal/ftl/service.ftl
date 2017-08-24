package ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.service;

import java.util.List;

import ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.model.${table.javaObjectCamelName};

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Jiang,JiaYong
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface ${table.javaObjectCamelName}Service {

	Integer create${table.javaObjectCamelName}(${table.javaObjectCamelName} t);

	int modify${table.javaObjectCamelName}(${table.javaObjectCamelName} t);

	int remove${table.javaObjectCamelName}(${table.javaObjectCamelName} t);

	${table.javaObjectCamelName} get${table.javaObjectCamelName}(${table.javaObjectCamelName} t);

	List<${table.javaObjectCamelName}> get${table.javaObjectCamelName}List(${table.javaObjectCamelName} t);

	Integer get${table.javaObjectCamelName}Count(${table.javaObjectCamelName} t);

	List<${table.javaObjectCamelName}> get${table.javaObjectCamelName}PaginatedList(${table.javaObjectCamelName} t);

}