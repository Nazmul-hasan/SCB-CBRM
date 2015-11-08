
require.config({
    baseUrl: 'app',
    urlArgs: 'v=1.0'
});

require(
    [
     	'animations/listAnimations',
        'app',
        'directives/wcUnique',
        'directives/wcOverlay',
        'directives/ngEnter',
        'directives/partnerSwitch',
        'directives/decimalMask',
        'directives/highChart',
        'directives/dateRange',
        'directives/chosen',
        'services/utils/routeResolver',
        'services/utils/constantService',
        'services/utils/configurationService',
        'services/utils/localStorageService',
        'services/utils/navigationService',
        'services/utils/authorizationService',
        'services/utils/languageService',
        'services/utils/menuService',
        'services/utils/confirmationService',
        'services/utils/modalService',
        'services/utils/messageService',
        'services/utils/loadService',
        'services/app/security/signInService',
        'services/app/view/wsClientService',
        'services/app/view/dashboardService',
        'services/app/view/adminPortal/branchService',
        'services/app/view/adminPortal/testService',
        'services/app/view/adminPortal/sectorCodeService',
        'services/app/view/adminPortal/scbBranchService',
        'services/app/view/adminPortal/employeesService',
        'services/app/view/adminPortal/roleService',
        'services/app/view/adminPortal/userService',
        'services/app/view/dataUpload/dataUploadService',
        'filters/partnerFilter',
        'filters/nameProductFilter',
        'controllers/util/appHeaderController',
        'controllers/util/appLeftMenuController',
        'controllers/util/messageController'
    ],
function () {
    angular.bootstrap(document, ['cbrmApp']);
});

