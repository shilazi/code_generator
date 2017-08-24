package pers.ssun.code.generator;

import org.springframework.stereotype.Service;
import pers.ssun.code.generator.impl.*;

import javax.annotation.Resource;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.03
 */
@Service("generatorFacatory")
public class GeneratorFactory {
	@Resource
	private DomainGenerator domainGenerator;

	@Resource
	private DaoGenerator daoGenerator;

	@Resource
	private DaoImplGenerator daoImplGenerator;

	@Resource
	private ServiceGenerator serviceGenerator;

	@Resource
	private ServiceImplGenerator serviceImplGenerator;

	@Resource
	private IbatisSqlMapXmlGenerator ibatisSqlMapXmlGenerator;

	@Resource
	private IbatisSqlMapConfigXmlGenerator ibatisSqlMapConfigXmlGenerator;

	@Resource
	private FacadeGenerator facadeGenerator;

	@Resource
	private FacadeImplGenerator facadeImplGenerator;

	public DomainGenerator getDomainGenerator() {
		return domainGenerator;
	}

	public DaoGenerator getDaoGenerator() {
		return daoGenerator;
	}

	public DaoImplGenerator getDaoImplGenerator() {
		return daoImplGenerator;
	}

	public ServiceGenerator getServiceGenerator() {
		return serviceGenerator;
	}

	public ServiceImplGenerator getServiceImplGenerator() {
		return serviceImplGenerator;
	}

	public IbatisSqlMapXmlGenerator getIbatisSqlMapXmlGenerator() {
		return ibatisSqlMapXmlGenerator;
	}

	public IbatisSqlMapConfigXmlGenerator getIbatisSqlMapConfigXmlGenerator() {
		return ibatisSqlMapConfigXmlGenerator;
	}

	public FacadeGenerator getFacadeGenerator() {
		return facadeGenerator;
	}

	public FacadeImplGenerator getFacadeImplGenerator() {
		return facadeImplGenerator;
	}

}
