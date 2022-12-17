angular.module('Group-V_Store', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/', {
        templateUrl: 'products.html',
        controller: 'ProductsController',
    }).when('/products/type/:type', {
		templateUrl: 'products.html',
		controller: 'ProductsController',
    }).when('/products/brand/:brand', {
		templateUrl: 'products.html',
		controller: 'ProductsController',
    }).when('/product/:id', {
		templateUrl: 'product.html',
		controller: 'ProductController',
    }).when('/registration', {
		templateUrl: 'registration.html',
		controller: 'User',
	}).when('/login', {
		templateUrl: 'login.html',
		controller: 'User',
	}).when('/admin', {
		templateUrl: 'admin.html',
		controller: 'Stats',
	}).when('/checkout', {
		templateUrl: 'checkout.html',
		controller: 'CheckoutController',
	}).otherwise({
        redirectTo: "/"
    });
});