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

public class LibraryApplication {
	
	private User user;
	private Library library;
	private Loan loan;	
	
    // Use one Scanner shared across the program
    private static final Scanner SCANNER = new Scanner(System.in);  
	
	// Main Application Logic, call this in your Main.java
	public void start() {
		// initial user creation
		this.user = new User();
		
		System.out.println("Please enter your library ID #");
        String input1 = SCANNER.nextLine();
        
        int userInput1 = Integer.parseInt(input1);	// read input and convert to integer
		// validate the library ID
        if (user.checkUserID(userInput1)) {
        	System.out.println("User ID found in User Database");
        }
        	else {
        	System.out.println("User ID not found in User Database");        	
        	System.out.println("Exiting the program");
        	System.exit(0);
        }
		
        // validate if the user name matches the library ID
        System.out.println("Please enter your user name #");
        String input2 = SCANNER.nextLine();
        
        if(user.checkUserName(input2)) {
        	System.out.println("User ID match the provided user name. OK to proceed in main menu."); 
        } else {
        	System.out.println("Probable breach.");
        	System.out.println("Exiting...");
        	System.exit(0);
        }

		// initial library creation
		this.library = new Library();	
		this.loan = new Loan(this.user, this.library);
		
		// add code here
		MenuChoice userChoice;
		do {
        	userChoice = mainMenu();
        	
        	switch (userChoice.getMenuChoice()) {
            	case "1": 
            	library.displayAllBooks();
            	break;
            	case "2": 
            	library.displayAllAvailableBooks();
            	break;
            	case "3": System.out.println("[3] Display All Borrowed Books  ");
            	library.displayAllBorrowedBooks();
            	break;
            	case "4":
            	System.out.println("Borrowing book");
           		System.out.println("Please enter book ID");
                String input3 = SCANNER.nextLine();
                    
                int userInput3 = Integer.parseInt(input3);	// read input and convert to integer
                //System.out.println("**Investigation");
                //System.out.println("userInput1: " + userInput1);
                //System.out.println("userInput3: " + userInput3);
            	loan.borrowBook(userInput1, userInput3);	
            	break;
            	case "5": 
            	
            	System.out.println("Returning book");
           		System.out.println("Please enter book ID");
                String input4 = SCANNER.nextLine();
                    
                int userInput4 = Integer.parseInt(input4);	// read input and convert to integer

            	loan.setReturn(userInput1, userInput4);
            	
            	break;
            	case "6": System.out.println("[6] Exit                        ");
            	break;
            	default:  System.out.println("Invalid Choice. Please choose from 1, 2, 3, 4, 5, 6. Thank you");
        	}        	
		} while (!"6".equals(userChoice.getMenuChoice()));	
		
	}
	
	// add code here
	
    private static class MenuChoice {
        final String mChoice;

        // Constructor name must match the class name
        MenuChoice(String mChoice) {
            this.mChoice = mChoice;
        }

        private String getMenuChoice() { return mChoice; }
    }
    
	private static MenuChoice mainMenu() {
		System.out.println("===== GROUP 9 LIBRARY SYSTEM =====");
		System.out.println("[1] Display All Books             ");
		System.out.println("[2] Display Available Books       ");
		System.out.println("[3] Display All Borrowed Books    ");
		System.out.println("[4] Borrow Book                   ");
		System.out.println("[5] Return Book                   ");
		System.out.println("[6] Exit                          ");
		System.out.println("==================================");
		System.out.print("Enter Choice:                     ");
		
        String userChoice = SCANNER.nextLine();
        // Normalize input here (optional, can also do it in main)
        userChoice = userChoice.trim().toUpperCase();
        
        return new MenuChoice(userChoice);
	}
	
	
	
}
