package javaeetutorial.bookstore.web.managedbeans;

import java.util.List;

import javaeetutorial.bookstore.ejb.BookRequestBean;
import javaeetutorial.bookstore.entity.Book;
import javaeetutorial.bookstore.exception.BooksNotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class IndexBean extends AbstractBean {
	
	@Inject
	private BookRequestBean bookRequestBean;
	
	public List<Book> getBooks() {
		try {
			return bookRequestBean.getBooks();
		} catch (BooksNotFoundException e) {
			message(null, "error.getBooks");
			return null;
		}
	}
	
	public String showBookInBookStore(String bookId) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("bookId", bookId);
		return "bookstore";
	}
}
