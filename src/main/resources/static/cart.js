angular.module('Group-V_Store').controller('CartController', ['$scope', '$http', function($scope, $http, $window) {
    $scope.cart = JSON.parse(sessionStorage.getItem("cart"));
    // Remove an item from the cart
    console.log($scope.cart, "CART");
    $scope.removeFromCart = function(product) {
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
        $scope.cart.items = [];
        $scope.cart.totalQuantity = 0;
        $scope.cart.totalPrice = 0;
        sessionStorage.setItem("cart", JSON.stringify($scope.cart));
    }
    // Update the quantity of an item in the cart
    $scope.updateQuantity = function(product, quantity) {
    console.log("HELLO", $scope.cart.items);
    if (quantity <= 0){
	quantity = 0;
	let removeFromCart = prompt(`Do you want to remove ${product.name} from the cart?`)
	if (removeFromCart){
			return $scope.removeFromCart(product);
	}
	
	}
    const ind = $scope.cart.items.findIndex(e => e.name === product.name && e.id === product.id)
    const diff = (quantity - $scope.cart.items[ind].amount)
    $scope.cart.totalPrice += diff * product.price
    $scope.cart.items[ind].amount = quantity;
    $scope.cart.totalQuantity += diff;
    sessionStorage.setItem("cart", JSON.stringify($scope.cart));
    };
  }]);