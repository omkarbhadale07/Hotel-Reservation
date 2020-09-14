
(function() {
	'use strict';

	app.controller('customerDetailsController', customerDetailsController);

	customerDetailsController.$inject = [ '$scope', 'datasource','serverEndpoints','authentication','navigation' ];
	function customerDetailsController($scope, datasource, serverEndpoints,authentication,navigation) {
		console.log("customerDetailsController()----> Start");
		var lvm = this;
		lvm.customers = [];
		/*lvm.showBanner=true;
		$scope.$apply();*/
		lvm.showBanner=true;
		lvm.customerId=navigation.getTransitionData();
		lvm.customer=null;
		$("#spouseDetailsBlock").slideUp();
		$("#otherDetailsBlock").slideUp();
		$("#visaDetailsBlock").slideUp();
		$("#frequentDetailsBlock").slideUp();
		$("#interestDetailsBlock").slideUp();
		
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
		
	}

	console.log("customerController()---->End");
})();