package ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.mapper.${table.javaObjectCamelName}Mapper;
import ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.model.${table.javaObjectCamelName};
import ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.service.${table.javaObjectCamelName}Service;

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Jiang,JiaYong
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service(value="${table.javaObjectCamelName?uncap_first}Service")
public class ${table.javaObjectCamelName}ServiceImpl implements ${table.javaObjectCamelName}Service {

	@Autowired
	private ${table.javaObjectCamelName}Mapper ${table.javaObjectCamelName?uncap_first}Mapper;
	

	public Integer create${table.javaObjectCamelName}(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Mapper.insert(t);
	}

	public ${table.javaObjectCamelName} get${table.javaObjectCamelName}(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Mapper.select(t);
	}

	public Integer get${table.javaObjectCamelName}Count(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Mapper.selectCount(t);
	}

	public List<${table.javaObjectCamelName}> get${table.javaObjectCamelName}List(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Mapper.selectList(t);
	}

	public int modify${table.javaObjectCamelName}(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Mapper.update(t);
	}

	public int remove${table.javaObjectCamelName}(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Mapper.delete(t);
	}

	public List<${table.javaObjectCamelName}> get${table.javaObjectCamelName}PaginatedList(${table.javaObjectCamelName} t) {
		return this.${table.javaObjectCamelName?uncap_first}Mapper.selectPaginatedList(t);
	}

}
