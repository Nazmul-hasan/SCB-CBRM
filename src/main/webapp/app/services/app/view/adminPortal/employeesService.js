
'use strict';

define(['app'], function (app) {

	var employeeService = function ($resource, $q, configurationService) {
		
		var employeeResource, delay;
        
		employeeResource = $resource(configurationService.employeeRestUrl, {}, {
            saveEmployee: 	 				        { method: 'POST'},
            getAllEmployees: 				        { method: 'POST'},
            getEmployeeByID: 				        { method: 'POST'},
            changeStatus:	 				        { method: 'POST'},
            getEmployeeWithID: 				        { method: 'POST'},
            getLoginglogInfoByID:			        { method: 'POST'},
            get12MonthsTotal : 				        { method: 'POST'},
            saveSkillMatrix:                        { method: 'POST'},
            getAllEmployeesWithEvaluateMapping :    { method: 'POST'},
            getAllEmployeesNameAndID :    			{ method: 'POST'},
            getAllEmployeeOfSameDesignation	: 		{ method: 'POST'}
		
		});
        
		this.saveEmployee = function (obj) {
            delay = $q.defer();
            employeeResource.saveEmployee(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        
        
        
        this.saveSkillMatrix = function (obj)
        {
            delay = $q.defer();
            employeeResource.saveSkillMatrix(obj, function (data)
            		{
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.getAllEmployeesWithEvaluateMapping = function (obj) {
            delay = $q.defer();
            employeeResource.getAllEmployeesWithEvaluateMapping(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        
        
        
        
        this.getAllEmployees = function (obj) {
            delay = $q.defer();
            employeeResource.getAllEmployees(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.getAllEmployeesNameAndID = function (obj) {
            delay = $q.defer();
            employeeResource.getAllEmployeesNameAndID(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.getEmployeeByID = function (obj) {
            delay = $q.defer();
            employeeResource.getEmployeeByID(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.changeStatus = function (obj) {
        	debugger;
            delay = $q.defer();
            employeeResource.changeStatus(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.getEmployeeWithID = function (obj) {
            delay = $q.defer();
            employeeResource.getEmployeeWithID(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        
        
        
        this.getLoginglogInfoByID = function (obj) {
            delay = $q.defer();
            employeeResource.getLoginglogInfoByID(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.get12MonthsTotal = function(obj){
          	delay = $q.defer();
          	employeeResource.get12MonthsTotal(obj, function (data) {
                     delay.resolve(data);
                 }, function () {
                     delay.reject('Unable to fetch..');
                 });
                 return delay.promise;
            };
        
	    this.getAllEmployeeOfSameDesignation = function (obj) {
	        delay = $q.defer();
	        employeeResource.getAllEmployeeOfSameDesignation(obj, function (data) {
	            delay.resolve(data);
	        }, function () {
	            delay.reject('Unable to fetch..');
	        });
	        return delay.promise;
	    };
        	this.isBlank=function() {
        	var b = new Boolean(true);
        	
        	var empName = $('#txtEmpName').val();
        	
        	if (empName === '') 
        	{
        		$("#validaTionEmployeeName").show();
           		b = false;
        		
        	} 
        	else 
        	{
        		$("#validaTionOldPassword").hide();
        	}
        	
        	var empEmail = $('#txtEmpEmail').val();
        	
        	if (empEmail === '') 
        	{
        		$("#validaTionEmployeeEmail").show();
           		b = false;
        	}
        	else 
        	{
        		$("#validaTionEmployeeEmail").hide();
        	}
        	
        	var contactNumber = $('#EmpContactNumber').val();
        	
        	if (contactNumber === '') 
        	{
        		$("#validaTionEmployeeContactNumber").show();
        	
        		b = false;
        	} 
        	else 
        	{
        		$("#validaTionEmployeeContactNumber").hide();
        	}
        	
        	var empPresentAddress = $('#txtPresentAddress').val();
        	
        	if (empPresentAddress === '') 
        	{
        		$("#validaTionEmployeePresentAddress").show();
        	
        		b = false;
        	} 
        	else 
        	{
        		$("#validaTionEmployeePresentAddress").hide();
        	}
        	
        	var empNameOfTier = $('#ddlTier').val();
        	if (empNameOfTier === '') 
        	{
        		$("#s2id_ddlTier input").focus();
        		$("#validaTionEmployeeTier").show();        	
        		b = false;
        	} 
        	else 
        	{
        		$("#validaTionEmployeeTier").hide();
        	}
        	return b;
        } 
         
        
        
    };
    
    app.service('employeeService', ['$resource', '$q', 'configurationService', employeeService]);

});

