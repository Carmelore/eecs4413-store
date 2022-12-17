angular.module('Group-V_Store').controller('Discount', function($scope, $http, $window) {
	
	$scope.addDiscount = function() {
		onSuccess = function(response){
			let cart = JSON.parse(sessionStorage.getItem("cart"));
			$scope.newDiscount = JSON.parse(response.data);
			cart.discounts.push($scope.newDiscount);
			sessionStorage.setItem("cart", JSON.stringify(cart));
		}
		$http.post('/discount/check', $scope.code).then(onSuccess, onError);
	}

	$scope.createDiscount = function() {
		console.log($scope.code);
		$http.post('/discount/create', {code: $scope.code, discount: $scope.discount, required_spending: $scope.required_spending, type: $scope.type});
	}

});