let cart = sessionStorage.getItem("cart");
console.log(cart);
if (!cart) {
//Change this for discCodes thanks
	console.log("resetting cart");
	sessionStorage.setItem("cart", JSON.stringify({items: [], discounts: [], totalQuantity: 0, totalPrice: 0}))
}
