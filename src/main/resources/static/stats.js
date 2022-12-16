angular.module('Group-V_Store').controller('Stats', function($scope, $http) {
	
	$http.get("/sales")
		.then(function(response) {
			$scope.sales = response.data;
		})
		.then(function() {
			const today = new Date();
			$scope.month = today.toLocaleString("default", { month: "long" });
		})
	
	$http.get("/visits")
		.then(function(response) {
			$scope.visits = response.data;
		})
});