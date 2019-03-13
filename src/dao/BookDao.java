package dao;

import java.util.List;

import model.Book;
import model.Category;

public interface BookDao {
	public void add(Book newBook);

	public void update(Book newBook);

	public void get(int bookId);

	public void delete(int bookId);

	public List<Book> searchByName(String bookName);
	
	public List<Book> searchByNC(String bookName,Category category);
}
