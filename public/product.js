angular.module('Group-V_Store', []).controller('Product', function($scope, $http) {
	// get list of products
	$http.get('http://localhost:8080/products')
		.then(function(response) {
			$scope.products = response.data;
		});
	
//	$scope.add = function() {
//		let hasNewRecord = false;
//		
//		angular.forEach($scope.products, function (product) {
//			if (product.id == null && !product.deleted) {
//				hasNewRecord = true;
//			}
//		});
//		
//		if (!hasNewRecord) {
//			$scope.employees.push({id:null});
//		}
//	};
//	
//	$scope.save = function() {
//	}
});