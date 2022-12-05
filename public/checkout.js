var app = angular.module('Group-V_Store', []);
let count = 0;
app.controller("CheckoutController", function ($scope) {
	$scope.message = "Shoppity Checkout";
	
})

function submitOrder(e) {
	console.log(e);
	count++;
	const firstName = document.getElementById('firstName');
	const lastName = document.getElementById('lastName');
	alert(firstName, lastName);
	if (count % 3 == 0){
		alert("Payment failed");
	}else {
		alert("Payment succeeded");
	}
}