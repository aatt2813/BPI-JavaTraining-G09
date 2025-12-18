package group_9;

public class Library extends Book {
	   // can contain up to 5 books	
	
	public void displayAllBooks() {
		System.out.println("All Books");
		String message;
		for (int i = 0; i < 5 ; i++) {
			System.out.println("-------------------");
			System.out.println("Book ID: " + getBookID(i));
			System.out.println("Book Title: " + getBookTitle(i));
			System.out.println("Book Author: " + getBookAuthor(i));
			if (getBookLoanStatus(i)) {
				message = "No";
			} else {
				message = "Yes";
			}
			System.out.println("Available: " + message);
		}
		System.out.println("End of report for all books");
	}
	
	public void displayAllAvailableBooks() {
		System.out.println("All Available Books");
		for (int i = 0; i < 5; i++) {
			if (!getBookLoanStatus(i)) {
				System.out.println("-------------------");
				System.out.println("Book ID: " + getBookID(i));
				System.out.println("Book Title: " + getBookTitle(i));
				System.out.println("Book Author: " + getBookAuthor(i));
			}
		}
		System.out.println("End of report for all available books");
	}
	
	public void displayAllBorrowedBooks() {
		System.out.println("All Borrowed Books");
		for (int i = 0; i < 5; i++) {
			if (getBookLoanStatus(i)) {
				System.out.println("-------------------");
				System.out.println("Book ID: " + getBookID(i));
				System.out.println("Book Title: " + getBookTitle(i));
				System.out.println("Book Author: " + getBookAuthor(i));
			}
		}
		System.out.println("End of report for all borrowed books");
	}
	
}
