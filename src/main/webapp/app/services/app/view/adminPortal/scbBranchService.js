
'use strict';

define(['app'], function (app) {

	var scbBranchService = function ($resource, $q, configurationService,messageService,constantService) {
		
		var scbBranchDataResource, delay;
	    
		scbBranchDataResource = $resource(configurationService.scbBranchRestUrl, {}, {
			postObject:     { method: 'POST' }
		});
	    
		
		this.postObject = function (obj) {
	        delay = $q.defer();
	        scbBranchDataResource.postObject(obj, function (data) {
	            delay.resolve(data);
	        }, function () {
	            delay.reject('Unable to fetch..');
		  });
		  return delay.promise;
		};
		
		
	
    };
    
    app.service('scbBranchService', ['$resource', '$q', 'configurationService', 'messageService', 
           'constantService', scbBranchService]);

});

