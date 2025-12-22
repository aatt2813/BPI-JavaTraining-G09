package group_9;


public class Loan {

	private User user;
	private Book book;
	
	public Loan(Book book, User user) {
		this.book = book;
		this.user = user;
	}
	public Loan() {
		
	}
	
	
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return this.book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	

	
}
