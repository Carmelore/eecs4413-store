var app = angular.module('Group-V_Store', ['ngRoute']);
var products = angular.module('Group-V_Store', []);
app.config(['$routeProvider', function($routeProvider) {
                $routeProvider.when('/checkout.html', {
                    templateUrl: 'checkout.html',
                    controller: 'CheckoutController'
                }).otherwise({
                    redirectTo: '/'
                });
            }]);
app.controller('CheckoutController', function($scope) {
    $scope.message = "Shoppity";
});
products.controller('Product', function($scope, $http) {
	// get list of products
	$http.get('http://localhost:8080/products')
		.then(function(response) {
			$scope.products = response.data;
		});
});


