angular.module('Group-V_Store').controller('CartController', ['$scope', '$http', function($scope, $http) {
	$scope.cart = JSON.parse($window.sessionStorage.getItem("cart"));

    // Remove an item from the cart
    $scope.removeFromCart = function(productId) {
		for (let i = 0; i < $scope.cart.length; i++) {
			if ($scope.cart[i] === productId) {
				$scope.cart.splice(i, 1);
			}
		}
    };

    // Update the quantity of an item in the cart
    $scope.updateQuantity = function(product, quantity) {
    };
  }]);
