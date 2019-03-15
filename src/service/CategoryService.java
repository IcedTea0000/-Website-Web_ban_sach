package service;

import java.util.List;

import model.Category;

public interface CategoryService {
	public void add(Category newCategory);

	public void update(Category newCategory);

	public void delete(int categoryId);

	public Category getById(int categoryId);

	public Category getByName(String categoryName);

	public boolean checkCategoryExisted(String categoryName);

	public List<Category> searchByName(String categoryName);
}
