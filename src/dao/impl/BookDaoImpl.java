package dao.impl;

import java.util.List;

import dao.BookDao;
import model.Book;
import model.Category;

public class BookDaoImpl implements BookDao {

	@Override
	public void add(Book newBook) {
		// add object newBook to SQL db
		
	}

	@Override
	public void update(Book newBook) {
		// update book's information on SQL db where id=newBook.id
		
	}

	@Override
	public void get(int bookId) {
		// get object book with id matches bookId on SQL db
		
	}

	@Override
	public void delete(int bookId) {
		// delete book with id matches bookId on SQL db
		
	}

	@Override
	public List<Book> searchByName(String bookName) {
		// search SQL db and return a list of books with names containing bookName
		return null;
	}

	@Override
	public List<Book> searchByNC(String bookName, Category category) {
		// search SQL db and return a list of books with names containing bookName and category matches category
		return null;
	}

}
