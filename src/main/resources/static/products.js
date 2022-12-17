angular.module('Group-V_Store').controller('ProductsController',
	['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {
		const type = $routeParams.type || "";
		const brand = $routeParams.brand || "";
		
		$http.get(`http://localhost:8080/products?type=${type}&brand=${brand}`)
			.then(function(response) {
				$scope.products = response.data;
			});
		
		$scope.searchByBrand = function() {
			$location.path(`products/brand/${$scope.brand}`);
		}
		
		$scope.searchByType = function() {
			$location.path(`products/type/${$scope.type}`);
		}
}]);