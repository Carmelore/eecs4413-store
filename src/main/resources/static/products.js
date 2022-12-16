angular.module('Group-V_Store').controller('ProductsController', function($scope, $http) {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const type = urlParams.get('type') ?? '';
	const brand = urlParams.get('brand') ?? '';
	
	$http.get(`http://localhost:8080/products?type=${type}&brand=${brand}`)
		.then(function(response) {
			$scope.products = response.data;
		});
	
	$scope.logVisit = function(productId, status) {
		$http.get('https://api.ipify.org/?format=json')
			.then((response) => {
				$http.post('/visits', {ip_address: response.data.ip, product: productId, status: status});
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
