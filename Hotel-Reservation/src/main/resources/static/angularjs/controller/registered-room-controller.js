app.controller("registeredRoomController", function ($scope, datasource,
	serverEndpoints, authentication, navigation, strings, $route, $window, $compile) {

	console.log("registeredRoomController()----> Start");
	var lvm = this;

	lvm.customer = [];
	
	$("#sidebar-panel").show();
	$("#AddRooms").hide();
	$("#allCustomers").hide();
	
	 lvm.customerId=navigation.getTransitionData();
	lvm.showBanner = true;
	$(".enquiry-icon-container").css("display", "flex");
	$("#roomList").hide();
	
	lvm.showAddEnquiryModal = function (modelName, modalId) {
		$("#" + modelName).modal('show');
		
	}
	
	lvm.getAllRoomAvaibility = function(){
		
		datasource.getData(
				serverEndpoints.showAllRoomsUrl, {},
				{}, function(isSuccess, data) {

					if (isSuccess) {
						lvm.rooms = data;
						
					}
				});
	}
	lvm.getAllRoomAvaibility();

	lvm.showRoomList = function (){
		$("#roomList").show();
	}

	 lvm.getCustomerDetailsByCustomerId = function(customerId) {
			
	 	var header = {};
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

	lvm.registerRoom= function(){

		var header = {};
		header[serverEndpoints.sessionToken] = authentication.getCustomerSessionToken();

		var uploadData = {};
		
		uploadData[serverEndpoints.name] = lvm.enquiry.name;
		uploadData[serverEndpoints.emailId] = lvm.enquiry.emailId;
		uploadData[serverEndpoints.contactNo] = lvm.enquiry.contactNo;
		uploadData[serverEndpoints.capacity] = lvm.enquiry.capacity;

		header[serverEndpoints.roomNo] = lvm.enquiry.roomNo;
		
		uploadData[serverEndpoints.checkInDate] = lvm.enquiry.checkInDate;
		uploadData[serverEndpoints.checkOutDate] = lvm.enquiry.checkOutDate;
		// Get product list of portal
		datasource.getData(serverEndpoints.registerRoomUrl, uploadData,
			header, function(isSuccess, data) {

				if (isSuccess) {
					alert("User Registered Succesfully");
					$route.reload();
					//navigation.routeTo(navigation.routes.RESERVEDROOM, null, id);
					//window.location.href= navigation.routes.CUSTOMERLOGIN;
				} else {

				}
			});

	}
	
	lvm.logOut = function () {
		authentication.setCustomerSessionToken(null);
		authentication.setCustomerId(null);
		navigation.routeTo(navigation.routes.CUSTOMERLOGIN);
		location.reload();
	}

	console.log("registeredRoomController()---->End");
})