
'use strict';

define(['app'], function (app) {

	var dataUploadService = function ($resource, $q, configurationService,messageService,constantService) {
		
		var bddb2DataResource, delay;
	    
		bddb2DataResource = $resource(configurationService.bddb2FileUploadRestUrl, {}, {
			postObject:     { method: 'POST' }
		});
	    
		
		this.postObject = function (obj) {
	        delay = $q.defer();
	        bddb2DataResource.postObject(obj, function (data) {
	            delay.resolve(data);
	        }, function () {
	            delay.reject('Unable to fetch..');
		  });
		  return delay.promise;
		};
		
		
	
    };
    
    app.service('dataUploadService', ['$resource', '$q', 'configurationService', 'messageService', 
           'constantService', dataUploadService]);

});

