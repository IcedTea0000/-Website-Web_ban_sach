package controller.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

@WebServlet (urlPatterns= {"/admin/category/add"})
public class AddCategoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/category/AddCategory.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newCategoryName=req.getParameter("name");
		String newCategoryDescription=req.getParameter("description");
		CategoryService categoryService=new CategoryServiceImpl();
		Category newCategory=new Category(newCategoryName, newCategoryDescription);
		
		if (categoryService.checkCategoryExisted(newCategoryName)) {
			req.setAttribute("categoryNameExisted", "category name existed");
			req.setAttribute("category", newCategory);
			RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/category/AddCategory.jsp");
			dispatcher.forward(req, resp);
		}
		else {
		categoryService.add(newCategory);
		
		//redirect to search-all result
		resp.sendRedirect(req.getContextPath()+"/admin/category/search-result?keyword=");
		}
	}
}
