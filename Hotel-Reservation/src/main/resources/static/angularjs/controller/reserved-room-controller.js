
(function() {
	'use strict';

	app.controller('reservedRoomController', customerDetailsController);

	customerDetailsController.$inject = [ '$scope', 'datasource','serverEndpoints','authentication','navigation' ];
	function customerDetailsController($scope, datasource, serverEndpoints,authentication,navigation) {
		console.log("reservedRoomController()----> Start");
		var lvm = this;
		lvm.customers = [];
		
		$("#sidebar-panel").show();
		$("#AddRooms").hide();
		$("#allCustomers").hide();
		
		lvm.showBanner=true;
		lvm.customerId=navigation.getTransitionData();
		lvm.customer=null;
		
		if(lvm.customerId==null){
			navigation.routeTo(navigation.routes.HOME);
		}
		
		lvm.getCustomerDetailsByCustomerId = function(customerId) {
			
			var header = {};
			header[serverEndpoints.sessionToken]=authentication.getAdminSessionToken();
			header[serverEndpoints.userId]=customerId;
			// Get product list of portal
			datasource.getData(
					serverEndpoints.findReservationByUserIdUrl, {},
					header, function(isSuccess, data) {

						if (isSuccess) {
							lvm.customer = data;
							
						}
					});
		}

		lvm.getCustomerDetailsByCustomerId(lvm.customerId);
		
		lvm.logOut = function () {
			authentication.setCustomerSessionToken(null);
			authentication.setCustomerId(null);
			navigation.routeTo(navigation.routes.CUSTOMERLOGIN);
			location.reload();
		}

		
	}

	console.log("reservedRoomController()---->End");
})();