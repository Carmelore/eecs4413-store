angular.module('Group-V_Store', []).controller('ProductController', function($scope, $http) {
	// get list of products
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	
	$http.get(`http://localhost:8080/product?id=${urlParams.get('id')}`)
		.then(function(response) {
			$scope.product = response.data;
		});
		
	$scope.addReview = function(productId) {
		let errorMessages = document.getElementsByClassName("error");
		[].forEach.call(errorMessages, (message) => {
			message.innerHTML = "";
		});
		
		if (!validateName($scope.review.reviewer)) {
			document.getElementById("reviewerError").innerHTML = "Invalid name";
			return;
		}
		
		let onSuccess = function() {
			location.reload;
        };
        
        let onError = function() {
			document.getElementById("reviewError").innerHTML = "Error submitting review, please try again";
		};
		
		$http.post('/review', {reviewer: $scope.review.reviewer, stars: $scope.review.stars, details: $scope.review.details, product: productId})
			.success(onSuccess)
			.error(onError);
	}
});

function validateName(name) {
	let pattern = new RegExp("^[a-zA-ZÀ-ž-' ]+$");
	return pattern.test(name);
}