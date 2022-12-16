angular.module('Group-V_Store', ['ngRoute']).config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: 'index.html',
	}).when('/registration', {
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
	}).when('/checkout', {
		templateUrl: 'checkout.html',
		controller: 'Checkout'
	}).when('/products', {
		templateUrl: 'products.html',
	})
		.otherwise({
			redirectTo: "/"
		});
});
