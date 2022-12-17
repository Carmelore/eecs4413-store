angular.module('Group-V_Store').controller('ProductsController',
	['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {
		const type = $routeParams.type || "";
		const brand = $routeParams.brand || "";
		
		$http.get(`http://localhost:8080/products?type=${type}&brand=${brand}`)
			.then(function(response) {
				$scope.products = response.data;
			});
		
		$scope.searchByBrand = function() {
			$location.path(`products/brand/${$scope.brand}`);
		}
		
		$scope.searchByType = function() {
			$location.path(`products/type/${$scope.type}`);
		}
		$scope.addToCart = function(product) {
		//$window.sessionStorage.removeItem("cart");
		let cart = JSON.parse(sessionStorage.getItem("cart"));
		console.log(cart);
		let index = cart.items.findIndex(item => item.name === product.name && item.id === product.id);
		if (index != -1){
			cart.items[index].amount += 1;
		} else {
			product.amount = 1;
			cart.items.push(product);
		}
		cart.totalQuantity += 1;
		cart.totalPrice += product.price;
		sessionStorage.setItem("cart", JSON.stringify(cart));
	}
}]);
