angular.module('Group-V_Store', []).controller('User', function($scope, $http, $location) {

	$http.get('/users')
		.then(function(response) {
			$scope.users = response.data;
		});
	
	$scope.login = function() {
	}
	
	$scope.register = function() {
		let error = false;
		
		// TODO: what validation should we have on name and username?
		
		if ($scope.user.password.length < 8) {
			error = true;
			document.getElementById("passwordError").innerHTML = "Password must be at least 8 characters long";
		}
		else if ($scope.user.password !== $scope.user.password2) {
			console.log($scope.user.password);
			console.log($scope.user.password2);
			error = true;
			document.getElementById("password2Error").innerHTML = "Passwords must match";
		}
		
		if (error) return;
		
		let onSuccess = function () {
			window.location.href = '/login.html';
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