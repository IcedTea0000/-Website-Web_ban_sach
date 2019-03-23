package model;

public class User {
	private int id;
	private String name;
	private String address;
	private String username;
	private String password;
	private String role;
	private String info;
	private String picture_name;

	public User() {
	}
	
	public User(String name, String address, String username, String password, String role, String info) {
		this.name = name;
		this.address = address;
		this.username = username;
		this.password = password;
		this.role = role;
		this.info = info;
	}
	
	public User(int id, String name, String address, String username, String password, String role, String info) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.username = username;
		this.password = password;
		this.role = role;
		this.info = info;
	}

	public User(int id, String name, String address, String username, String password, String role, String info,String picture_name) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.username = username;
		this.password = password;
		this.role = role;
		this.info = info;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

	
	
}
