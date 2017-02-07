/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/

package com.testallservicesforvcs.adventureworks2014.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.model.CustomProcedure;
import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

@Service
public class AdventureWorks2014ProcedureExecutorServiceImpl_V1 implements AdventureWorks2014ProcedureExecutorService_V1 {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdventureWorks2014ProcedureExecutorServiceImpl_V1.class);

	@Autowired
	@Qualifier("AdventureWorks2014WMProcedureExecutor")
	private WMProcedureExecutor procedureExecutor;


	@Transactional(value = "AdventureWorks2014TransactionManager")
	@Override
	public List<Object> executeGetdeptInfo(java.lang.Integer deptid)
	throws QueryParameterMismatchException{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("deptid", deptid);
        return procedureExecutor.executeNamedProcedure("GetdeptInfo", params);

	}

	@Transactional(value = "AdventureWorks2014TransactionManager")
	@Override
	public List<Object> executeWMCustomProcedure(CustomProcedure procedure) {
	    return procedureExecutor.executeCustomProcedure(procedure);
	}


}

