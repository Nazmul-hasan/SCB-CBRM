
'use strict';

define(['app'], function (app) {

	var testService = function ($resource, $q, configurationService,messageService,constantService) {
		
		var sectorCodeResource, delay;
	    
		sectorCodeResource = $resource(configurationService.testRestUrl, {}, {
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
    
    app.service('testService', ['$resource', '$q', 'configurationService', 'messageService', 
           'constantService', testService]);

});

