import java.util.List;

import dao.impl.CategoryDaoImpl;
import dao.impl.UserDaoImpl;
import model.Book;
import model.Category;
import model.User;
import service.BookService;
import service.CategoryService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.UserServiceImpl;

public class Tester {
//testing methods and objects
	public static void main(String[] args) {
		CategoryService categoryService=new CategoryServiceImpl();
		//Category category=categoryService.getByName("classic");
		//System.out.println(category.getName());
		
		//System.out.println(categoryService.checkCategoryExisted("classic"));
		//Category test=new Category("test11","test11");
		BookService bS=new BookServiceImpl();
		Category cat=new Category("test3","test3");
		Book book=new Book("test3", "test3", 1.1,cat , "test3",5 );
		bS.add(book);
		System.out.println("done");
	}
}
