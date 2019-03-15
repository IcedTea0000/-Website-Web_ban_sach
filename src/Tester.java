import java.util.List;

import dao.impl.CategoryDaoImpl;
import dao.impl.UserDaoImpl;
import model.Category;
import model.User;
import service.CategoryService;
import service.UserService;
import service.impl.CategoryServiceImpl;
import service.impl.UserServiceImpl;

public class Tester {
//testing methods and objects
	public static void main(String[] args) {
		CategoryService categoryService=new CategoryServiceImpl();
		Category category=categoryService.getByName("classic");
		//System.out.println(category.getName());
		
		System.out.println(categoryService.checkCategoryExisted("classic"));
	}
}
