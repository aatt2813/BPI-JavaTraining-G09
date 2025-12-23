package m3_group9_project;

import java.util.Objects;

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
	/*
	 * Override equals() and hasCode()
	 * Per google this override is required to Use .contains() with custom element/objects
	 * can be overridden depending on the use case
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true; // same reference
        if (!(o instanceof Loan)) return false; // type check
        Loan loans = (Loan) o;
        // Compare relevant fields for equality
        return Objects.equals(book, loans.book) &&
               Objects.equals(user, loans.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book,user); // consistent with equals
    }
}
