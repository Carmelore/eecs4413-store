angular.module('Group-V_Store').controller('Discount', function($scope, $http, $window) {

	$scope.addDiscount = function() {
		onSuccess = function(response) {
			let cart = JSON.parse(sessionStorage.getItem("cart"));
			console.log(response.data);
			$scope.newDiscount = response.data;
			cart.discounts.push($scope.newDiscount);

			cart.totalQuantity = 0;
			let subtotal = 0;
			let totalDiscounts = 0;
			let percentageDiscount = 0;

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
			window.location.reload();
			console.log(cart);
		}
		$http.post('/discount/check', $scope.code).then(onSuccess);
	}

	$scope.createDiscount = function() {
		console.log($scope.code);
		$http.post('/discount/create', { code: $scope.code, discount: $scope.discount, required_spending: $scope.required_spending, type: $scope.type });
	}

});