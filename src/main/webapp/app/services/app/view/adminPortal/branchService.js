
'use strict';

define(['app'], function (app) {

	var branchService = function ($resource, $q, configurationService,messageService,constantService) {
		
		var sectorCodeResource, delay;
	    
		sectorCodeResource = $resource(configurationService.branchRestUrl, {}, {
			postObject:     { method: 'POST' }
		});
	    
		
		this.postObject = function (obj) {
	        delay = $q.defer();
	        sectorCodeResource.postObject(obj, function (data) {
	            delay.resolve(data);
	        }, function () {
	            delay.reject('Unable to fetch..');
		  });
		  return delay.promise;
		};
		
		
	
    };
    
    app.service('branchService', ['$resource', '$q', 'configurationService', 'messageService', 
           'constantService', branchService]);

});

