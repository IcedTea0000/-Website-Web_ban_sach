package service.impl;

import java.util.List;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import model.Category;

//call matching methods from CategoryDaoImpl
public class CategoryServiceImpl implements CategoryDao {
	private CategoryDao categoryDaoImpl=new CategoryDaoImpl();
	
	@Override
	public void add(Category newCategory) {
		categoryDaoImpl.add(newCategory);
	}

	@Override
	public void update(Category newCategory) {
		categoryDaoImpl.update(newCategory);		
	}

	@Override
	public void delete(int categoryId) {
		categoryDaoImpl.delete(categoryId);
	}

	@Override
	public Category get(int categoryId) {
		return categoryDaoImpl.get(categoryId);
	}

	@Override
	public List<Category> searchByName(String categoryName) {
		return categoryDaoImpl.searchByName(categoryName);
	}

}
