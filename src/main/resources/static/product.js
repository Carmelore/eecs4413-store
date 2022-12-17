angular.module('Group-V_Store').controller('ProductController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {
	const productId = $routeParams.id
	
	$http.get(`http://localhost:8080/product?id=${productId}`)
		.then(function(response) {
			$scope.product = response.data;
			
			// can't get this working due to a CORS issue	
		//	$http.get('https://api.ipify.org/?format=json')
		//		.then((response) => {
		//			let ipa = response.data.ip;
		//			$http.post('/visits', {ipAddress: ipa, productId: productId, status: 'VIEWED'});
		//		});
		
			// so just randomly generating IP addresses instead :(
			
			let ipa = "";
			for (let i = 0; i < 3; i++) {
				ipa += Math.floor(Math.random() * 999 + 1);
				ipa += ".";
			}
			ipa += Math.floor(Math.random() * 999 + 1);
			
			$http.post('/visits', {ipAddress: ipa, productId: productId, status: 'VIEWED'});
		});
	
	$http.get(`/reviews?id=${productId}`)
		.then(function(response) {
			$scope.reviews = response.data;
		})
		
	$scope.addReview = function() {
		let errorMessages = document.getElementsByClassName("error");
		[].forEach.call(errorMessages, (message) => {
			message.innerHTML = "";
		});
		
		if (!validateName($scope.review.reviewer)) {
			document.getElementById("reviewerError").innerHTML = "Invalid name";
			return;
		}
		
		let onSuccess = function() {
			location.reload();
        };
        
        let onError = function() {
			document.getElementById("reviewError").innerHTML = "Error submitting review, please try again";
		};
		
		$http.post('/reviews', {reviewer: $scope.review.reviewer, stars: $scope.review.stars, details: $scope.review.details, productId: productId})
			.success(onSuccess)
			.error(onError);
	}
}]);

function validateName(name) {
	let pattern = new RegExp("^[a-zA-ZÀ-ž-' ]+$");
	return pattern.test(name);
}
