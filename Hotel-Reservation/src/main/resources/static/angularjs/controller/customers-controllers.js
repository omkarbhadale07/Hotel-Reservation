(function () {
	'use strict';

	app.controller('customerController', customerController);

	customerController.$inject = ['$scope', 'datasource', 'serverEndpoints',
		'authentication', 'navigation', 'strings', '$route', '$window'];
	function customerController($scope, datasource, serverEndpoints,
		authentication, navigation, strings, $route, $window) {
		console.log("customerController()----> Start");
		var lvm = this;
		lvm.customers = [];
		lvm.searchedCustomers = [];

	
		$("#sidebar-panel").show();
		$("#UserRegisteredRoom").hide();
		$("#roomRegistration").hide();
		
		lvm.getCustomers = function () {
			$(".loader-background").css("display", "flex");

			var header = {};
			header[serverEndpoints.sessionToken] = authentication
				.getAdminSessionToken();

			// Get product list of portal
			datasource.getData(serverEndpoints.findAllUsersUrl, {}, header,
				function (isSuccess, data) {
				$(".loader-background").css("display", "none");
					if (isSuccess) {
						lvm.customers = data;

					} else {
						if (data === strings.msg_admin_not_logged_in) {
							lvm.logOut();

						}
					}
				});
		}

		lvm.getCustomers();

		

		lvm.removeCustomer = function (id) {
			$(".loader-background").css("display", "flex");

			var header = {};
			header[serverEndpoints.sessionToken] = authentication
				.getAdminSessionToken();

			var customerData = {};
			header[serverEndpoints.id] = id;
			// Get product list of portal
			datasource.getData(serverEndpoints.deleteUserByIdUrl, customerData,
				header, function (isSuccess, data) {
					$(".loader-background").css("display", "none");

					if (isSuccess) {
						lvm.requestedCustomerId = null;
						$("#deleteModal").modal("hide");
						$route.reload();

					} else {
						if (data === strings.msg_admin_not_logged_in) {
							lvm.logOut();

						}
					}
				});
		}
		lvm.showDeleteModal = function (id) {
			lvm.requestedCustomerId = id;
			$("#deleteModal").modal("show")
		}

		lvm.getSearchedCustomers = function (searchString) {
			$(".loader-background").css("display", "flex");
			lvm.searchedCustomers = [];
			var requestData = {};
			var header = {};
			header[serverEndpoints.sessionToken] = authentication
				.getAdminSessionToken();
			requestData[serverEndpoints.searchData] = searchString;
			// Get product list of portal
			datasource.getData(serverEndpoints.getSearchedCustomersUrl,
				requestData, header, function (isSuccess, data) {
				$(".loader-background").css("display", "none");
					if (isSuccess) {
						
						lvm.searchedCustomers = data;
						if (lvm.searchedCustomers.length == 0) {
							lvm.diplsaySearchResult = false;
							lvm.noResultsFound = true;
						} else {
							lvm.diplsaySearchResult = true;
							lvm.noResultsFound = false;
						}

					}
				});
		}

		lvm.clearSearch = function () {
			lvm.searchQuery = "";
			lvm.diplsaySearchResult = false;
			lvm.noResultsFound = false;
		}

		lvm.getCustomerDetails = function (id) {
			navigation.routeTo(navigation.routes.CUSTOMERDETAILS, null, id);
		}

		
		lvm.logOut = function () {
			authentication.setAdminSessionToken(null);
			authentication.setAdminId(null);
			navigation.routeTo(navigation.routes.LOGIN);
			location.reload();
		}
		
		lvm.currentCustomerId=null;
		

	}


	console.log("customerController()---->End");
})();