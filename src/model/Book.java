package model;

public class Book {
	private int id;
	private String title;
	private String description;
	private double price;
	private Category category;
	private String author;
	private int stock;

	public Book() {
	}

	public Book(int id, String title, String description, double price, Category category, String author, int stock) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
		this.author = author;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
