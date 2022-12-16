angular.module('Group-V_Store', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/', {
        templateUrl: 'index.html',
    }).when('/registration', {
		templateUrl: 'registration.html',
		controller: 'User',
	}).when('/login', {
		templateUrl: 'login.html',
		controller: 'User',
	}).when('/cart', {
		templateUrl: 'cart.html',
		controller: "CartController"
	}).when('/checkout', {
		templateUrl: 'checkout.html',
	}).when('/product', {
		templateUrl: 'product.html',
	}).when('/admin', {
		templateUrl: 'admin.html',
	}).otherwise({
        redirectTo: "/"
    });
});