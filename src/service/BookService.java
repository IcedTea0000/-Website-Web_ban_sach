package service;

import java.util.List;

import model.Book;
import model.Category;

public interface BookService {
	public void add(Book newBook);

	public void update(Book newBook);

	public Book getById(int bookId);

	public void delete(int bookId);

	public List<Book> searchByName(String bookName);
	
	public List<Book> searchByNC(String bookName,Category category);
}
