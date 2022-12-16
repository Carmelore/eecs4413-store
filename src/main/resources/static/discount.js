angular.module('Group-V_Store').controller('Discount', function($scope, $http, $window) {

	$scope.checkDiscount = function(){
		console.log($http.get('/discount-check', $scope.code));
	}

	$scope.createDiscount = function() {
		console.log($scope.code);
		$http.post('/discount-create', {code: $scope.code, discount: $scope.discount, required_spending: $scope.required_spending, type: $scope.type});
	}

});