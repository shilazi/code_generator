<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${config.package_prefix}.${table.javaObjectCamelName?uncap_first}.mapper.${table.javaObjectCamelName}Mapper">
 	<resultMap id="${table.javaObjectCamelName?uncap_first}ResultForList" type="${table.javaObjectCamelName?uncap_first}">
		<#list table.columnList as col>
			<result column="${col.column_name}" property="${col.column_name?lower_case}" jdbcType="${col.jdbcTypeShortName}" />
		</#list>
	</resultMap>
	
	<resultMap id="${table.javaObjectCamelName?uncap_first}Result" type="${table.javaObjectCamelName?uncap_first}" extends="${table.javaObjectCamelName?uncap_first}ResultForList">
	</resultMap>
	
	<sql id="sf-${table.javaObjectCamelName?uncap_first}">
		<#list table.columnList as col>
			<if test="${col.column_name?lower_case} != null"> AND ${col.column_name?lower_case}=${config.x}{${col.column_name?lower_case},jdbcType=${col.jdbcTypeShortName}}</if>
		</#list>
	</sql>
	
	<select id="select" resultMap="${table.javaObjectCamelName?uncap_first}Result" parameterType="${table.javaObjectCamelName?uncap_first}"  >
		select * from ${table.table_name}  where 1 = 1
		<include refid="sf-${table.javaObjectCamelName?uncap_first}" />  
	</select>
	
  	<select id="selectList" resultMap="${table.javaObjectCamelName?uncap_first}ResultForList" parameterType="${table.javaObjectCamelName?uncap_first}"  >
		select * from ${table.table_name}  where 1 = 1
		<include refid="sf-${table.javaObjectCamelName?uncap_first}" />  
		<if test="row.count != null"> limit ${config.x}{row.first,jdbcType=INTEGER},${config.x}{row.count,jdbcType=INTEGER}</if>
	</select>
 
 	<select id="selectCount" resultType="int" parameterType="${table.javaObjectCamelName?uncap_first}"  >
		select count(1) from ${table.table_name} where 1 = 1
		<include refid="sf-${table.javaObjectCamelName?uncap_first}" />  
	</select>
	
	<select id="selectPaginatedList" resultMap="${table.javaObjectCamelName?uncap_first}ResultForList" parameterType="${table.javaObjectCamelName?uncap_first}"  >
		select * from ${table.table_name}  where 1 = 1
		<include refid="sf-${table.javaObjectCamelName?uncap_first}" />  
		<if test="row.count != null"> limit ${config.x}{row.first,jdbcType=INTEGER},${config.x}{row.count,jdbcType=INTEGER}</if>
	</select>
 
 	<insert id="insert" parameterType="${table.javaObjectCamelName?uncap_first}">
		<selectKey keyProperty="id" resultType="java.lang.Integer">
            select LAST_INSERT_ID()
        </selectKey>
		insert into ${table.table_name}
		<trim prefix="(" suffix=")" suffixOverrides=",">
			<#list table.columnList as col>
				<if test="${col.column_name?lower_case} != null">${col.column_name?lower_case},</if>
			</#list>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
			<#list table.columnList as col>
				<if test="${col.column_name?lower_case}!= null">${config.x}{${col.column_name?lower_case},jdbcType=${col.jdbcTypeShortName}},</if>
			</#list>
		</trim>
	</insert>

	<update id="update" parameterType="${table.javaObjectCamelName?uncap_first}">
		update ${table.table_name}
		<set>
			<#list table.columnList as col>
				<if test="${col.column_name?lower_case}!= null">${col.column_name?lower_case}=${config.x}{${col.column_name?lower_case},jdbcType=${col.jdbcTypeShortName}},</if>
			</#list>
		</set>
		where id = ${config.x}{id,jdbcType=INTEGER}
	</update>

 	
 	<delete id="delete" parameterType="${table.javaObjectCamelName?uncap_first}">
		delete from  ${table.table_name} where 
		<if test="id!= null">id=${config.x}{id,jdbcType=INTEGER}</if>
		<if test="id== null">id in 
			<foreach collection="map.pks" index="index" item="item" open="(" separator="," close=")">   
        	${config.x}{item}  
    		</foreach>  
		</if>
	</delete>

</mapper>