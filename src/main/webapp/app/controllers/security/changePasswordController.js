
'use strict';

define(['app'], function (app) {
    
    var changePasswordController = function ($scope, $location, $filter, $log, $modal,$routeParams, constantService, 
		localStorageService, confirmationService, messageService,navigationService,signInService,ngProgress) {
    
    	var userInfo, promis;
    	$scope.passwordChangeObj = { };
       	$scope.PageTitle= 'Change Password Form';
    	$scope.buttonText = ' Change Password';
    	$scope.oldPasswordInSession;
    
		$scope.changePassword = function(passwordChangeObj){
	    		userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
	    		if (!signInService.isBlank()) {
	         		return; 
	         	}
	    	    else if (!signInService.isNotSame()) {
	         		return; 
	         	}
	    		else if(!signInService.isSameValue()){
	    			return;
	    		}
    			var obj = 		
			 		{
					 operation 							: constantService.GetOldPassword,
					 password							: userInfo.password,
					 loginId							: userInfo.loginId,
					 newPassword						: passwordChangeObj.newPassword,
					 oldPassword						: passwordChangeObj.oldPassword 
					 };
   
			 	promis = signInService.doChangePassword(obj);
	            promis.then(function (data) {
	            	if (!data.success) {
	            		messageService.showMessage(constantService.Danger, data.message);
	   	                return;
	                }
	            	messageService.showMessage(constantService.Success, data.message);
	             	localStorageService.setValue(constantService.userInfoCookieStoreKey, userInfo);
	            });   
		 };
		 
		 $scope.goHome = function(){
	    	 constantService.navigateToRespectiveDashboard();
	     };
		 
		 $scope.checkOldPassword = function(oldPassword)
			{
				if (oldPassword == '' || oldPassword == undefined) {
					$("#validaTionOldPassword").show();
					$("#validationInvalidOldPassword").hide();
				} else {
					$("#validaTionOldPassword").hide();
				}
			};
		 
		 $scope.checkNewPassword = function(newPassword)
			{
				if (newPassword == '' || newPassword == undefined) {
					$("#validaTionNewPassword").show();
					$("#validaTionNewPasswordLength").hide();
				} else {
					$("#validaTionNewPassword").hide();
				}
			};
			
			$scope.checkPasswordLength = function(newPassword){
				 if(newPassword.length<6){
						$("#validaTionNewPasswordLength").show();
						$("#validaTionNewPassword").hide();
					}else {
						$("#validaTionNewPasswordLength").hide();
					}
			};
			$scope.checkOldPwd = function(oldPassword){
				userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
				if(userInfo.password!==oldPassword){
					$("#validationInvalidOldPassword").show();
					$("#validaTionOldPassword").hide();
				}else {
					$("#validationInvalidOldPassword").hide();
				}
			};
			
			$scope.checkConfirmPassword = function(confirmPassword)
			{
				if (confirmPassword == '' || confirmPassword == undefined) {
					$("#validationConfirmPassword").show();
					$("#validationNewPwdAndConfirmPwd").hide();
				} else {
					$("#validationConfirmPassword").hide();
				}
			};
			
          var init = function () {
        	
           	  userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
	      	    
	    	};    
	    	
        init();
        
    };  
    app.register.controller('changePasswordController', ['$scope', '$location', '$filter', '$log', '$modal','$routeParams',
           'constantService', 'localStorageService', 'confirmationService', 'messageService','navigationService','signInService','ngProgress',
           changePasswordController]);

});


