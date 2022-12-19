angular.module('Group-V_Store').controller('CartController', ['$scope', '$http', function($scope, $http, $window) {

	$scope.cart = JSON.parse(sessionStorage.getItem("cart"));
	if ($scope.cart == null) {
		sessionStorage.setItem("cart", JSON.stringify({ items: [], discounts:[], totalPrice: 0, totalQuantity: 0 }));
		$scope.cart = JSON.parse(sessionStorage.getItem("cart"));
	}
	console.log($scope.cart, 'cart');

	$scope.resetCart = () => {
		sessionStorage.setItem("cart", null);

	}

	// Remove an item from the cart
	console.log($scope.cart, "CART");
	$scope.removeFromCart = function(product) {
		let cart = JSON.parse(sessionStorage.getItem("cart"));
		const findProduct = $scope.cart.items.findIndex(e => Object.is(e, product))
		console.log(findProduct);
		if (findProduct != -1) {
			$scope.cart.items.splice(findProduct, findProduct + 1);
			$scope.cart.totalQuantity -= product.amount;
			$scope.cart.totalPrice -= product.price * product.amount;
			sessionStorage.setItem("cart", JSON.stringify($scope.cart))
		} else {
			alert("Couldn't remove product");
		}
	};
	$scope.addToCart = function(product) {
		console.log(product);
		console.log($scope.cart);

	}
	$scope.clearCart = () => {
		let cart = JSON.parse(sessionStorage.getItem("cart"));
		cart.items = [];
		cart.totalQuantity = 0;
		cart.totalPrice = 0;
		sessionStorage.setItem("cart", JSON.stringify(cart));
		$scope.cart = cart;
	}
	// Update the quantity of an item in the cart
	$scope.updateQuantity = function(product, quantity) {
		let cart = JSON.parse(sessionStorage.getItem("cart"));
		console.log(cart);
		if (quantity <= 0) {
			quantity = 0;
			let removeFromCart = confirm(`Do you want to remove ${product.name} from the cart?`)
			if (removeFromCart) {
				return $scope.removeFromCart(product);
			} else { return; }

		}

		const ind = cart.items.findIndex(e => e.name === product.name && e.id === product.id)
		const diff = (quantity - cart.items[ind].amount)

		cart.items[ind].amount = quantity;

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

		$scope.cart = cart;
		sessionStorage.setItem("cart", JSON.stringify($scope.cart));
	};
}]);
