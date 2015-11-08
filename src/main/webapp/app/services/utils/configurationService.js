
'use strict';

define(['app'], function (app) {

    var configurationService = function ($rootScope) {
    	
    	this.server = 'localhost';
        this.port = ':8080';
        
        // Local Host
        this.app = '/cbrm/rest/';
        
        // Cloud Foundry
    	//this.app = '/rest/';
        
        this.baseUrl = 'http://' + this.server + this.port + this.app;
    	this.wsBaseUrl = 'ws://' + this.server + this.port +'/cbrm/';
    	this.loginMetaData = 'loginMetaData';
		this.dashboard = this.app + 'dashboard';
		this.login = this.app + 'security/useraccess';
		this.partnerRestUrl = this.app + 'json/partner/post';
		this.loanRestUrl = this.app + 'json/loan/post';
		this.wsDashboard = this.wsBaseUrl + 'websocketservice';
		this.userRestUrl = this.app + 'json/user/post';
		this.branchRestUrl = this.app + 'branch/post';
		this.testRestUrl = this.app + 'test/post';
		this.scbBranchRestUrl = this.app + 'scbBranch/post';
		this.bddb2FileUploadRestUrl = this.app + 'json/bddb2FileUpload/post';
		this.sectorCodeUrl = this.app + 'sectorCode/post';
		
    	
    };
    
    app.service('configurationService', ['$rootScope', configurationService]);

});


