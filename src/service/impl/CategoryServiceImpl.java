package service.impl;

import java.util.List;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import model.Category;
import service.CategoryService;

//call matching methods from CategoryDaoImpl
public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDaoImpl=new CategoryDaoImpl();
	
	private CategoryServiceImpl(){
	}
	
	private static CategoryServiceImpl instance=new CategoryServiceImpl();
	
	public static CategoryServiceImpl getInstance(){
		return instance;
	}
	
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
	public Category getById(int categoryId) {
		return categoryDaoImpl.getById(categoryId);
	}

	@Override
	public List<Category> searchByName(String categoryName) {
		return categoryDaoImpl.searchByName(categoryName);
	}

	@Override
	public boolean checkCategoryExisted(String categoryName) {
		return categoryDaoImpl.checkCategoryExisted(categoryName);
	}

	@Override
	public Category getByName(String categoryName) {
		return categoryDaoImpl.getByName(categoryName);
	}

}
