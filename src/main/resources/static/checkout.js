const cardNum = document.getElementById("cardNumber");
angular.module('Group-V_Store').controller('Checkout', function($scope, $http) {	
		document.getElementById("cardNumber").addEventListener("input", (e) => {
					e.preventDefault();
		if (document.getElementById("cardNumber").value.length >= 19){
			e.preventDefault();
		} else if ((document.getElementById("cardNumber").value.length + 1) % 5 == 0 && e.data) {
			document.getElementById("cardNumber").value += " "
		}
		
		
	})
	document.getElementById("cardNumber").addEventListener("keydown", e => {
		if (document.getElementById("cardNumber").value.length >= 19 && e.key !== "Backspace"){
			e.preventDefault();
		}
	})
	document.getElementById("cardExp").addEventListener("input", e => {
		if (document.getElementById("cardExp").value.length == 2 && e.data){
			document.getElementById("cardExp").value += "/"
		}
	})
	document.getElementById("cardExp").addEventListener("keydown", e => {
		if (document.getElementById("cardExp").value.length >= 5 && e.key !== "Backspace"){
			e.preventDefault();
		}
	})
	$scope.cart = JSON.parse(sessionStorage.getItem("cart"))
	$scope.user = JSON.parse(sessionStorage.getItem("user"));
	if ($scope.user){
		$scope.email = $scope.user.username;
		$scope.firstName = $scope.user.name
		$scope.address = $scope.user.shipping_address;
		$scope.adressBilling = $scope.user.billing_address;
	}
	$scope.count = 0;
	$scope.submit = () => {
		let invalid = false;
		if (!$scope.user){
			alert("You must sign in to complete your order")
			return;
		}
		if ($scope.cart.items.length <= 0){
			alert("You must add items to your cart!");
			return;
		}
		const data = {
			user: $scope.user,
			items: $scope.cart.items,
			shippingInfo: {
				firstName: $scope.firstName,
				lastName: $scope.lastName,
				address: $scope.address,
				optionalAddress: $scope.optionalAddress,
				city: $scope.city,
				postalCode: $scope.postalCode,
				province: $scope.province
			},
			billingAddress: {
				address: $scope.addressBilling,
				optionalAddress: $scope.optionalAddressBilling,
				city: $scope.cityBilling,
				postalCode: $scope.postalCodeBilling,
				province: $scope.provinceBilling	
				},
			paymentInfo: {
				cardNumber: $scope.cardNumber,
				expiry: $scope.cardExp,
				cvc: $scope.cvc,
				cardName: $scope.cardName,
				discountCode: $scope.discountCode
			},
			contactInfo: {
				email: $scope.email,
				phoneNumber: $scope.phoneNum
			}
			
		}
				if ($scope.sameAddress){
			data.billingAddress = data.shippingInfo;
			}
			Object.keys(data.shippingInfo).forEach(key => {
				if (!data.shippingInfo[key]){

					invalid = true;
				}
			})
			Object.keys(data.paymentInfo).forEach(key => {
				if (!data.paymentInfo[key] && key !== "discountCode"){
					invalid = true;
				}
			})
			Object.keys(data.billingAddress).forEach(key => {
				if (!data.billingAddress[key]){
					invalid = true;
				}
			})
			if (!$scope.email || !$scope.phoneNum){
				
				alert("Need to provide contact information");
				return;
			}
			
		if ($scope.count % 3 == 0 && $scope.count > 0){
			alert("Payment failed")
			$scope.count += 1;
			return;
		}
		$scope.count += 1;
		if (invalid){
			alert("Invalid form");
			return;
		}
		$http.post("http://localhost:8080/checkout", JSON.stringify(data))
		.then(response => {
			if (response.data === "success"){
				alert("Order successful");
			}else {
				alert("Error occurred. Please try again");
			}
		}).catch(err => {
			console.log(err);
		})
	}

	
});

let count = 0;