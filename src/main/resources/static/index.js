let cart = sessionStorage.getItem("cart");
if (cart == null || !cart) {
	sessionStorage.setItem("cart", JSON.stringify({items: [], totalQuantity: 0, totalPrice: 0}))
}
console.log(JSON.parse(sessionStorage.getItem("cart")))
