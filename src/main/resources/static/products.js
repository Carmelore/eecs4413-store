angular.module('Group-V_Store').controller('ProductsController', function($scope, $http, $routeParams, $location) {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const type = $routeParams.get('type') ?? '';
	const brand = $routeParams.get('brand') ?? '';

	$http.get(`/products?type=${type}&brand=${brand}`)
		.then(function(response) {
			$scope.products = response.data;
		});

	$scope.logVisit = function(productId, status) {
		$http.get('https://api.ipify.org/?format=json')
			.then((response) => {
				$http.post('/visits', { ip_address: response.data.ip, product: productId, status: status });
			});
	}

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
		if (index != -1) {
			cart.items[index].amount += 1;
		} else {
			product.amount = 1;
			cart.items.push(product);
		}
		cart.totalQuantity = 0;
		var subtotal = 0;
		var totalDiscounts = 0;
		var percentageDiscount = 0;
		for (let i = 0; i < cart.items.length; i++) {
			subtotal += cart.items[i].price * cart.items[i].amount;
			cart.totalQuantity += cart.items[i].amount;
		}
		cart.totalPrice = subtotal;
		for (let i = 0; i < cart.discounts.length; i++) {
			//
			console.log(cart.discounts[i].type === "total")
			if (cart.discounts[i].type === "total" && cart.discounts[i].required_spending < subtotal) {
				totalDiscounts += cart.discounts[i].discount;
			}
			//
			if (cart.discounts[i].type === "percent" && cart.discounts[i].required_spending < subtotal) {
				percentageDiscount += cart.discounts[i].discount;
			}
		}
		cart.totalPrice -= totalDiscounts;
		cart.totalPrice = cart.totalPrice * (1 - (percentageDiscount / 100));
		if (cart.totalPrice < 0) {
			cart.totalPrice = 0;
		}
		sessionStorage.setItem("cart", JSON.stringify(cart));
	}
}
);
