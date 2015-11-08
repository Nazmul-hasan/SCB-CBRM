
'use strict';

define(['app'], function (app) {
    
	 var dataUploadController = function ($rootScope, $scope, $log, $timeout, $route, _, messageService, 
			 dataUploadService, constantService, navigationService, localStorageService,loadService, 
			 configurationService) {
		 
		var userInfo, promis;

		$scope.filepath=" ";
		
		
		$scope.uploadBDDB2Data=function(){
			loadService.showDialog();
			userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
			var bddb2Obj={loginBean:userInfo,operation:constantService.Save,filePath:$scope.filepath}
			promis = dataUploadService.postObject(bddb2Obj);
			promis.then(function(data) {
		    loadService.hideDialog();
				if (!data.success) {
					messageService.showMessage(constantService.Danger,data.message);
					return;
				}
				messageService.showMessage(constantService.Success,data.message);
				$scope.branch= {};
			});
		};
		
		 $scope.setFiles = function(element) {
	          $scope.$apply(function($scope) {
	          document.getElementById("uploadFile").value = document.getElementById("fileToUpload").value;
	          console.log('files:', element.files);
	          $scope.files = []
	            for (var i = 0; i < element.files.length; i++) {
	            	$scope.files.push(element.files[i])
	            }
	            $scope.progressVisible = false
	          });
	      };
		
		 $scope.uploadFile = function() {
	            var fd = new FormData()
	            for (var i in $scope.files) {
	                fd.append("uploadedFile", $scope.files[i])
	            }
	            var xhr = new XMLHttpRequest()
	            xhr.upload.addEventListener("progress", uploadProgress, false)
	            xhr.addEventListener("load", uploadComplete, false)
	            xhr.addEventListener("error", uploadFailed, false)
	            xhr.addEventListener("abort", uploadCanceled, false)
	            xhr.open("POST", "rest/file/upload")
	            $scope.progressVisible = true
	            xhr.send(fd)
	        };
	        
	        function uploadProgress(evt) {
	        	$scope.$apply(function(){
	                if (evt.lengthComputable) {
	                	$scope.progress = Math.round(evt.loaded * 100 / evt.total)
	                } else {
	                	$scope.progress = 'unable to compute'
	                }
	            })
	        };
	        
	        function uploadComplete(evt) {
	           	    $scope.$apply(function() {
	           	    	//console.log(evt.target.responseText);
	           	    	$scope.filepath = evt.target.responseText;
	            });
	           
	        };
	        
	        function uploadFailed(evt) {
	            alert("There was an error attempting to upload the file.")
	        };

	        function uploadCanceled(evt) {
	        	$scope.$apply(function(){
	        		$scope.progressVisible = false
	            })
	            alert("The upload has been canceled by the user or the browser dropped the connection.")
	        };
       
       
   
		
		
	 	var init = function () {
	 		
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('dataUploadController', ['$rootScope', '$scope', '$log', '$timeout', '$route', '_',
          'messageService', 'dataUploadService', 'constantService', 'navigationService', 
          'localStorageService','loadService','configurationService', dataUploadController]);
   
	
});

