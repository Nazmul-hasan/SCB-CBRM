
'use strict';

define(['app'], function (app) {
    
	 var testController = function ($rootScope, $scope, $log, $timeout, $route,$routeParams, _, messageService, 
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService,testService) {
		 
		var userInfo, promis;

		$scope.saveTest=function(test){
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			$scope.testObj = test;
			$scope.testObj.loginBean = userInfo;
			$scope.testObj.operation = constantService.Save;		
			promis = testService.postObject($scope.testObj);
			promis.then(function(data) {
				if (!data.success) {
					messageService.showMessage(constantService.Danger,data.message);
					return;
				}
				messageService.showMessage(constantService.Success,data.message);
				$scope.test= {};
			});
		};
		
		var getTestByID = function() {
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var Obj = {
			 operation : constantService.GetByOId,
			 loginBean : userInfo
		    };
			Obj.oid = $routeParams.oid;
		    promis =testService.postObject(Obj);
		    debugger;
		    promis.then(function(data) {
			if (!data.success) {
				messageService.showMessage(constantService.Danger, 'Unable to load test');
				return;
			}
			$scope.test = data.data;
		});
	 };
	
	 	var init = function () {
	 		if ($routeParams.oid == undefined || $routeParams.oid == null || $routeParams.oid.length == 0) {
				return;
			}
	 		getTestByID();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('testController', ['$rootScope', '$scope', '$log', '$timeout', '$route','$routeParams', '_',
          'messageService', 'dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService','testService', testController]);
   
	
});

