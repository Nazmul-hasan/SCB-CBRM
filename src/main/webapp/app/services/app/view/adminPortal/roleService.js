
'use strict';

define(['app'], function (app) {

	var roleService = function ($resource, $q, configurationService) {
		
		var roleResource, delay;
        
		roleResource = $resource(configurationService.rolerRestUrl, {}, {
			
			getAllRoles: { method: 'POST'}
          
            
        });
		 this.getAllRoles = function(obj){
				delay =$q.defer();
				roleResource.getAllRoles(obj,function(data){
					delay.resolve(data);
				},function (){
					delay.reject('Unable to fetch..');
				});
				return delay.promise;
			};
        
      
    };
    
    app.service('roleService', ['$resource', '$q', 'configurationService', roleService]);

});

