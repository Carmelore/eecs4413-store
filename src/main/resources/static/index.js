let cart = sessionStorage.getItem("cart");
console.log(cart);
if (cart == null || !cart) {
	sessionStorage.setItem("cart", JSON.stringify({items: [], totalQuantity: 0, totalPrice: 0}))
}