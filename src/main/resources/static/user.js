angular.module('Group-V_Store', []).controller('User', function($scope, $http) {

	$http.get('/users')
		.then(function(response) {
			$scope.users = response.data;
		});
	
	$scope.login = function() {
	}
	
	$scope.register = function() {
		let onSuccess = function (data, status, headers, config) {
            alert(status + ": " + data);
        };
        
        var onError = function (data, status, headers, config) {
            console.log(data);
            console.log(status);
            console.log(headers);
            console.log(config);
        };
        
		$http.post('/users', $scope.user)
			.success(onSuccess)
			.error(onError);
	}
});