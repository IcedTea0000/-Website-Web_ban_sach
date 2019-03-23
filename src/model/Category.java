package model;

public class Category {
	private int id;
	private String name;
	private String description;
	private String picture_name;

	public Category() {
	}
	
	public Category(String name,String description) {
		this.name=name;
		this.description=description;
	}

	public Category(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Category(int id, String name, String description,String picture_name) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.picture_name=picture_name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

}
