
'use strict';

define(['app'], function (app) {

    var partnerSwitch = function ($timeout, $modal, confirmationService, localStorageService, constantService,
    		partnerService, messageService) {
        
    	return {
    		restrict : 'A',
    		require : 'ngModel',
    		scope : {
    			switchActive : '@',
    			switchOnText : '@',
    			switchOffText : '@',
    			switchOnColor : '@',
    			switchOffColor : '@',
    			switchAnimate : '@',
    			switchSize : '@',
    			switchLabel : '@',
    			switchIcon : '@',
    			switchWrapper : '@',
    			switchState : '@',
    			switchRadioOff : '@'
    		},
    		link : function link(scope, element, attrs, controller) {
    			/**
    			 * Return the true value for this specific checkbox.
    			 * 
    			 * @returns {Object} representing the true view
    			 *          value; if undefined, returns true.
    			 */
    			var getTrueValue = function() {
    				var trueValue = attrs.ngTrueValue;
    				if (!angular.isString(trueValue)) {
    					trueValue = true;
    				}
    				return trueValue;
    			};

    			/**
    			 * Listen to model changes.
    			 */
    			var listenToModel = function() {
    				// When the model changes
    				controller.$formatters.push(function(newValue) {
    					if (newValue !== undefined) {
    						$timeout(function() {
    							element.bootstrapSwitch('state', (newValue === getTrueValue()), true); 
    						});
    					}
    				});

    				scope.$watch('switchActive', function(newValue) {
    					var active = newValue === true || newValue === 'true' || !newValue;
    					element.bootstrapSwitch('disabled', !active);
    				});

    				scope.$watch('switchState', function(newValue) {
    					var active = newValue === true || newValue === 'true' || !newValue;
    					element.bootstrapSwitch('state', active, true);
    				});

    				scope.$watch('switchOnText', function(newValue) {
    					element.bootstrapSwitch('onText', getValueOrUndefined(newValue));
    				});

    				scope.$watch('switchOffText', function(newValue) {
    					element.bootstrapSwitch('offText', getValueOrUndefined(newValue));
    				});

    				scope.$watch('switchOnColor', function(newValue) {
    					attrs.dataOn = newValue;
    					element.bootstrapSwitch('onColor', getValueOrUndefined(newValue));
    				});

    				scope.$watch('switchOffColor', function(newValue) {
    					attrs.dataOff = newValue;
    					element.bootstrapSwitch('offColor', getValueOrUndefined(newValue));
    				});

    				scope.$watch('switchAnimate', function(newValue) {
    					element.bootstrapSwitch('animate', scope.$eval(newValue || 'true'));
    				});

    				scope.$watch('switchSize', function(newValue) {
    					element.bootstrapSwitch('size', newValue);
    				});

    				scope.$watch('switchLabel', function(newValue) {
    					element.bootstrapSwitch('labelText', newValue ? newValue : '&nbsp;');
    				});

    				scope.$watch('switchIcon', function(newValue) {
    					if (newValue) {
    						// build and set the new span
    						var spanClass = '<span class=\'' + newValue + '\'></span>';
    						element.bootstrapSwitch('labelText', spanClass);
    					}
    				});

    				scope.$watch('switchWrapper', function(newValue) {
    					// Make sure that newValue is not
    					// empty, otherwise default to null
    					if (!newValue) {
    						newValue = null;
    					}
    					element.bootstrapSwitch('wrapperClass', newValue);
    				});

    				scope.$watch('switchRadioOff', function(newValue) {
    					element.bootstrapSwitch('radioAllOff', newValue === true || newValue === 'true');
    				});
    			};

    			/**
    			 * Listen to view changes.
    			 */
    			var listenToView = function() {
    				// When the switch is clicked, set its value
    				// into the ngModelController's $viewValue
    				//controller.$setViewValue(data);
    				//console.log('Custom - '+controller.$modelValue+' : '+data);
					element.on('switchChange.bootstrapSwitch', function(e, data) {
    					scope.$apply(function() {
    						
    						var confirmOptions = {
								closeButtonText: 'Cancel',
								actionButtonText: 'Ok',
				 	            headerText: 'Please Confirm',
				 	            bodyText: 'Are you sure to change status?'
							};
				        	confirmationService.showModal({}, confirmOptions).then(function (result) {
				        		if(result != 'ok'){
				        			element.bootstrapSwitch('state', !data, true);
				        			return;
				        		}
				        		
				        		var partnerStatus = constantService.Inactive;
				        		if(data){
				        			partnerStatus = constantService.Active;
				        		}
				        		
				        		var userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
				        		var partnerObj = { operation : constantService.ChangeStatus, 
				        				loginBean : userInfo, partnerStatus : partnerStatus,
				        				partnerID : controller.$modelValue };
				        		
				        		var promis = partnerService.getAllPartner(partnerObj);
				                promis.then(function (data) {
					        		if (!data.success) {
				                        messageService.showMessage(constantService.Danger, 'Unable to change status');
				                        return;
				                    }
			                        messageService.showMessage(constantService.Success, 'Successfully change status');
				                });
				            
				                
				                
				        	});
				        	
    					});
    				});
    			};


    			/**
    			 * Returns the value if it is truthy, or undefined.
    			 * 
    			 * @param value
    			 *            The value to check.
    			 * @returns the original value if it is truthy,
    			 *          {@link undefined} otherwise.
    			 */
    			var getValueOrUndefined = function(value) {
    				return (value ? value : undefined);
    			};

    			// Wrap in a $timeout to give the ngModelController
    			// enough time to resolve the $modelValue
    			$timeout(function() {
    				var isInitiallyActive = controller.$modelValue === getTrueValue();

    				// Bootstrap the switch plugin
    				element.bootstrapSwitch({
    					state : isInitiallyActive
    				});

    				// Listen and respond to model changes
    				listenToModel();

    				// Listen and respond to view changes
    				listenToView();
    				
    				// Set the initial view value (may differ from
    				// the model value)
    				controller.$setViewValue(isInitiallyActive);

    				// On destroy, collect ya garbage
    				scope.$on('$destroy', function() {
    					element.bootstrapSwitch('destroy');
    				});
    			});
    		}
    	};
    	
    };

    app.directive('partnerSwitch', ['$timeout', '$modal', 'confirmationService', 'localStorageService', 
        'constantService', 'partnerService', 'messageService', partnerSwitch]);

});