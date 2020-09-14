/**
 * App routes
 */

app.config(function($routeProvider, $locationProvider) {
	
	$routeProvider.when('/', {
		templateUrl : 'angularjs/partial_views/customers.html?v='+appVersion,
		controller : 'customerController',
		controllerAs : 'lvm'
	}).when('/allcustomers', {
		templateUrl : 'angularjs/partial_views/customers.html?v='+appVersion,
		controller : 'customerController',
		controllerAs : 'lvm'
	}).when('/customerdetails', {
		templateUrl : 'angularjs/partial_views/customerdetails.html?v='+appVersion,
		controller : 'customerDetailsController',
		controllerAs : 'lvm'
	}).when('/login', {
		templateUrl : 'angularjs/partial_views/login.html?v='+appVersion,
		controller : 'loginController',
		controllerAs : 'lvm'
	}).when('/customerlogin', {
		templateUrl : 'angularjs/partial_views/customerlogin.html?v='+appVersion,
		controller : 'loginController',
		controllerAs : 'lvm'
	}).when('/addroom', {
		templateUrl : 'angularjs/partial_views/addroom.html?v='+appVersion,
		controller : 'addroomController',
		controllerAs : 'lvm'
	}).when('/allrooms', {
		templateUrl : 'angularjs/partial_views/allrooms.html?v='+appVersion,
		controller : 'addroomController',
		controllerAs : 'lvm'
	}).when('/registercustomer', {
		templateUrl : 'angularjs/partial_views/registercustomer.html?v='+appVersion,
		controller : 'registerCustomerController',
		controllerAs : 'lvm'
	}).when('/registeredroom', {
		templateUrl : 'angularjs/partial_views/registeredroom.html?v='+appVersion,
		controller : 'registeredRoomController',
		controllerAs : 'lvm'
	}).when('/reservedroom', {
		templateUrl : 'angularjs/partial_views/reservedroom.html?v='+appVersion,
		controller : 'reservedRoomController',
		controllerAs : 'lvm'
	});

	
	$locationProvider.html5Mode(true);
});