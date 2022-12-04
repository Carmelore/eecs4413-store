angular.module('Group-V_Store', ['ngRoute']).config(function ($routeProvider) {
	$routeProvider.when('/', {
        templateUrl: '/index.html',
    }).when('/registration', {
		templateUrl: '/registration.html',
		controller: 'user',
	}).when('/login', {
		templateUrl: '/login.html',
		controller: 'user',
	}).otherwise({
        redirectTo: "/"
    });
});