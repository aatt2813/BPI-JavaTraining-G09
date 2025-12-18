/*
 * 1. Upon application start, ask user to create one User
 * 2. Create one Library object
 * 3. Initialize 5 Book objects and add it to all Library slots
 * 4. Display options:
 * 
 * - [1] Display All Books
 * - [2] Display Available Books
 * - [3] Display All Borrowed Books
 * - [4] Borrow Book
 * - [5] Return Book
 * - [6] Exit
 * 
 * - user selects the number of the option
 * ===============================================
 * 
 *	 [1] Display All Books
 * - Display all Books (ID, Title and Author) regardless if there is a Loan existing for that Book.
 *   
 *   [2] Display Available Books
 * - Display Books that do not have a Loan slot
 * 
 *   [3] Display All Borrowed Books 
 * - Display Books that have a Loan equivalent.
 * - Display the Book title and the User name of borrower
 *   
 *	 [4] Borrow Book
 * - Displays all available books and User selects what book to borrow
 * - Create a Loan object, set Loan id set Book and set User to current user
 * 
 * 	 [5] Return Book
 * - Display all Loans, user selects the Loan and removes that from the slot
 * 
 *   [6] Exit
 * - Stops the program  
 * */
package group_9;

import java.util.Scanner;

public class LibraryApplication extends Library{
	
	private User user1;
	private Library library;
	boolean exit;
	private Scanner sc = new Scanner(System.in);


	
	// Main Application Logic, call this in your Main.java
	public void start() {
		
		// initial user creation
		this.user1 = new User();
		createUser();
		
		// initial library creation
		this.library = new Library();
		this.library.initBooks();
		this.library.initLoans();
		
		
		// add code here
		do {
			showOptions();
			getOption();
			}
		while(!getExit());
		
		
	}
	void getOption() {
		
		String initialOption=sc.nextLine();
		int validOption = validateOption(initialOption);
		
		switch(validOption) {
			case 1:
				library.showBookList();
				break;
			case 2:
				library.showAvailableBooks();
				break;
			case 3:
				library.showBorrowedBooks();
				break;
			case 4:
				library.showAvailableBooks();
				library.borrowBook(user1);
				break;
			case 5:
				library.returnBook();
				break;
			case 6:
				setExit(true);
				break;
			default:
				displayString("\nError: Please input correct option.");
		}
		
	}

	void showOptions() {
		 String dispUser = "\n+=================================================+\n" +
				           "|               LIBRARY MAIN MENU                 |" +
				           "\n+=================================================+\n" +
	                       "Library Options\t\t\tUser: " + user1.getName() + "\n" +
	                      "[1] Display All Books\n" + 
				 		  "[2] Display Available Books\n" +
				 		  "[3] Display All Borrowed Books\n" +
				 		  "[4] Borrow Book\n" +
				 		  "[5] Return Book\n" +
				 		  "[6] Exit\nPlease Input an option: ";
		 displayString(dispUser);
	}
	
	void createUser() {
		
		String display = "~~~~~~~~~~~~~"+
				"|       GROUP 9 LIBRARY      |" +
				"~~~~~~~~~~~~~"+
				"\nHi! Before we start, lets create your account first!"+
				"\nPlease create your Account by inputting username or ID.\n" +
				"\nInput username or ID: ";
		
		displayString(display);
		user1.setName(sc.nextLine());

	}
	public int validateOption(String input) {

		int option = 0;
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c < '0' || c > '9')
				option = 999;
			else
				option = Integer.parseInt(input);
		}
		return option;
	}
	
	public boolean getExit() {
		return exit;
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}
}
