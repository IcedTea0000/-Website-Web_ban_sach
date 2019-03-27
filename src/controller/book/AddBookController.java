package controller.book;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Book;
import model.Category;
import service.BookService;
import service.CategoryService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/book/add" })
public class AddBookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.searchByName("");
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/book/AddBook.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		try {
			List<FileItem> fileList = fileUpload.parseRequest(req);
			Book newBook = new Book();
			
			
			for (FileItem file : fileList) {
				if (file.getFieldName().equals("title")) {
					String title = file.getString();
					newBook.setTitle(title);
				} else if (file.getFieldName().equals("description")) {
					String description = file.getString();
					newBook.setDescription(description);
				} else if (file.getFieldName().equals("price")) {
					double price = Double.parseDouble(file.getString());
					newBook.setPrice(price);

				} else if (file.getFieldName().equals("author")) {
					String author = file.getString();
					newBook.setAuthor(author);
				} else if (file.getFieldName().equals("stock")) {
					int stock = Integer.parseInt(file.getString());
					newBook.setStock(stock);
				} else if (file.getFieldName().equals("status")) {
					String status = file.getString();
					newBook.setStatus(status);
				} else if (file.getFieldName().equals("categoryName")) {
					String categoryName = file.getString();
					CategoryService categoryService = new CategoryServiceImpl();
					Category category = categoryService.getByName(categoryName);
					newBook.setCategory(category);
				} else if (file.getFieldName().equals("picture_name")) {
					if (file.getSize() > 0) {
						// get file's name
						String originalName = file.getName();
						int index = originalName.lastIndexOf("\\");
						String pictureName = originalName.substring(index + 1);
						newBook.setPicture_name(pictureName);

						// save file
						String PICTURE_FOLDER = "D:\\javaWorkspace\\GreatBookList\\WebContent\\view\\images\\book\\";
						File pictureFile = new File(PICTURE_FOLDER + pictureName);
						file.write(pictureFile);
						
						BookService bookService = new BookServiceImpl();
						bookService.add(newBook);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// redirect to search-all result
		resp.sendRedirect("search-result?categoryName=all&keyword=");
	}
}
