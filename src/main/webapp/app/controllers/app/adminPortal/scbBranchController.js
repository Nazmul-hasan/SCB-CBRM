
'use strict';

define(['app'], function (app) {
    
	 var scbBranchController = function ($rootScope, $scope, $log, $timeout, $route,$routeParams, _, messageService, 
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService,scbBranchService) {
		 
		var userInfo, promis;

		$scope.saveScbBranch=function(scbBranch){
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			$scope.scbBranchObj = scbBranch;
			$scope.scbBranchObj.loginBean = userInfo;
			$scope.scbBranchObj.operation = constantService.Save;		
			promis = scbBranchService.postObject($scope.scbBranchObj);
			promis.then(function(data) {
				if (!data.success) {
					messageService.showMessage(constantService.Danger,data.message);
					return;
				}
				messageService.showMessage(constantService.Success,data.message);
				$scope.scbBranch= {};
			});
		};
		
		var getScbBranchByID = function() {
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var Obj = {
			 operation : constantService.GetByOId,
			 loginBean : userInfo
		    };
			Obj.oid = $routeParams.oid;
		    promis =scbBranchService.postObject(Obj);
		    debugger;
		    promis.then(function(data) {
			if (!data.success) {
				messageService.showMessage(constantService.Danger, 'Unable to load branch');
				return;
			}
			$scope.scbBranch = data.data;
		});
	 };
	
	 	var init = function () {
	 		if ($routeParams.oid == undefined || $routeParams.oid == null || $routeParams.oid.length == 0) {
				return;
			}
	 		getScbBranchByID();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('scbBranchController', ['$rootScope', '$scope', '$log', '$timeout', '$route','$routeParams', '_',
          'messageService', 'dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService','scbBranchService', scbBranchController]);
   
	
});

