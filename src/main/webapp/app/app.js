
'use strict';

define(['services/utils/routeResolver'], function () {

	var app = angular.module('cbrmApp', ['localization', 'ngRoute', 'ngAnimate', 'ngResource', 
              'ngCookies', 'ui.bootstrap', 'ui', 'highcharts-ng', 'ngTable', 'routeResolverServices', 'underscore',
              'wc.Directives', 'wc.Animations']);

	app.run(['$rootScope', '$route', '$http', '$location', '$cookieStore', 'constantService','localize',
	         function ($rootScope, $route, $http, $location, $cookieStore, constantService,localize) {
	
		localize.setLanguage('en-US');
		$rootScope.isMobile = false;
		$rootScope.messagePageLocation = 'app/partials/message.html';
		
		$rootScope.$on("$routeChangeStart", function (oldPath, newPath) {
	        if (newPath.$$route == undefined || newPath.$$route.isWeb) {
	        	$rootScope.layout = constantService.getWebLayout();
	            return;
	        }
	        else
	        {
	        	$rootScope.layout = constantService.getAppLayout();
	        }
	    });
    
	}]); 

	app.config(['$routeProvider','routeResolverProvider','$controllerProvider', '$compileProvider', 
	            '$filterProvider', '$provide', '$locationProvider', '$httpProvider',  
	         function ($routeProvider,routeResolverProvider, $controllerProvider, $compileProvider, 
	        	$filterProvider, $provide, $locationProvider, $httpProvider) {
    
		app.register =
	    {
	        controller: $controllerProvider.register,
	        //directive: $compileProvider.directive,
	        filter: $filterProvider.register,
	        //factory: $provide.factory,
	        //service: $provide.service
	    };
		
		// Provider-based service.
        app.service = function( name, constructor ) {
            $provide.service( name, constructor );
            return( this );
        };
        
        // Provider-based factory.
        app.factory = function( name, factory ) {
            $provide.factory( name, factory );
            return( this );
        };
        
        // Provider-based directive.
        app.directive = function( name, factory ) {
            $compileProvider.directive( name, factory );
            return( this );
        };
     
		var route = routeResolverProvider.route;
		$routeProvider

	  //url                                //page and controller name prefix,       dir path, 			title, 						  isWeb
		.when('/',                             route.resolve('signin',            'security/',         'Signin',             		  true))
        .when('/dashboard',                    route.resolve('dashboard',    	  'app/dashboard/',    'Dashboard',                   false))
        .when('/businessdashboard',            route.resolve('businessDashboard', 'app/dashboard/',    'Business Dashboard',          false))
        .when('/admindashboard',               route.resolve('adminDashboard',    'app/dashboard/',    'Admin Dashboard',             false))
        .when('/underprocess', 				   route.resolve('underProcess', 	  'app/test/',         'Under Construction',         false))
        .when('/adminPortal', 				   route.resolve('adminPortal', 	  'app/adminPortal/',  'Admin Portal',                false))
        .when('/manageuser', 				   route.resolve('user', 	          'app/adminPortal/',  'Add User',                    false))
        .when('/branch', 				       route.resolve('branch', 	          'app/adminPortal/',  'Add Branch',                  false))
        .when('/branch/:oid', 				   route.resolve('branch', 	          'app/adminPortal/',  'Update Branch',                false))
        .when('/fileupload', 				   route.resolve('dataUpload', 	      'app/dataUpload/',   'Data Upload',                  false))
        .when('/branchlist', 				   route.resolve('branchList', 	      'app/adminPortal/',   'Branch List',                 false))
        .when('/scbBranch', 				   route.resolve('scbBranch', 	      'app/adminPortal/',   'Add ScbBranch',               false))
        .when('/scbBranchlist', 			   route.resolve('scbBranchList', 	  'app/adminPortal/',   'ScbBranch List',              false))
        .when('/scbBranch/:oid', 			   route.resolve('scbBranch', 	      'app/adminPortal/',  'Update ScbBranch',             false))
        .when('/sectorCodelist', 			   route.resolve('sectorCodelist', 	  'app/adminPortal/',   'SectorCode List',             false))
        .when('/test', 				           route.resolve('test', 	          'app/adminPortal/',   'Add Test',                     false))
        .when('/testlist', 			           route.resolve('testList', 	      'app/adminPortal/',   'Test List',                    false))
        .when('/test/:oid', 			       route.resolve('test', 	          'app/adminPortal/',   'Update Test',                 false))

        
        .otherwise({ redirectTo: '/' });
	
	}]);

	return app;

});



    
    
    
    
    