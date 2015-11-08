
'use strict';

define(['app'], function (app) {

    var constantService = function ($rootScope, $cookieStore) {
    	
        this.getAppLayout = function () {
            var layout = {
                header: { location: 'app/views/layout/app/Header.html', isVisible: true },
                leftPanel: { location: 'app/views/layout/app/LeftPanel.html', isVisible: true},
            };
            return layout;
        };

        this.getWebLayout = function () {
            var layout = {
                header: { location: 'app/views/layout/web/Header.html', isVisible: false },
                leftPanel: { location: 'app/views/layout/web/LeftPanel.html', isVisible: false },
            };
            return layout;
        };
        
        this.getRandomInt = function (min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }
        this.userInfoCookieStoreKey = 'user.info.cookie.store.key';
        this.systemInfoCookieStoreKey = 'system.info.cookie.store.key';
        
        this.AlertMessage = 'AlertMessage';
        
        this.userlogin = 'Login';
        this.userlogout = 'Logout';
        
        this.Active = 'A';
        this.Inactive = 'I';
        
        this.GetAll ='GetAll';
        this.Save = 'Save';
        this.Update = 'Update';
        this.Delete = 'Delete';
        this.GetByOId = 'GetByOId';
        
        this.AddBalance = 'AddBalance';
        this.ChangeStatus = 'ChangeStatus';
        this.GetPartnerFromMemory = 'GetPartnerFromMemory';
        this.GetCallDetails = 'GetCallDetails';
        
        this.CallStatusConnect = 'c';
        this.CallStatusInit = 'i';
        this.CallStatusKill = 'k';
        this.CallStatusDisconnect = 'd';
        
        this.GetDecryptedPWD = 'GetDecryptedPWD';

        this.Danger = 'danger';
        this.Success = 'success';
        this.Info = 'info';
        this.Warning = 'warning';
        
        this.SCBAdminMenu = [
		            	{ "id" : "dashboard", "url" : "admindashboard", "text" : "Dashboard", "class" : "fa fa-dashboard", "child" : [] },
		            	{ "id" : "cl", "url" : "underprocess", "text" : "CL", "class" : "fa fa-th", "child" : [] },
		            	{ "id" : "cib", "url" : "underprocess", "text" : "CIB", "class" : "fa fa-th", "child" : [] },
		            	{ "id" : "dl", "url" : "underprocess", "text" : "DL", "class" : "fa fa-th", "child" : [] },
		            	{ "id" : "report", "url" : "underprocess", "text" : "Report", "class" : "fa fa-th", "child" : [] },
		            	{ "id" : "analytics", "url" : "underprocess", "text" : "Analytics", "class" : "fa fa-th", "child" : [
                        { "id" : "report", "url" : "underprocess", "text" : "Report", "class" : "fa fa-th", "child" : [] }                                                                                                  
		            	                                                                                                     ] }
		            ];
        this.SCBuisinessMenu = [
      		            	{ "id" : "dashboard", "url" : "businessdashboard", "text" : "Dashboard", "class" : "fa fa-dashboard", "child" : [] },
    		            	{ "id" : "systemstatus", "url" : "employees", "text" : "System Status", "class" : "fa fa-th", "child" : [] },
    		            	{ "id" : "systemperformance", "url" : "employees", "text" : "System Performance", "class" : "fa fa-th", "child" : [] },
    		            	{ "id" : "administration", "url" : "employees", "text" : "Administration", "class" : "fa fa-th", "child" : [] },
    		            	{ "id" : "report", "url" : "report", "text" : "Report", "class" : "fa fa-th", "child" : [] }
    		            ];
       
        this.SCBStaffMenu = [
        		            	{ "id" : "dashboard", "url" : "dashboard", "text" : "Dashboard", "class" : "fa fa-dashboard", "child" : [] },
        		            	{ "id" : "systemstatus", "url" : "employees", "text" : "System Status", "class" : "fa fa-th", "child" : [] },
        		            	{ "id" : "systemperformance", "url" : "employees", "text" : "System Performance", "class" : "fa fa-th", "child" : [] },
        		            	{ "id" : "administration", "url" : "employees", "text" : "Administration", "class" : "fa fa-th", "child" : [] },
        		            	{ "id" : "report", "url" : "report", "text" : "Report", "class" : "fa fa-th", "child" : [] }
        		            ];
       
        
    };
    
    app.service('constantService', ['$rootScope', '$cookieStore',  constantService]);

});
