
'use strict';

define(['app'], function (app) {

	var userService = function ($resource, $q, configurationService) {
		
		var userResource, delay;
        
		userResource = $resource(configurationService.userRestUrl, {}, {
			
            getAllUsers                  : { method: 'POST'},
            getFilteredItemBySelectedKey : { method: 'POST'},
            changeStatus                 : { method: 'POST'},
            saveUser                     : { method: 'POST'},
            getUserByloginid             : { method: 'POST'},
            updateUser                   : { method: 'POST'}
            
            
        });
		
        this.getAllUsers = function (obj) {
        	
            delay = $q.defer();
            userResource.getAllUsers(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.saveUser = function (obj) {
             delay = $q.defer();
            userResource.saveUser(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        this.updateUser = function (obj) {
            delay = $q.defer();
           userResource.updateUser(obj, function (data) {
               delay.resolve(data);
           }, function () {
               delay.reject('Unable to fetch..');
           });
           return delay.promise;
       };
       
        this.getFilteredItemBySelectedKey = function (obj) {
        	debugger;
            delay = $q.defer();
            userResource.getFilteredItemBySelectedKey(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        

        this.isEmpty = function(){
        	var b = new Boolean(true);
        	var loginId = $('#txtLoginId').val();
        	if (loginId === '') 
        	{
        		$("#validaTionLoginId").show();
           		b = false;
        	} 
        	else 
        	{
        		$("#validaTionLoginId").hide();
        	}
        	var password = $('#txtPassword').val();
        	if (password === '') 
        	{
        		$("#validaTionPassword").show();
           		b = false;
        	} 
        	else 
        	{
        		$("#validaTionPassword").hide();
        	}
        	var confirmPassword = $('#txtConfirmPassword').val();
        	if (confirmPassword === '') 
        	{
        		$("#validaTionConfirmPassword").show();
           		b = false;
        	} 
        	else 
        	{
        		$("#validaTionConfirmPassword").hide();
        	}
        	var primaryRole = $('#ddlPrimaryRole').val();
        	if (primaryRole === '') 
        	{
        		$("#validaTionPrimaryRole").show();
           		b = false;
        	} 
        	else 
        	{
        		$("#validaTionPrimaryRole").hide();
        	}
        	var status = $('#ddlStatus').val();
        	
        	if (status === '') 
        	{
        		$("#validaTionStatus").show();
           		b = false;
        	} 
        	else 
        	{
        		$("#validaTionStatus").hide();
        	}
        	
        };
        
         this.isNotSame =function(){
       	 var b = new Boolean(true);
       	
       	 	var newPwd =  $('#txtPassword').val();
       	    var conPwd =  $('#txtConfirmPassword').val();
       	 
       	 if (newPwd !== conPwd) {
        		$("#validationNewPwdAndConfirmPwd").show();
        		$("#validaTionConfirmPassword").hide();
        		b = false;
		    }
       	 else {
        		$("#validationNewPwdAndConfirmPwd").hide();
        	}
       	 return b;
        }

        this.changeStatus = function (obj) {
            delay = $q.defer();
            userResource.changeStatus(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;

        };
        
        this.getUserByloginid=function(obj){
        	delay = $q.defer();
        	userResource.getUserByloginid(obj, function (data) {
                 delay.resolve(data);
             }, function () {
                 delay.reject('Unable to fetch..');
             });
             return delay.promise;
        };
        
        
    };
    
    app.service('userService', ['$resource', '$q', 'configurationService', userService]);

});

