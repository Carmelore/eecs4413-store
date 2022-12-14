angular.module('Group-V_Store', []).controller('ProductController', function($scope, $http, $window) {
	// get list of products
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	
	$http.get(`http://localhost:8080/product?id=${urlParams.get('id')}`)
		.then(function(response) {
			$scope.product = response.data;
		});

	$scope.addToCart = function(productId) {
		//$window.sessionStorage.removeItem("cart");
		if ($window.sessionStorage.getItem("cart") === null) {
			$window.sessionStorage.setItem("cart", JSON.stringify([productId]));
		}
		else {
			let cart = JSON.parse($window.sessionStorage.getItem("cart"));
			cart.push(productId);
			$window.sessionStorage.setItem("cart", JSON.stringify(cart));
		}
		console.log(JSON.parse($window.sessionStorage.getItem("cart")));
	}
});