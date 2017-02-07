/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.testallservicesforvcs.adventureworks2014.TableName;
import com.testallservicesforvcs.adventureworks2014.service.TableNameService;

/**
 * Controller object for domain model class TableName.
 * @see TableName
 */
@RestController("AdventureWorks2014.TableNameController")
@Api(value = "TableNameController", description = "Exposes APIs to work with TableName resource.")
@RequestMapping("/AdventureWorks2014/TableName")
public class TableNameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableNameController.class);

    @Autowired
    @Qualifier("AdventureWorks2014.TableNameService")
    private TableNameService tableNameService;

    @ApiOperation(value = "Creates a new TableName instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TableName createTableName(@RequestBody TableName tableName) {
        LOGGER.debug("Create TableName with information: {}", tableName);
        tableName = tableNameService.create(tableName);
        LOGGER.debug("Created TableName with information: {}", tableName);
        return tableName;
    }

    @ApiOperation(value = "Returns the TableName instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TableName getTableName(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TableName with id: {}", id);
        TableName foundTableName = tableNameService.getById(id);
        LOGGER.debug("TableName details with id: {}", foundTableName);
        return foundTableName;
    }

    @ApiOperation(value = "Updates the TableName instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TableName editTableName(@PathVariable("id") Integer id, @RequestBody TableName tableName) throws EntityNotFoundException {
        LOGGER.debug("Editing TableName with id: {}", tableName.getColumn1());
        tableName.setColumn1(id);
        tableName = tableNameService.update(tableName);
        LOGGER.debug("TableName details with id: {}", tableName);
        return tableName;
    }

    @ApiOperation(value = "Deletes the TableName instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTableName(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TableName with id: {}", id);
        TableName deletedTableName = tableNameService.delete(id);
        return deletedTableName != null;
    }

    /**
     * @deprecated Use {@link #findTableNames(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TableName instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TableName> searchTableNamesByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TableNames list");
        return tableNameService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of TableName instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TableName> findTableNames(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TableNames list");
        return tableNameService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTableNames(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return tableNameService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of TableName instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countTableNames(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TableNames");
        return tableNameService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TableNameService instance
	 */
    protected void setTableNameService(TableNameService service) {
        this.tableNameService = service;
    }
}
