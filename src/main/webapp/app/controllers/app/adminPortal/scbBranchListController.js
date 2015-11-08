
'use strict';

define(['app'], function (app) {
    
	 var scbBranchListController = function ($rootScope, $scope, $log, $timeout, $route, _, messageService,modalService,
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService,scbBranchService) {
		 
		var userInfo, promis;

		
		$scope.gotoScbBranch=function(){
			navigationService.menuNavigation('scbBranch', '');
		}
		
		$scope.editScbBranch=function(oid){
			navigationService.showPageWithData('scbBranch',oid);
		};
		
		var getAllScbBracnches=function(){
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var scbBranchObj={loginBean:userInfo,operation: constantService.GetAll}
			promis = scbBranchService.postObject(scbBranchObj);
			promis.then(function(data) {
				if (!data.success) {
					messageService.showMessage(constantService.Danger,data.message);
					return;
				}
				$scope.scbBranchList=data.data;
			});
		};
		
		$scope.deleteScbBranch=function(scbBranch){
			var modalOptions = {
                    headerText: 'Delete '+scbBranch.name +' ?',
                    bodyText: 'Are you Sure to delete scbBranch '+scbBranch.name +' ?',
                    closeButtonText:'Cancel',
                    actionButtonText:'OK'
                };

                var modalDefaults = {
                    templateUrl: 'app/partials/confirmation.html'
                };
            modalService.showModal(modalDefaults, modalOptions).then(function () {
            	
    			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
    			var delScbBarnchObj={loginBean:userInfo,operation: constantService.Delete}
    			delScbBarnchObj.oid=scbBranch.oid;
    			promis = scbBranchService.postObject(delScbBarnchObj);
    			promis.then(function(data) {
    				if (!data.success) {
    					messageService.showMessage(constantService.Danger,data.message);
    					return;
    				}
    				messageService.showMessage(constantService.Success,data.message);
    				getAllScbBracnches();
    			});
 	     	});
		
		};
		
	 	var init = function () {
	 		getAllScbBracnches();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('scbBranchListController', ['$rootScope', '$scope', '$log', '$timeout', '$route', '_',
          'messageService','modalService','dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService','scbBranchService', scbBranchListController]);
   
	
});

