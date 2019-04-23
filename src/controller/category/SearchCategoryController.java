package controller.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

@WebServlet (urlPatterns= {"/admin/category/search"})
public class SearchCategoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/category/SearchCategory.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword=req.getParameter("keyword");
		CategoryService categoryService=CategoryServiceImpl.getInstance();
		List<Category>categoryList=categoryService.searchByName(keyword);		
		req.setAttribute("categoryList", categoryList);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/category/SearchResultCategory.jsp");
		dispatcher.forward(req, resp);
	}
	
}
