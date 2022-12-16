const cardNum = document.getElementById("cardNumber");
angular.module('Group-V_Store', []).controller('Checkout', function($scope, $http) {
	document.getElementById("cardNumber").addEventListener("input", (e) => {
		e.preventDefault();
		if (document.getElementById("cardNumber").value.length >= 19) {
			e.preventDefault();
		} else if ((document.getElementById("cardNumber").value.length + 1) % 5 == 0 && e.data) {
			document.getElementById("cardNumber").value += " "
		}


	})
	document.getElementById("cardNumber").addEventListener("keydown", e => {
		console.log("KEYDOWN", e)
		if (document.getElementById("cardNumber").value.length >= 19 && e.key !== "Backspace") {
			e.preventDefault();
		}
	})
	document.getElementById("cardExp").addEventListener("input", e => {
		if (document.getElementById("cardExp").value.length == 2 && e.data) {
			document.getElementById("cardExp").value += "/"
		}
	})
	document.getElementById("cardExp").addEventListener("keydown", e => {
		if (document.getElementById("cardExp").value.length >= 5 && e.key !== "Backspace") {
			e.preventDefault();
		}
	})
	$scope.cart = JSON.parse(sessionStorage.getItem("cart"))
	$scope.user = JSON.parse(sessionStorage.getItem("user"));
	$scope.count = 0;
	$scope.submit = () => {

		const data = {
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
				address: $scope.address,
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
		if ($scope.sameAddress) {
			alert("checked");
			data.billingAddress = data.shippingInfo;
		}
		console.log($scope.count);
		console.log(data);
		if ($scope.count % 3 == 0 && $scope.count > 0) {
			alert("Payment failed")
			return;
		}
		$scope.count += 1;
		$http.post("http://localhost:8080/checkout", JSON.stringify(data))
			.then(response => {
				console.log(response.data);
			})
	}


});

let count = 0;