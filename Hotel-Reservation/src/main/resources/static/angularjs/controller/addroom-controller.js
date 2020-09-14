app.controller("addroomController", function($scope, datasource,
		serverEndpoints, authentication, navigation, strings, $route, $window) {

	console.log("addroomController()----> Start");
	var lvm = this;

	
	$("#sidebar-panel").show();
	$("#roomRegistration").hide();
	$("#UserRegisteredRoom").hide();

	lvm.showBanner = true;

	lvm.getAllRooms = function() {
		
		var header = {};
		header[serverEndpoints.sessionToken]=authentication.getAdminSessionToken();
		
		// Get product list of portal
		datasource.getData(
				serverEndpoints.showAllRoomsUrl, {},
				header, function(isSuccess, data) {

					if (isSuccess) {
						lvm.room = data;
						
					}
				});
	}
	
	lvm.getAllRooms();
	
	
	lvm.addroom = function() {

		var header = {};
		header[serverEndpoints.sessionToken] = authentication.getAdminSessionToken();

		var uploadData = {};
		
		uploadData[serverEndpoints.roomType] = lvm.room.roomType;
		uploadData[serverEndpoints.roomNo] = lvm.room.roomNo;
		uploadData[serverEndpoints.capacity] = lvm.room.capacity;

		// Get product list of portal
		datasource.getData(serverEndpoints.AddRoomUrl, uploadData,
				header, function(isSuccess, data) {

					if (isSuccess) {
						alert("Room Added Succesfully");
						window.location.href= navigation.routes.ALLROOMS;
					} else {

					}
				});
	}
	lvm.removeRoom = function (id) {
		$(".loader-background").css("display", "flex");

		var header = {};
		header[serverEndpoints.sessionToken] = authentication
			.getAdminSessionToken();

		
		header[serverEndpoints.id] = id;
		// Get product list of portal
		datasource.getData(serverEndpoints.deleteRoomByIdUrl, {},
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
		lvm.requestedRoomId = id;
		$("#deleteModal").modal("show")
	}

	console.log("addroomController()---->End");
})