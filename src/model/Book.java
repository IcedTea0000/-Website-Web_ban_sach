package model;

public class Book {
	private int id;
	private String title;
	private String description;
	private double price;
	private Category category;
	private String author;
	private int stock;
	private String status; //sale, hot, featured
	private String picture_name;

	public Book() {
	}

	public Book(String title, String description, double price, Category category, String author, int stock) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
		this.author = author;
		this.stock = stock;
	}
	
	public Book(int id,String title, String description, double price, Category category, String author, int stock) {
		this.id=id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
		this.author = author;
		this.stock = stock;
	}
	
	public Book(int id,String title, String description, double price, Category category, String author, int stock, String status, String picture_name) {
		this.id=id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
		this.author = author;
		this.stock = stock;
		this.status=status;
		this.picture_name=picture_name;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

	
	
}
