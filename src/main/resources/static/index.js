let cart = sessionStorage.getItem("cart");
console.log(cart);
if (cart == null || !cart) {
//Change this for discCodes thanks
	sessionStorage.setItem("cart", JSON.stringify({items: [], totalQuantity: 0, totalPrice: 0}))
}
