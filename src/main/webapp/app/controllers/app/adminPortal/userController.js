
'use strict';

define(['app'], function (app) {
    
    var userController = function ($scope, $location, $filter,$route, $log, $modal,$routeParams, constantService, 
		localStorageService, confirmationService, messageService,navigationService,userService,employeeService,roleService) {
    	
    	
    	var userInfo, promis;
    	$scope.userinformation = { };
    	
    		
    	$scope.PageTitle= 'User Entry Form';
    	$scope.buttonText = 'Add User';
    	var Password =0;
    	$scope.saveUser = function (userObj) {
    		if (!userService.isEmpty()) {
         	}
    		if(!userService.isNotSame()){
    			return;
    		}
    		var items = userObj.selectedItems;
    		
    		if(items!= undefined )
    			{
    			var strRoles = "[";
    			
        		for ( var i = 0; i < items.length; i++) {
    				if (i < items.length - 1) {
    					strRoles += '"'+items[i].roleID +'"'+ ",";
    				}
    				else 
    					{
    					strRoles += '"'+items[i].roleID +'"';
    					}
    			}
        		
        		 strRoles +="]";
    			}
    	
    		userObj.loginBean = userInfo;
    		/*if (strRoles === undefined) {
    	       userObj.roleJSON = 'NULL';
			}*/
    		userObj.roleJSON = strRoles;
    		if($scope.PageTitle =='User Modification Form')
    			{
    			userObj.operation = constantService.Update;
    			}
    		else{
    			userObj.operation = constantService.Save;
    		}
    		
        	promis = userService.saveUser(userObj);
            promis.then(function (data) {
            	if (!data.success) {
                    messageService.showMessage(constantService.Danger, data.message);
                    return;
                }           	
                messageService.showMessage(constantService.Success, data.message);
   		     	$scope.userinformation = { };
   		     	
            });            
		     
		};
		
		$scope.goBackInUserListPage = function(){
			navigationService.menuNavigation('userlist')
		};
		$scope.goHome = function(){
	    	 constantService.navigateToRespectiveDashboard();
	     };
		var getAllEmployeeAsuser = function(){
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var obj = {operation:constantService.GetAll,loginBean:userInfo};
			promis = employeeService.getAllEmployees(obj);
			promis.then(function(data){
				if(!data.success){
					messageService.showMessage(constantService.Danger,'Unable to load User ');
					return;
				}
				$scope.users = data.data;
			});
		};
		
		var addUser = function (){
			
		};
		
		 var getUserByloginid = function () {

	        	var userObject = { operation : constantService.GetByID,loginBean : userInfo };
	        	userObject.loginid = $routeParams.loginid;
	        	promis = userService.getUserByloginid(userObject);
	            promis.then(function (data) {
	            	if (!data.success) {
	                    //messageService.showMessage(constantService.Danger, 'Unable to load user');
	                    return;
	                } 
	               	console.log(data.data);
	               	data.data.confirmPassword = data.data.password;
	               	data.data.selectedItems = data.data.roleJSON;
	            	$scope.user = data.data;
	               	$scope.PageTitle= 'User Modification Form';
	               	$scope.buttonText = 'Update User';
      				$scope.clr='#656565';
     				$("#ddlUser").prop("readonly",true);
     				$("#txtPassword").prop("readonly",true);
     				$("#txtConfirmPassword").prop("readonly",true);
     				$("#txtLoginId").prop("readonly",true);
     				
	            });	  
	           	        	
	        };
	        
		 var getAllRoles = function(){
			var obj = {operation:constantService.GetAllRoels};
			promis = roleService.getAllRoles(obj);
			promis.then(function(data){
				if(!data.success){
					messageService.showMessage(constantService.Danger,'Unable to load Roles ');
					return;
				}
			  	 $scope.roles = data.data;
			  	 $scope.primaryRole    = _.sortBy(_.where($scope.roles, {roleType : 'P'}), 'roleID');
			  	 $scope.secoundaryRole = _.sortBy(_.where($scope.roles, {roleType : 'S'}), 'roleID');
			  	
			});
		};

		$scope.checkLoginId = function(loginId)
		{
			if (loginId == '' || loginId == undefined) {
				$("#validaTionLoginId").show();
				
			} else {
				$("#validaTionLoginId").hide();
			}
		};
		
		$scope.checkPassword = function(password)
		{
			if (password == '' || password == undefined) {
				$("#validaTionPassword").show();
				
			} else {
				$("#validaTionPassword").hide();
			}
		};
		
		$scope.checkConfirmPassword = function(confirmPassword)
		{
			if (confirmPassword == '' || confirmPassword == undefined) {
				$("#validaTionConfirmPassword").show();
				
			} else {
				$("#validaTionConfirmPassword").hide();
			}
		};
		
		$scope.checkRole = function(primaryRole)
		{
			if (primaryRole == '' || primaryRole == undefined || primaryRole == null) {
				$("#validaTionPrimaryRole").show();
				
			} else {
				$("#validaTionPrimaryRole").hide();
			}
		};
		
		$scope.checkStatus = function(status)
		{
			if (status == '' || status == undefined || status == null) {
				$("#validaTionStatus").show();
				
			} else {
				$("#validaTionStatus").hide();
			}
		};
		
		
		
		$scope.checkPasswordLength = function(Password){
			
			 if(Password == '' || Password == undefined || Password == null||Password.length<6) 
			 {
					$("#validaTionNewPasswordLength").show();
					$("#validaTionPassword").hide();
			 }
			
			 else 
			 {
					$("#validaTionNewPasswordLength").hide();
					$("#validaTionPassword").hide();
			 }
		};
		
      var init = function () {
    	
    	  		userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
    	  		//getAllEmployeeAsuser();
    	  		//getAllRoles();
    	  		if($routeParams.loginid != undefined ||$routeParams.loginid != null||$routeParams.loginid != "")
      			{
    	  			///getUserByloginid();
       				return;  	 
      			}
    	  		
	    	};    
	   
        init();
        
    };  
    app.register.controller('userController', ['$scope', '$location', '$filter', '$route','$log', '$modal','$routeParams',
           'constantService', 'localStorageService', 'confirmationService', 'messageService','navigationService','userService','employeeService','roleService',
           userController]);

});


