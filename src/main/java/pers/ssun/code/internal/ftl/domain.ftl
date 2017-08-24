package ${config.package_prefix}.${table.javaObjectCamelNametoLowerCase}.model;

import java.io.Serializable;
<#list packageImportList as packageImport>
import ${packageImport};
</#list>

import ${config.package_prefix_commons}.model.BaseModel;

/**
 * Coder AutoGenerator generate.
 *
 * @author Coder AutoGenerator by Jiang,JiaYong
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public class ${table.javaObjectCamelName} extends BaseModel implements Serializable {

	private static final long serialVersionUID = -1L;

	<#list table.columnList as col>
	private ${col.javaTypeShortName} ${col.column_name?lower_case};
	
	</#list>
	public ${table.javaObjectCamelName}() {

	}

	<#list table.columnList as col>
	<#if col.remarks?? && col.remarks != ''>
	/**
	 * @val ${col.remarks?replace('\n', '\n	 * @val ')}
	 */
	</#if>
	public ${col.javaTypeShortName} get${col.column_name?lower_case?cap_first}() {
		return ${col.column_name?lower_case};
	}
	
	<#if col.remarks?? && col.remarks != ''>
	/**
	 * @val ${col.remarks?replace('\n', '\n	 * @val ')}
	 */
	</#if>
	public void set${col.column_name?lower_case?cap_first}(${col.javaTypeShortName} ${col.column_name?lower_case}) {
		this.${col.column_name?lower_case} = ${col.column_name?lower_case};
	}
	
	</#list>
}