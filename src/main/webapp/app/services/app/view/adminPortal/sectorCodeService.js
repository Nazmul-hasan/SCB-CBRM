
'use strict';

define(['app'], function (app) {

	var sectorCodeService = function ($resource, $q, configurationService,messageService,constantService) {
		
		var sectorCodeResource, delay;
	    
		sectorCodeResource = $resource(configurationService.sectorCodeUrl, {}, {
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
    
    app.service('sectorCodeService', ['$resource', '$q', 'configurationService', 'messageService', 
           'constantService', sectorCodeService]);

});

