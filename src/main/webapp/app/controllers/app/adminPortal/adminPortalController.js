
'use strict';

define(['app'], function (app) {
    
	 var adminPortalController = function ($rootScope, $scope, $log, $timeout, $route, _, messageService, 
			 dashboardService, constantService, navigationService, localStorageService, 
			 configurationService) {
		 
		var userInfo, promis;

		$scope.users = [
	        	           {
	        	        	   "id" : "manageuser", 
	        	        	   "url" : "manageuser",
	        	        	   "linkText" : "Users",
	        	        	   "description" : "Create new users"
		        		   },
	        	           {
		        			   "id" : "rolemanipulation", 
		        			   "url" : "rolemanipulation", 
		        			   "linkText" : "Role Manipulation", 
		        			   "description" : "Role Manipulation by admin" 
	    				   },
	    				   {
		        			   "id" : "test", 
		        			   "url" : "testlist", 
		        			   "linkText" : "Testes", 
		        			   "description" : "manage Testes" 
	    				   },
	    				   {
		        			   "id" : "branch", 
		        			   "url" : "branchlist", 
		        			   "linkText" : "Branches", 
		        			   "description" : "manage Barnches" 
	    				   },
	    				   {
		        			   "id" : "scbBranch", 
		        			   "url" : "scbBranchlist", 
		        			   "linkText" : "ScbBranches", 
		        			   "description" : "manage ScbBarnches" 
	    				   },
	    				   {
		        			   "id" : "sectorCode", 
		        			   "url" : "sectorCodelist", 
		        			   "linkText" : "Sector Code", 
		        			   "description" : "view SectorDetails" 
	    				   }
        	        ]
		
		$scope.performClickAction = function(menuId){			
			navigationService.menuNavigation(menuId);
		}
		
	 	var init = function () {
	 		
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('adminPortalController', ['$rootScope', '$scope', '$log', '$timeout', '$route', '_',
          'messageService', 'dashboardService', 'constantService', 'navigationService', 
          'localStorageService','configurationService', adminPortalController]);
   
	
});

