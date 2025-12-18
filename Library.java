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
		int ctr = 0;
		for (int i = 0; i < 5; i++) {
			if (!getBookLoanStatus(i)) {
				ctr++;
				System.out.println("-------------------");
				System.out.println("Book ID: " + getBookID(i));
				System.out.println("Book Title: " + getBookTitle(i));
				System.out.println("Book Author: " + getBookAuthor(i));
			}
			
		}
		System.out.println("Total available book(s) : " + ctr);
		System.out.println("End of report for all available books");
	}
	
	public void displayAllBorrowedBooks() {
		System.out.println("All Borrowed Books");
		int ctr = 0;
		for (int i = 0; i < 5; i++) {
			if (getBookLoanStatus(i)) {
				ctr++;
				System.out.println("-------------------");
				System.out.println("Book ID: " + getBookID(i));
				System.out.println("Book Title: " + getBookTitle(i));
				System.out.println("Book Author: " + getBookAuthor(i));
				System.out.println("Borrowed by : " + getBorrowerID(i));
				
			}
		}
		System.out.println("Total borrowed book(s) : " + ctr);
		System.out.println("End of report for all borrowed books");
	}
	
}
