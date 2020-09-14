app.controller("registerCustomerController", function($scope, datasource,
		serverEndpoints, authentication, navigation, strings, $route, $window) {

	console.log("registerCustomerController()----> Start");
	var lvm = this;

	
	$("#sidebar-panel").hide();

	lvm.showBanner = true;

	lvm.logOut = function () {
		authentication.setAdminSessionToken(null);
		authentication.setAdminId(null);
	}
	lvm.logOut();
	
	lvm.registerCustomer= function() {

		
		var uploadData = {};
		
		uploadData[serverEndpoints.name] = lvm.customer.name;
		uploadData[serverEndpoints.emailId] = lvm.customer.emailId;
		uploadData[serverEndpoints.contactNo] = lvm.customer.contactNo;
		uploadData[serverEndpoints.password] = lvm.customer.password;

		// Get product list of portal
		datasource.getData(serverEndpoints.registerUserUrl, uploadData,
				{}, function(isSuccess, data) {

					if (isSuccess) {
						alert("User Registered Succesfully");
						window.location.href= navigation.routes.CUSTOMERLOGIN;
					} else {

					}
				});
	}
	

	console.log("registerCustomerController()---->End");
})