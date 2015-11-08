
'use strict';

define(['app'], function (app) {
    
	 var branchListController = function ($rootScope, $scope, $log, $timeout, $route, _, messageService,modalService,
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService,branchService) {
		 
		var userInfo, promis;

		
		$scope.gotoBranch=function(){
			navigationService.menuNavigation('branch', '');
		}
		
		$scope.editBranch=function(oid){
			navigationService.showPageWithData('branch',oid);
		};
		
		var getAllBracnches=function(){
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var branchObj={loginBean:userInfo,operation: constantService.GetAll}
			promis = branchService.postObject(branchObj);
			promis.then(function(data) {
				if (!data.success) {
					messageService.showMessage(constantService.Danger,data.message);
					return;
				}
				$scope.branchlis=data.data;
			});
		};
		
		$scope.deleteBranch=function(branch){
			var modalOptions = {
                    headerText: 'Delete '+branch.name +' ?',
                    bodyText: 'Are you Sure to delete branch '+branch.name +' ?',
                    closeButtonText:'Cancel',
                    actionButtonText:'OK'
                };

                var modalDefaults = {
                    templateUrl: 'app/partials/confirmation.html'
                };
            modalService.showModal(modalDefaults, modalOptions).then(function () {
            	
    			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
    			var delBarnchObj={loginBean:userInfo,operation: constantService.Delete}
    			delBarnchObj.oid=branch.oid;
    			promis = branchService.postObject(delBarnchObj);
    			promis.then(function(data) {
    				if (!data.success) {
    					messageService.showMessage(constantService.Danger,data.message);
    					return;
    				}
    				messageService.showMessage(constantService.Success,data.message);
    				getAllBracnches();
    			});
 	     	});
		
		};
		
	 	var init = function () {
	 		getAllBracnches();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('branchListController', ['$rootScope', '$scope', '$log', '$timeout', '$route', '_',
          'messageService','modalService','dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService','branchService', branchListController]);
   
	
});

