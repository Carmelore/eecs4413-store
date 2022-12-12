angular.module('Group-V_Store', []).controller('ProductController', function($scope, $http) {
	// get list of products
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	
	$http.get(`http://localhost:8080/product?id=${urlParams.get('id')}`)
		.then(function(response) {
			$scope.product = response.data;
		});
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