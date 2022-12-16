angular.module('Group-V_Store', []).controller('ProductsController', function($scope, $http) {
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

