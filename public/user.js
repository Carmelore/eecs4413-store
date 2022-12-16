angular.module('Group-V_Store').controller('User', function($scope, $http, $window) {
	$http.get('/users')
		.then(function(response) {
			$scope.users = response.data;
		});
	
	$scope.login = function() {
        $http.post('/login', $scope.user)
        	.then(function (response) {
				$window.sessionStorage.setItem('user', JSON.stringify(response.data));
				window.location.replace('/');
			}, function () {
				document.getElementById("loginError").innerHTML = "Incorrect username/password combination";
			});
	}

	$scope.logout = function() {
		$window.sessionStorage.removeItem('user');
		window.location.replace('/');
	}
	
	$scope.register = function() {
		let error = false;
		let errorMessages = document.getElementsByClassName("error");
		[].forEach.call(errorMessages, (message) => {
			message.innerHTML = "";
		});
		
		if (!validateName($scope.user.name)) {
			error = true;
			document.getElementById("nameError").innerHTML = "Invalid name";
		}
		
		if (!validateUsername($scope.user.username)) {
			error = true;
			document.getElementById("usernameError").innerHTML = "Usernames can only contain letters, numbers, or dashes";
		}
		
		if ($scope.user.password.length < 8) {
			error = true;
			document.getElementById("passwordError").innerHTML = "Password must be at least 8 characters long";
		}
		else if ($scope.user.password !== $scope.user.password2) {
			error = true;
			document.getElementById("password2Error").innerHTML = "Passwords must match";
		}
		
		if (error) return;
		
		let onSuccess = function() {
			window.location.href = '/login.html';
        };
        
        let onError = function(data, status, headers, config) {
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

function validateName(name) {
	let pattern = new RegExp("^[a-zA-ZÀ-ž-' ]+$");
	return pattern.test(name);
}

function validateUsername(username) {
	let pattern = new RegExp("^[a-zA-Z-_\d]+$");
	return pattern.test(username);
}
