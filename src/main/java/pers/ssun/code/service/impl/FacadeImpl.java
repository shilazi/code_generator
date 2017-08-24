package pers.ssun.code.service.impl;

import org.springframework.stereotype.Service;
import pers.ssun.code.service.Facade;
import pers.ssun.code.service.TableService;

import javax.annotation.Resource;

/**
 * @author Xing,XiuDong
 * @version builder 2010.02.02
 */
@Service("facade")
public class FacadeImpl implements Facade {

	@Resource
	TableService tableService;

	public TableService getTableService() {
		return tableService;
	}

}
