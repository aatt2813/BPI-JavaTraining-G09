package group_9;

import java.util.Scanner;

public class Library implements DisplayController{

	// can contain up to 5 books		
	protected Book[] bookArray = new Book[5]; 
	protected Loan[] borrowedBookArray = new Loan [bookArray.length];
	private Scanner sc = new Scanner(System.in);
	private boolean validInput;
	void showBookList() {
		// show the array of book object
		displayString("+=================================================+\n"
		         +  "|          1.  ALL BOOKS IN LIBRARY DATABASE      |" 
		         +  "\n+=================================================+\n" 
				+ "Below are all the book in this library. "
				+ "\nBook ID | Title | Author");
        getBookDetails("All");
	}
	
	void showAvailableBooks() {
		// show the array of book object that has no corresponding Loan
		displayString("+=================================================+\n"
		         +  "|          2.  ALL AVAILABLE BOOKS                |" 
		         +  "\n+=================================================+\n" 
				+ "Below are the books still Available to borrow in this library:"
				+ "\nBook ID | Title | Author");
		getBookDetails("Available");
	}
	
	void showBorrowedBooks() {
		// show the array of (borrowed Books)Loan object
		displayString("+=================================================+\n"
		         +  "|          3.  ALL BORROWED BOOKS                |" 
		         +  "\n+=================================================+\n" 
				+ "Below are book that are currently borrowed: ");
		getBookDetails("Borrowed");
	}
	
	void returnBook() {
		displayString("Please enter the ID of the book you want to return: ");
		String input = sc.nextLine();
		
		//validate input and 
		int bookToReturn = validateOption(input)-1;
		if (validInput ) {
			if (borrowedBookArray[bookToReturn].getUser() != null) {
				borrowedBookArray[bookToReturn].setBook(null);
				borrowedBookArray[bookToReturn].setUser(null);
			}
		}
		else
			displayString("\nError: Please input the correct book id to return.\nReturning to Main Menu...");	
	}
	
	void borrowBook(User user) {
		//show all available book
		
		displayString("Please input Book ID you want to borrow: ");
		
		String input = sc.nextLine();
		
		//validate input and 
		int bookToBorrow = validateOption(input)-1;
		if (validInput ) {
			if (borrowedBookArray[bookToBorrow].getUser() == null) 
				borrowedBookArray[bookToBorrow] = new Loan(bookArray[bookToBorrow], user);
		}
		else
			displayString("\nError: Please choose a book thats available.\nReturning to Main Menu...");	
	}
	
	void getBookDetails(String choice) {
		//looping based on the array length
		for (int row = 0; row < bookArray.length; row++) {
			
			//based on the argument "choice" it will go to the printing and condition
			switch (choice) {
			case "All":
				displayString(bookArray[row].getId() + " | " + bookArray[row].getTitle() + " by " + bookArray[row].getAuthor());
				break;
			case "Available":
				if (borrowedBookArray[row].getUser() == null)
	        		displayString(bookArray[row].getId() + " | " + bookArray[row].getTitle() + " by " + bookArray[row].getAuthor());
				break;
			case "Borrowed":
	        	if(borrowedBookArray[row].getUser() != null) {
	        		displayString(borrowedBookArray[row].getBook().getId() +" | "+borrowedBookArray[row].getBook().getTitle()+" | " +
	        				  "Borrowed By " + borrowedBookArray[row].getUser().getName());
	        	}
				break;
			}
		}
	}
	
	public int validateOption(String input) {

		int option = 0;
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c < '0' || c > '9') {
				validInput=false;
			}
			else {
				option = Integer.parseInt(input);
				if (option >0 & option <=bookArray.length)
					validInput = true;
			}

		}
		return option;
	}
	
	
	public void initBooks() {
		//initialize library: Array of Books
        bookArray[0] = new Book(001,"Title1 ", "Author1 ");
        bookArray[1] = new Book(002,"Title2 ", "Author2 ");
        bookArray[2] = new Book(003,"Title3 ", "Author3 ");
        bookArray[3] = new Book(004,"Title4 ", "Author4 ");
        bookArray[4] = new Book(005,"Title5 ", "Author5 ");
	}
	void initLoans() {
	       //initialize library: Array of Loan Object /borrowed Books	
	       //set null as initial value
		    for (int i = 0; i< borrowedBookArray.length; i++) {
		    	borrowedBookArray[i] = new Loan ();
		    	borrowedBookArray[i].setBook(null);
		    	borrowedBookArray[i].setBook(null);
		    }
	}
	
	@Override
	public void displayString(String print) {
		System.out.print("\n"+print);
	}

}
