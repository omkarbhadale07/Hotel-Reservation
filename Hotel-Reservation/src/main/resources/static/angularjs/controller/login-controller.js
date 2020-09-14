(function() {
	'use strict';

	app.controller('loginController', loginController);

	loginController.$inject = [ '$scope', 'datasource', 'serverEndpoints',
			'navigation', 'authentication','$rootScope' ];
	function loginController($scope, datasource, serverEndpoints, navigation,
			authentication,$rootScope) {
		console.log("loginController()----> Start");
		
		
		var lvm = this;
		lvm.showBanner = false;
		$("#sidebar-panel").hide();
		$rootScope.userName="";
		$rootScope.adminName="";
		lvm.login = function() {
			$(".loader-background").css("display", "flex");

			var header = {}
			var usersCredentials = {};
			usersCredentials[serverEndpoints.emailId] = lvm.emailId;
			usersCredentials[serverEndpoints.password] = lvm.password;
			// Get product list of portal
			datasource
					.getData(
							serverEndpoints.loginAdminUrl,
							usersCredentials,
							header,
							function(isSuccess, data) {
								$(".loader-background").css("display", "none");

								if (isSuccess) {

									authentication
											.setAdminSessionToken(data.sessionToken);
									authentication
											.setAdminId(data.adminId);
									authentication
									.setAdminName(data.name);
									// navigationDrawerSetup.showItemsForAdminLogin();
									window.location.href=navigation.routes.HOME;
								} else {
									lvm.message = data;
								}
							});
		}

		
			
		lvm.customerLogin = function() {
			$(".loader-background").css("display", "flex");
			
			var header = {};
			var usersCredentials = {};
			usersCredentials[serverEndpoints.emailId] = lvm.emailId;
			usersCredentials[serverEndpoints.password] = lvm.password;
			
			
			// Get product list of portal
			datasource
					.getData(
							serverEndpoints.loginUserUrl,
							usersCredentials,
							header,
							function(isSuccess, data) {
								$(".loader-background").css("display", "none");
								if (isSuccess) {

									authentication
											.setCustomerSessionToken(data.sessionToken);
									authentication
											.setCustomerId(data.userId);
									
									//authentication.setCustomerName(data.name);
									authentication.setAdminName(data.name);
									//window.location.href=navigation.routes.REGISTEREDROOM;
									navigation.routeTo(navigation.routes.REGISTEREDROOM, null, data.userId);

								} else {
									lvm.message = data;
								}
							});
		}
		
		
	}

	console.log("loginController()---->End");
})();