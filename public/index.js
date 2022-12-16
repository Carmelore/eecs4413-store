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
app.config(['$locationProvider', function($locationProvider){
    $locationProvider.html5Mode(true);
}]);
app.controller('CheckoutController', function($scope) {
    $scope.message = "Shoppity";
});


