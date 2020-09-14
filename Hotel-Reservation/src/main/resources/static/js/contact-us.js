var app = angular.module("customForm", []);
app.controller("contactUsCtrl", function($scope, $http) {

	var lvm = this;

	lvm.sendEnquiry = function() {
		//document.getElementById("overlay").style.display = "block";
		$(".loader-background").css("display", "flex");

		var postData = {};
		postData.firstName = lvm.firstName;
		postData.lastName = lvm.lastName;
		postData.email = lvm.email;
		postData.subject = lvm.subject;
		postData.message = lvm.message;
		postData.packageName = packageName;
		postData.mobileNumber=lvm.mobileNumber;

		$http({
			method : 'POST',
			url : 'contactUsRequest',
			data : postData,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(res) {
			$(".loader-background").css("display", "none");
			//document.getElementById("overlay").style.display = "none";
			console.log('succes !', res.data);
			alert("Request Sent Succesfully !!");
			$("#success").modal("show");

		}, function(err) {
			$(".loader-background").css("display", "none");
			//document.getElementById("overlay").style.display = "none";
			console.log('error...', err);
			$("#registraionError").modal("show");
		});
	}
});
