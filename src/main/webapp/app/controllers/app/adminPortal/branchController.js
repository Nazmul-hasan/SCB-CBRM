
'use strict';

define(['app'], function (app) {
    
	 var branchController = function ($rootScope, $scope, $log, $timeout, $route,$routeParams, _, messageService, 
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService,branchService) {
		 
		var userInfo, promis;

		$scope.saveBranch=function(branch){
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			$scope.branchObj = branch;
			$scope.branchObj.loginBean = userInfo;
			$scope.branchObj.operation = constantService.Save;		
			promis = branchService.postObject($scope.branchObj);
			promis.then(function(data) {
				if (!data.success) {
					messageService.showMessage(constantService.Danger,data.message);
					return;
				}
				messageService.showMessage(constantService.Success,data.message);
				$scope.branch= {};
			});
		};
		
		var getBranchByID = function() {
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var Obj = {
			 operation : constantService.GetByOId,
			 loginBean : userInfo
		    };
			Obj.oid = $routeParams.oid;
		    promis =branchService.postObject(Obj);
		    debugger;
		    promis.then(function(data) {
			if (!data.success) {
				messageService.showMessage(constantService.Danger, 'Unable to load branch');
				return;
			}
			$scope.branch = data.data;
		});
	 };
	
	 	var init = function () {
	 		if ($routeParams.oid == undefined || $routeParams.oid == null || $routeParams.oid.length == 0) {
				return;
			}
	 		getBranchByID();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('branchController', ['$rootScope', '$scope', '$log', '$timeout', '$route','$routeParams', '_',
          'messageService', 'dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService','branchService', branchController]);
   
	
});

