package javaeetutorial.bookstore.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javaeetutorial.bookstore.entity.Book;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookDAO {

	private Set<Book> persistedBooks = new HashSet<>();
	
	public void persist(Book book) {
		persistedBooks.add(book);
	}

	public List<Book> findAllBooks() {
		return new ArrayList<Book>(persistedBooks);
	}

	public Book find(String bookId) {
		if (bookId != null) {
			for (Book persistedBook : persistedBooks) {
				if (bookId.equals(persistedBook.getBookId()) ) {
					return persistedBook;
				}
			}
		}
		return null;
	}

}
