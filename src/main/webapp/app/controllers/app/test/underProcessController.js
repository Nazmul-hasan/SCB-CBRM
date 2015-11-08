
'use strict';

define(['app'], function (app) {
    
	 var underProcessController = function ($rootScope, $scope, $log, $timeout, $route, _, messageService, 
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService) {
		 
		var userInfo, promis;
	
		
	 	var init = function () {
	 		
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('underProcessController', ['$rootScope', '$scope', '$log', '$timeout', '$route', '_',
          'messageService', 'dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService', underProcessController]);
   
	
});

