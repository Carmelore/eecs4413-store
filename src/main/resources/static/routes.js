angular.module('Group-V_Store', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/', {
        templateUrl: 'index.html',
        controller: 'CartController'
        }).when('/registration', {
		templateUrl: 'registration.html',
		controller: 'User',
	}).when('/login', {
		templateUrl: 'login.html',
		controller: 'User',
	}).when('/checkout', {
		templateUrl: 'checkout.html',
		controller: 'Checkout'
	})
	.otherwise({
        redirectTo: "/"
    });
});