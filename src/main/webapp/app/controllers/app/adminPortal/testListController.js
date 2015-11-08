
'use strict';

define(['app'], function (app) {
    
	 var testListController = function ($rootScope, $scope, $log, $timeout, $route, _, messageService,modalService,
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService,testService) {
		 
		var userInfo, promis;

		
		$scope.gotoTest=function(){
			navigationService.menuNavigation('test', '');
		}
		
		$scope.editTest=function(oid){
			navigationService.showPageWithData('test',oid);
		};
		
		var getAllTestes=function(){
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var testObj={loginBean:userInfo,operation: constantService.GetAll}
			promis = testService.postObject(testObj);
			promis.then(function(data) {
				if (!data.success) {
					messageService.showMessage(constantService.Danger,data.message);
					return;
				}
				$scope.testlis=data.data;
			});
		};
		
		$scope.deleteTest=function(test){
			var modalOptions = {
                    headerText: 'Delete '+test.name +' ?',
                    bodyText: 'Are you Sure to delete test '+test.name +' ?',
                    closeButtonText:'Cancel',
                    actionButtonText:'OK'
                };

                var modalDefaults = {
                    templateUrl: 'app/partials/confirmation.html'
                };
            modalService.showModal(modalDefaults, modalOptions).then(function () {
            	
    			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
    			var delTestObj={loginBean:userInfo,operation: constantService.Delete}
    			delTestObj.oid=test.oid;
    			promis = testService.postObject(delTestObj);
    			promis.then(function(data) {
    				if (!data.success) {
    					messageService.showMessage(constantService.Danger,data.message);
    					return;
    				}
    				messageService.showMessage(constantService.Success,data.message);
    				getAllTestes();
    			});
 	     	});
		
		};
		
	 	var init = function () {
	 		getAllTestes();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('testListController', ['$rootScope', '$scope', '$log', '$timeout', '$route', '_',
          'messageService','modalService','dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService','testService', testListController]);
   
	
});

