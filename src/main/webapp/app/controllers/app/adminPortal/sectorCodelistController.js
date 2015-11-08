
'use strict';

define(['app'], function (app) {
    
	 var sectorCodelistController = function ($rootScope, $scope, $log, $timeout, $route, _, messageService, 
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService,branchService,sectorCodeService) {
		 
		var userInfo, promis;

		var getAllSectorCode=function(){
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var sectorCodeObj={loginBean:userInfo,operation: constantService.GetAll}
			promis = sectorCodeService.postObject(sectorCodeObj);
			promis.then(function(data) {
				if (!data.success) {
					messageService.showMessage(constantService.Danger,data.message);
					return;
				}
				$scope.sectorCodes=data.data;
				console.log($scope.sectorCodes);
			});
		};
		
	 	var init = function () {
	 		getAllSectorCode();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('sectorCodelistController', ['$rootScope', '$scope', '$log', '$timeout', '$route', '_',
          'messageService', 'dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService','branchService','sectorCodeService', sectorCodelistController]);
   
	
});

