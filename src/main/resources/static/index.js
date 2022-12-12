
angular.module('Group-V_Store').controller('CartController', ['$scope', '$http', function($scope, $http) {
    // Retrieve the cart from the server
    $http.get('/api/cart')
      .then(function(response) {
        $scope.cart = response.data;
      });
	$http.get('http://localhost:8080/products')
		.then(function(response) {
			$scope.products = response.data;
		});
    // Add an item to the cart
    $scope.addToCart = function(product) {
      // Convert the request body to a JSON string
      var requestBody = JSON.stringify({ cart: $scope.cart, product: product, quantity: 1 });

      // Send the request body as a JSON string
      $http.post('/api/cart/add', {cart: $scope.cart,  product: product, quantity: 1 })
        .then(function(response) {
          // Update the cart in the frontend
          $scope.cart = response.data;
        });
    };

    // Remove an item from the cart
    $scope.removeFromCart = function(product) {
      $http.post('/api/cart/remove', { product: product })
        .then(function(response) {
          // Update the cart in the frontend
          $scope.cart = response.data;
        });
    };

    // Update the quantity of an item in the cart
    $scope.updateQuantity = function(product, quantity) {
      $http.post('/api/cart/update', { product: product, quantity: quantity })
        .then(function(response) {
          // Update the cart in the frontend
          $scope.cart = response.data;
        });
    };

  }]);
