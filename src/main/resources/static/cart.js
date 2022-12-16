angular.module("Group-V_Store").controller("CartController", function ($scope) {

	$scope.cart = JSON.parse(sessionStorage.getItem("cart"));
	if ($scope.cart == null){
		sessionStorage.setItem("cart", JSON.stringify({items: [], totalPrice: 0, totalQuantity: 0}));
		$scope.cart = JSON.parse(sessionStorage.getItem("cart"));
	}
			console.log($scope.cart, 'cart');

	$scope.resetCart = () => {
		sessionStorage.setItem("cart", null);
		
	}
})