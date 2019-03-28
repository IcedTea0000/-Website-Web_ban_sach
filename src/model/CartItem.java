package model;

public class CartItem {
	private int id;
	private Book book;
	private int quantityInCart;
	private int cartOrderId;

	public CartItem() {
	}

	public CartItem(Book book, int quantityInCart) {
		this.book = book;
		this.quantityInCart = quantityInCart;
	}

	public CartItem(int id, Book book, int quantityInCart, int cartOrderId) {
		this.id = id;
		this.book = book;
		this.quantityInCart = quantityInCart;
		this.cartOrderId = cartOrderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantityInCart() {
		return quantityInCart;
	}

	public void setQuantityInCart(int quantityInCart) {
		this.quantityInCart = quantityInCart;
	}

	public int getCartOrderId() {
		return cartOrderId;
	}

	public void setCartOrderId(int cartOrderId) {
		this.cartOrderId = cartOrderId;
	}

}
