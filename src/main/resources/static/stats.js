angular.module('Group-V_Store').controller('Stats', function($scope, $http) {
	
	$http.get("/sales")
		.then(function(response) {
			$scope.sales = response.data;
		})
		.then(function() {
			const today = new Date();
			$scope.month = today.toLocaleString("default", { month: "long" });
		})
	
//	$scope.test = function() {
//		$http.get('https://api.ipify.org/?format=json')
//			.then((response) => {
//				$scope.ip_address = response.data.ip;
//			})
//		
//		$scope.product = 1;
//		$scope.status = 'VIEWED';
//		
//		$http.post('/visits', {ip_address: $scope.ip_address, product: $scope.product, status: $scope.status})
//			.error((data, status, headers, config) => {
//				console.log(config);
//			})
//	}
});