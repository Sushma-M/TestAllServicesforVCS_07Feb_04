/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/

package com.testallservicesforvcs.adventureworks2014.service;

import java.util.Map;
import java.util.List;


import com.wavemaker.runtime.data.model.CustomProcedure;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

public interface AdventureWorks2014ProcedureExecutorService_V1 {

    List<Object> executeGetdeptInfo(java.lang.Integer deptid) throws QueryParameterMismatchException;


	
	List<Object> executeWMCustomProcedure(CustomProcedure procedure) ;


}

