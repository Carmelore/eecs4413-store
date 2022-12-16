angular.module('Group-V_Store', []).controller('ProductsController', function($scope, $http) {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const type = urlParams.get('type') ?? '';
	const brand = urlParams.get('brand') ?? '';
	
	$http.get(`http://localhost:8080/products?type=${type}&brand=${brand}`)
		.then(function(response) {
			$scope.products = response.data;
		});
		$scope.cart = JSON.parse(sessionStorage.getItem("cart"));
		$scope.addToCart = (product) => {
		const findProduct = $scope.cart.items.findIndex(e => e.name === product.name && e.brand === product.brand && e.id === product.id);
		console.log(findProduct);
		if (findProduct != -1){
			console.log($scope.cart.items[findProduct].amount);
			$scope.cart.items[findProduct].amount += 1;
		} else {
			product.amount = 1;
			$scope.cart.items.push(product);
		}
		$scope.cart.totalQuantity += 1;
		$scope.cart.totalPrice += product.price
		sessionStorage.setItem("cart", JSON.stringify($scope.cart));
	}
});
	
	$scope.logVisit = function(productId, status) {
		$http.get('https://api.ipify.org/?format=json')
			.then((response) => {
				$http.post('/visits', {ip_address: response.data.ip, product: productId, status: status});
			});
	}
});

function searchByType() {
	const type = document.getElementById("type").value;
	window.location.href = `products.html?type=${type}`
}

function searchByBrand() {
	const brand = document.getElementById("brand").value;
	window.location.href = `products.html?brand=${brand}`
}

