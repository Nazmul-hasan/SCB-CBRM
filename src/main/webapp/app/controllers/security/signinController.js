
'use strict';

define(['app'], function (app) {
    
	 var signinController = function ($rootScope, $scope, _, $log, $timeout, $http, $cookieStore, signInService, 
		 navigationService, localStorageService, configurationService, constantService, authorizationService, 
		 messageService) {
		 
		 var promis;
		 
		 $scope.user = { loginId : 'asif', password : 'secl2013' };


		 $scope.signIn = function (login) {

			 if(!checkLoginForm(login))
				 {
				 	return;
				 }
			 login.operation = constantService.userlogin;
			 promis = signInService.doSignIn(login);
			 promis.then(function (data) {
				 
				 if (!data.success) {
					 if(data.message == 'Invalid login ID')
						 {
						 	$("#validationinvalidloginid").show();
						 	return;
						 }
					 if(data.message == 'Invalid Password')
						 {
						 	$("#validationinvalidpassword").show();
						 	return;
						 }
					 if(data.message == 'your Account is Locked')
					 {
						 messageService.showMessage(constantService.Danger,data.message);
					 	return;
					 }
					 if(data.data == 'invalid')
					 {
					 	$scope.ivdUsr = true;
					 	return;
					 }
					 return;
					 
				 }
				
				 
				 localStorageService.setValue(constantService.userInfoCookieStoreKey, data.data);
				
				 if(data.data.roleID == 'Employee')
					 {
					 	navigationService.menuNavigation("admindashboard");
					 }
				 else
					 {
					 	navigationService.menuNavigation("dashboard");
					 }
			 });
		};

		 $scope.signOut = function () {
		 	authorizationService.signOut();
		 };
			
		 
		 $scope.checkloginid = function(loginid)
			{
				if (loginid == '' || loginid == undefined) {
					$("#validationloginid").show();
					$("#validationinvalidloginid").hide();
					
				} else {
					$("#validationloginid").hide();
				}
		};
		 
		$scope.checkloginpwd = function(loginpwd)
			{
				if (loginpwd == '' || loginpwd == undefined) {
					$("#validationloginpwd").show();
					$("#validationinvalidpassword").hide();
					
				} 
				else 
				{
					$("#validationloginpwd").hide();
				}
			};
			
			
			
			$scope.divOn  = function() {
				$scope.isforgetPassword = true;	
				
			};
		    
		    $scope.cancelDiv  = function() {
		    	$("#validationemailid").hide();
		    	$scope.usermailinfo={};
		        $scope.isforgetPassword = false;
		        
		  };
		    
		  $scope.getUserInfoByEmailID = function(mObj){ 
			  	$scope.Info = '';
			    mObj.operation='GetByEmailID';
		    	promis = signInService.getUserInfoByEmailID(mObj);
		    	
		    	promis.then(function(data){
		    		
		    	if(!data.success)
		    	{	
		    		$scope.success = false;
		    		$scope.failled = true;
		    		return;
		    	}  
		    	$scope.usermailinfo.emailID = '';
		    	$scope.failled = false;
		    	$scope.success = true;
		    	$scope.Info = data.data; 
		    	$scope.sendMessageToMail($scope.Info);
		    	})
		    	
		    };
		   
			 var isEmailIDEmpty=function(Obj)
			  {
				 
				  $scope.usermailinfo=Obj;
				  if($scope.usermailinfo.emailID== null || $scope.usermailinfo.emailID== undefined){
		        		$("#validationemailid").show();
						 return true;
					 } 
				  return false;
				  
			  };
		      
		    $scope.sendMessageToMail=function(userObj)
		    { 
		      
			   
			   if($scope.Info.password!=null)
				{
				   $scope.Info.operation ='sendMailToResetPassword';
				   promis = signInService.sendPasswordResetMail($scope.Info);
		           promis.then(function (data) {
		        	   if (!data.success) 
		            	{
			    	    	$scope.Info ='';
		                    return;
		                }
		            	  
		            	  $scope.Info ='';
			     })
				}
			   
			   else if(!isEmailIDEmpty(userObj)&& ($scope.Info.password==null ||$scope.Info.password==undefined))
		       {
				  $scope.getUserInfoByEmailID(userObj);
		    	 
		       }	
		};
		  
		var checkLoginForm=function(login) {

			var b = new Boolean(true);
     	
     	if(login == null || login == undefined){
     		$("#validationloginid").show();
     		$("#validationloginpwd").show();
				 return;
			 }
     	
     	if (login.loginId === '' || login.loginId === undefined || login.loginId === null) {
     		
     		$("#validationloginid").show();
     		b = false;
     		
     	} else {
     		$("#validationloginid").hide();
     	}
     	
     	if (login.password === '' || login.password === undefined || login.password === null ) {
     		
     		$("#validationloginpwd").show();
     		b = false;
     	} else {
     		$("#validationloginpwd").hide();
     	}
     	
     	
     	return b;
     }; 
     
	 	var init = function () {
	 		$(".right-side").addClass("strech");
            $('.left-side').addClass("collapse-left");
	 	};

	 	init();
        
       
		 
 	};

 	
    app.register.controller('signinController', ['$rootScope', '$scope', '_','$log', '$timeout', '$http', '$cookieStore', 
        'signInService', 'navigationService', 'localStorageService', 'configurationService','constantService', 
        'authorizationService', 'messageService', signinController]);
   
	
});



