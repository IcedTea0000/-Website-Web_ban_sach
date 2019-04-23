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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Book;
import model.Category;
import service.BookService;
import service.CategoryService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/book/update" })//?id=1
public class UpdateBookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("id"));
		BookService bookService = BookServiceImpl.getInstance();
		Book oldBook = bookService.getById(bookId);
		req.setAttribute("oldBook", oldBook);

		CategoryService categoryService = CategoryServiceImpl.getInstance();
		List<Category> categoryList = categoryService.searchByName("");
		req.setAttribute("categoryList", categoryList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/book/UpdateBook.jsp");
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
				if (file.getFieldName().equals("id")) {
					int id = Integer.parseInt(file.getString());
					newBook.setId(id);
				} else if (file.getFieldName().equals("title")) {
					String title = file.getString();
					newBook.setTitle(title);
				} else if (file.getFieldName().equals("description")) {
					String description = file.getString();
					newBook.setTitle(description);
				} else if (file.getFieldName().equals("author")) {
					String author = file.getString();
					newBook.setAuthor(author);
				} else if (file.getFieldName().equals("price")) {
					double price = Double.parseDouble(file.getString());
					newBook.setPrice(price);
				} else if (file.getFieldName().equals("categoryId")) {
					int categoryId = Integer.parseInt(file.getString());
					CategoryService categoryService = CategoryServiceImpl.getInstance();
					Category category = categoryService.getById(categoryId);
					newBook.setCategory(category);
				} else if (file.getFieldName().equals("stock")) {
					int stock = Integer.parseInt(file.getString());
					newBook.setStock(stock);
				} else if (file.getFieldName().equals("status")) {
					String status = file.getString();
					newBook.setStatus(status);
				} else if (file.getFieldName().equals("picture")) {
					// if new picture uploaded
					if (file.getSize() > 0) {
						//get new picture name
						String originalName=file.getName();
						int index=originalName.lastIndexOf("\\");
						String pictureName=originalName.substring(index+1);
						newBook.setPicture_name(pictureName);
						
						//upload picture 
						String PICTURE_FOLDER="D:\\javaWorkspace\\GreatBookList\\WebContent\\view\\images\\book\\";
						File pictureFile=new File(PICTURE_FOLDER+pictureName);
						file.write(pictureFile);
						
						
					} else {
						int bookId=newBook.getId();
						BookService bookService=BookServiceImpl.getInstance();
						Book oldBook=bookService.getById(bookId);
						String oldPictureName=oldBook.getPicture_name();
						newBook.setPicture_name(oldPictureName);
					}
					BookService bookService = BookServiceImpl.getInstance();
					bookService.update(newBook);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// send redirect to search-all result
		resp.sendRedirect("search-result?categoryName=all&keyword=");
	}
}
