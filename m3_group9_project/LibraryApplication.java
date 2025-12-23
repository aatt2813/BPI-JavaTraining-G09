package m3_group9_project;

import java.util.Scanner;


public class LibraryApplication extends Library {
	private User user1;
	private Library library;
	private Book bookContainer;
	private Scanner sc = new Scanner(System.in);
    boolean validBookID;
	boolean exit = false;
	
	// Main Application Logic, call this in your Main.java
	public void start() {
		
		// initial user creation
		this.user1 = new User();
		
		// initial library creation
		this.library = new Library();
		
		/* Initial book container creation
		 * A temporary Book Object for storing a Book Details
		 * - able to use the temporary variable for .contains()
		 * - can use getter methods to get specific book details
		 */
		this.bookContainer = new Book();
		
		createUser();
		library.initBooks();
		
		// add code here
		do {
			showOptions();
			getOption();
			}
		while(!exit);
		
		
	}
	void createUser() {
		welcomeHeader();
		user1.setName(sc.nextLine());
		
		System.out.print("Input ID: ");
		user1.setId(sc.nextLine());

	}
	
	void showOptions() {
		mainMenuHeader();
		printUser("Library Options\t\t\tUser: ",user1.getName());
		menuOptions();
	}
	
	void getOption() {
		
		String initialOption=sc.nextLine();
		int validOption = validateMainOption(initialOption);
		
		switch(validOption) {
			case 1:
				allBookHeader();
				printBookDetails("All");
				break;
			case 2:
				availableBookHeader();
				printBookDetails("Available");
				break;
			case 3:
				if(checkLoanSize())
					break;
				borrowedBookHeader();
				printBookDetails("Borrowed");
				break;
			case 4:
				availableBookHeader();
				printBookDetails("Available");
				borrowBook(user1);
				break;
			case 5:
				if(checkLoanSize())
					break;
				borrowedBookHeader();
				printBookDetails("Borrowed");
				returnBook();
				break;
			case 6:
				addBookHeader();
				addBook();
				break;
			case 7:
				removeBookHeader();
				removeBook();
				break;
			case 8:
				updateBookHeader();
				updateBook();
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("\nError: Please input correct option.");
		}
		
	}
	
	void printBookDetails(String choice) {	
		
		/*
		 * Iterate the books.list and loans.list depending on the Parameter String choice
		 */

		switch(choice){
			case "All":
				for(Book book : books)
					System.out.println(book.getId() + " \t|" + book.getTitle() +" -- "+book.getAuthor());
				break;
				
			case "Available":
				for(Book book : books) 
					if (!book.getLoanTagger())
						System.out.println(book.getId() + " \t|" + book.getTitle() +" -- "+book.getAuthor());		
				break;
				
			case "Borrowed":					
				for(Loan loan : loans)
					System.out.println(loan.getBook().getId() +" \t|" + loan.getBook().getTitle() +
							" -- "+loan.getBook().getAuthor() + " borrowed by "+ loan.getUser().getName());
				break;
		}

	}


	void returnBook() {
		System.out.print("\nPlease enter the ID of the book you want to return: ");
		String input = sc.nextLine();
		
		//validate input
		int bookIDToReturn = validateBookID(input);

		if (bookIDToReturn >= 0) {
			
			passBookDetails(bookIDToReturn);
			
			/*  if : check the books ArrayList if the ID entered by user is existing and the loan tagger is TRUE = not yet loaned and available
			 *         if yes then remove that Book and User object using updateLoanList method with "REMOVE" parameters
			 *  else: either that book is not existing in library or not loaned.
			 */
			if(books.contains(bookContainer)) 
		
				updateLoanList("REMOVE");
			else
				System.out.println("\nBook already returned or not existing in library, please choose a loaned book.\nReturning to Main Menu...");	
		}
		else
			System.out.print("\nERROR: Please input the correct book id to return.\nReturning to Main Menu...");	
	}
	
	void borrowBook(User user) {
		System.out.print("\nPlease input Book ID you want to borrow: ");
		String input = sc.nextLine();
		

		int bookToBorrowID = validateBookID(input);
		/* Checking if the input book ID is digits and if the book ID is existing on the books.ArrayList 
		 * and not tagged as loaned (the false value in books.contains below)
		 */
		if (bookToBorrowID >= 0) {
			/* 
			 * Checking of inputed ID if existing in books list and if the book loan tagger is False (False=not yet loaned, True = already Loaned)
			 *          add the Book and User to the loans list using the updateLoanList method with "ADD" parameters
		     * Else book already tagged as borrowed
			 */
			passBookDetails(bookToBorrowID);
			if(books.contains(bookContainer) & bookContainer.getLoanTagger()==false)
				updateLoanList("ADD");	
			else
				System.out.println("\nBook already loaned or not existing in the library, please choose an available book.\nReturning to Main Menu...");	
		}
		else 
			System.out.println("\nError: Please please input correct option.\nReturning to Main Menu...");	
			
	}
	
	
	public void addBook() {
		
		System.out.print("\nPlease Input Book ID:");
		int bookID = validateBookID(sc.nextLine());
		
		System.out.print("Please Input Book Name:");
		String bookName = sc.nextLine();
		
		System.out.print("Please Input Book Author:");
		String bookAuthor = sc.nextLine();
		
		if(bookID > Integer.MIN_VALUE ) {
			
			if(!books.contains(new Book(bookID,"","",false))) {
				modifyBookList("ADD",bookID,bookName,bookAuthor);
			}
			else
				System.out.println("\nInvalid Book ID. Already existing in Library Database");
		}	
		else
			System.out.println("\nERROR: Invalid Input, please input a correct book ID. Returning to Main Menu...");
		
	}
	public void removeBook() {
		
		System.out.print("\nPlease Input Book ID:");
		int bookID = validateBookID(sc.nextLine());
		
		if(bookID >= 0) {
			
			passBookDetails(bookID);
			
			if (books.contains(bookContainer))
				modifyBookList(bookID);
			
		}
		else
			System.out.println("\nInvalid Book ID, please input correct Book ID");
		
	}
	
	public void updateBook() {
		
		System.out.print("\nPlease Input Book ID:");
		int bookID = validateBookID(sc.nextLine());

		System.out.print("Please Updated Book Name:");
		String bookName = sc.nextLine();
		
		System.out.print("Please Updated Book Author:");
		String bookAuthor = sc.nextLine();
		
		if(bookID >= 0) {
			
			passBookDetails(bookID);
			
			if(books.contains(bookContainer) & bookContainer.getLoanTagger()==false)
				modifyBookList("UPDATE",bookID,bookName,bookAuthor);
			else
				System.out.println("\nCannot update book. Book ID not existing or currently borrowed by a user.");
		}else
			System.out.println("\nERROR: Invalid Book ID");

	}
	
	public void modifyBookList(String choice, int targetID, String bookName, String bookAuthor){
		
		/*
		 * Based on the parameter String choice (ADD/UPDATE) 
		 * 
		 * - ADD - create a new instance of book and set the values
		 * 
		 * - UPDATE - check if Author and Name is not empty 
		 *  		- if not empty set the new values from the user input
		 *  		- else do nothing, the values remain the same.
		 */
		
		
		if(choice == "ADD") {
			Book newbook = new Book();
			newbook.setAuthor(bookAuthor);
			newbook.setId(targetID);
			newbook.setLoanTagger(false);
			newbook.setTitle(bookName);
			
			books.add(newbook);
			
			System.out.println("\n\n"+user1.getName()+ " have successfully added the book with ID: "+ newbook.getTitle());
		}
			
		if(choice == "UPDATE") {
			if(bookAuthor!="")
				bookContainer.setAuthor(bookAuthor);
			if(bookName!="")
				bookContainer.setTitle(bookName);
			System.out.println("\n\n"+user1.getName()+ " have successfully updated the book with ID: "+ targetID);
		}
		
	}
	
	public void modifyBookList(int targetID) {
        /*
         * modifyBookList separate method using different parameters
         * used only for removing book in books.list
         * can directly user BookContainer as we need to also remove it from books.list
         * 
         */
		books.remove(bookContainer);
		loans.remove(new Loan (bookContainer,user1));
		System.out.println("\n\n"+user1.getName()+ " have successfully removed the book with ID: "+ bookContainer.getId());
	}

	
	public void updateLoanList(String choice) {
		

		 /* Based on the parameter String choice: "ADD" else "REMOVE" the Book and User objects in loan list
		 *        and set the loan tagger if TRUE=loaned or FALSE=available
		 *        
		 *  ADD - automatically add the BookContainer as it already contains the book the user want to loan
		 *      - BookContainer received the specific book from list from the passBookDetails()      
		 *        
		 *  REMOVE - create a new instance of book which contains empty values
		 *  	   - then pass the values from BookContainer to new Book to get the values and use it for .remove() in loans list
		 *         - cannot use the BookContainer in .remove() as it will remove the book in books.list as well.     
		 *        
		 */

		if(choice == "ADD") {
			loans.add(new Loan(bookContainer,user1));
			bookContainer.setLoanTagger(true);
			System.out.println(user1.getName()+ " have successfully borrowed this book: "+ bookContainer.getTitle());
		}
		if(choice == "REMOVE") { 
			Book book = new Book();			
			book = bookContainer;
			
			loans.remove(new Loan(book,user1));
			bookContainer.setLoanTagger(false);
			System.out.println(user1.getName()+ " have successfully returned this book: "+ bookContainer.getTitle());
		}
		
		
	}
	
	public int validateMainOption(String input) {
		
		/* Validation for Main options input
		 * check if input is empty
		 * check if input is more than 1 character, if yes then invalid already for Main Options (0-8)
		 * if the input contains a non digit return MIN_VALUE 
		 * else convert the String Input to Integer
		 * 
		 */
		
		if(input=="" | input.isEmpty())
			return 999;
		
		if(input.length() > 1)
			return 999;
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c < '0' || c > '8')
				return 999;
		}
		return Integer.parseInt(input);
	}
	
	public int validateBookID(String input) {
		
		/*
		 * Validation of user Input for Book ID
		 * get the input string and validate if all digits
		 * if the input contains a non digit return MIN_VALUE 
		 * else convert the String Input to Integer
		 * 
		 */
		
		if(input=="" | input.isEmpty())
			return Integer.MIN_VALUE;
		

		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c < '0' || c > '9') 
				return Integer.MIN_VALUE;
		}
		return Integer.parseInt(input);
	}
	public void passBookDetails(int targetId) {
		
		/* Checking if targetID/or input from user is existing in books.list
		 * If not exiting then reset the values = set empty values then exit from method
		 * Else iterate the books.list and pass the values of that book to BookContainer then stop loop and exit
		 * 
		 * 
		 */
		if(!books.contains(new Book(targetId,"","",false))) {
			bookContainer.reset();
			return;
		}

		//* Iteration is required if adding/removing /updating element in list is not index-based but with the Book ID element
		for (Book book : books) {
			if (book.getId().equals(targetId)) {
				bookContainer = book;
				break;
			}
		}
		
	}
	
	public boolean checkLoanSize() {
		/*
		 * Checker method
		 * If currently no loans, then return true: no loans at the moment
		 */
		
		if(loans.size()==0) {
			System.out.println("\nNo books are currently loaned...");
			return true;
		}
		else
			return false;
	}
}
	


