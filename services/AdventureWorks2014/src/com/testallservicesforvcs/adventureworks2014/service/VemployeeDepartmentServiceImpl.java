/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testallservicesforvcs.adventureworks2014.VemployeeDepartment;
import com.testallservicesforvcs.adventureworks2014.VemployeeDepartmentId;


/**
 * ServiceImpl object for domain model class VemployeeDepartment.
 *
 * @see VemployeeDepartment
 */
@Service("AdventureWorks2014.VemployeeDepartmentService")
public class VemployeeDepartmentServiceImpl implements VemployeeDepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VemployeeDepartmentServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2014.VemployeeDepartmentDao")
    private WMGenericDao<VemployeeDepartment, VemployeeDepartmentId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VemployeeDepartment, VemployeeDepartmentId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
    @Override
	public VemployeeDepartment create(VemployeeDepartment vemployeeDepartment) {
        LOGGER.debug("Creating a new VemployeeDepartment with information: {}", vemployeeDepartment);
        VemployeeDepartment vemployeeDepartmentCreated = this.wmGenericDao.create(vemployeeDepartment);
        return vemployeeDepartmentCreated;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public VemployeeDepartment getById(VemployeeDepartmentId vemployeedepartmentId) throws EntityNotFoundException {
        LOGGER.debug("Finding VemployeeDepartment by id: {}", vemployeedepartmentId);
        VemployeeDepartment vemployeeDepartment = this.wmGenericDao.findById(vemployeedepartmentId);
        if (vemployeeDepartment == null){
            LOGGER.debug("No VemployeeDepartment found with id: {}", vemployeedepartmentId);
            throw new EntityNotFoundException(String.valueOf(vemployeedepartmentId));
        }
        return vemployeeDepartment;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public VemployeeDepartment findById(VemployeeDepartmentId vemployeedepartmentId) {
        LOGGER.debug("Finding VemployeeDepartment by id: {}", vemployeedepartmentId);
        return this.wmGenericDao.findById(vemployeedepartmentId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "AdventureWorks2014TransactionManager")
	@Override
	public VemployeeDepartment update(VemployeeDepartment vemployeeDepartment) throws EntityNotFoundException {
        LOGGER.debug("Updating VemployeeDepartment with information: {}", vemployeeDepartment);
        this.wmGenericDao.update(vemployeeDepartment);

        VemployeeDepartmentId vemployeedepartmentId = new VemployeeDepartmentId();
        vemployeedepartmentId.setBusinessEntityId(vemployeeDepartment.getBusinessEntityId());
        vemployeedepartmentId.setTitle(vemployeeDepartment.getTitle());
        vemployeedepartmentId.setFirstName(vemployeeDepartment.getFirstName());
        vemployeedepartmentId.setMiddleName(vemployeeDepartment.getMiddleName());
        vemployeedepartmentId.setLastName(vemployeeDepartment.getLastName());
        vemployeedepartmentId.setSuffix(vemployeeDepartment.getSuffix());
        vemployeedepartmentId.setJobTitle(vemployeeDepartment.getJobTitle());
        vemployeedepartmentId.setDepartment(vemployeeDepartment.getDepartment());
        vemployeedepartmentId.setGroupName(vemployeeDepartment.getGroupName());
        vemployeedepartmentId.setStartDate(vemployeeDepartment.getStartDate());

        return this.wmGenericDao.findById(vemployeedepartmentId);
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
	@Override
	public VemployeeDepartment delete(VemployeeDepartmentId vemployeedepartmentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting VemployeeDepartment with id: {}", vemployeedepartmentId);
        VemployeeDepartment deleted = this.wmGenericDao.findById(vemployeedepartmentId);
        if (deleted == null) {
            LOGGER.debug("No VemployeeDepartment found with id: {}", vemployeedepartmentId);
            throw new EntityNotFoundException(String.valueOf(vemployeedepartmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<VemployeeDepartment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VemployeeDepartments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<VemployeeDepartment> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VemployeeDepartments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table VemployeeDepartment to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

