package ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.model;

import java.io.Serializable;
<#list packageImportList as packageImport>
import ${packageImport};
</#list>

import ${config.package_prefix_commons}.model.BaseModel;

/**
 * This place must write class javadoc.
 *
 * @author Shuai,Sun 	suns@izkml.com
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public class ${table.javaObjectCamelName} extends BaseDao {

	<#list table.columnList as col>
	<#if col.remarks?? && col.remarks != ''>
	/**
	 * ${col.remarks?replace('\n', '\n	 * @val ')}
	 */
	</#if>
	private ${col.javaTypeShortName} ${col.javaObjectCamelName?uncap_first};
	
	</#list>
	public ${table.javaObjectCamelName}() {

	}

	<#list table.columnList as col>
	<#if col.remarks?? && col.remarks != ''>
	/**
	 * ${col.remarks?replace('\n', '\n	 * @val ')}
	 */
	</#if>
	public ${col.javaTypeShortName} get${col.javaObjectCamelName?cap_first}() {
		return ${col.javaObjectCamelName?uncap_first};
	}
	
	<#if col.remarks?? && col.remarks != ''>
	/**
	 * ${col.remarks?replace('\n', '\n	 * @val ')}
	 */
	</#if>
	public void set${col.javaObjectCamelName?cap_first}(${col.javaTypeShortName} ${col.javaObjectCamelName?uncap_first}) {
		this.${col.javaObjectCamelName?uncap_first} = ${col.javaObjectCamelName?uncap_first};
	}
	
	</#list>
}