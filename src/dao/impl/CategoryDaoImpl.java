package dao.impl;

import java.util.List;

import dao.CategoryDao;
import model.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public void add(Category newCategory) {
		// add newCategory object to SQL db
		
	}

	@Override
	public void update(Category newCategory) {
		// update category's information on SQL db where id=newCategory.id
		
	}

	@Override
	public void delete(int categoryId) {
		// delete category with id matches categoryId on SQL db
		
	}

	@Override
	public Category get(int categoryId) {
		// get cetegory object from SQL db where id matches categoryId
		return null;
	}

	@Override
	public List<Category> searchByName(String categoryName) {
		// search SQL db and return a list of categories with names containing categoryName
		return null;
	}

}
