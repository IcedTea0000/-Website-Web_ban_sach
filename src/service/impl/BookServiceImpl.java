package service.impl;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Book;
import model.Category;

//call BookDaoImpl matching methods
public class BookServiceImpl implements BookDao {
	private BookDao bookDaoImpl=new BookDaoImpl();
	
	@Override
	public void add(Book newBook) {
		bookDaoImpl.add(newBook);
	}

	@Override
	public void update(Book newBook) {
		bookDaoImpl.update(newBook);		
	}

	@Override
	public void get(int bookId) {
		bookDaoImpl.get(bookId);
	}

	@Override
	public void delete(int bookId) {
		bookDaoImpl.delete(bookId);		
	}

	@Override
	public List<Book> searchByName(String bookName) {
		return bookDaoImpl.searchByName(bookName);
	}

	@Override
	public List<Book> searchByNC(String bookName, Category category) {
		return bookDaoImpl.searchByNC(bookName, category);
	}

}
