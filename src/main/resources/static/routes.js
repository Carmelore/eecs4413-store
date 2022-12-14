angular.module('Group-V_Store', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/registration', {
		templateUrl: 'registration.html',
		controller: 'User',
	}).when('/login', {
		templateUrl: 'login.html',
		controller: 'User',
	}).when('/admin', {
		templateUrl: 'admin.html',
	}).when('/cart', {
		templateUrl: 'cart.html',
		controller: 'CartController',
	}).otherwise({
        redirectTo: "/"
    });
});
