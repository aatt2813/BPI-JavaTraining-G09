package m3_group9_project;

public abstract class DisplayController {
	
	/*
	 * Used only for printing of formats in console
	 * abstact method will be overridden by Library Application to show UserName
	 * 
	 * concrete method - can be called directly
	 */
	
	// Abstract method
	protected abstract void printUser(String print, String username);

	// Concrete methods
    // Shared display behavior
	public void welcomeHeader() {
		String print = "~~~~~~~~~~~~~|       GROUP 9 LIBRARY      |~~~~~~~~~~~~~"+
				"\nHi! Before we start, lets create your account first!"+
				"\nPlease create your Account by inputting username or ID.\n" +
				"\nInput username: ";
        System.out.print(print);
    }
	
    public void menuOptions() {
    	String print = "[1] Display All Books\n" + 
 		  "[2] Display Available Books\n" +
 		  "[3] Display All Borrowed Books\n" +
 		  "[4] Borrow a Book\n" +
 		  "[5] Return a Book\n" +
 		  "[6] Add a Book\n" +
 		  "[7] Remove a Book\n" +
 		  "[8] Update a Book\n" +
 		  "[0] Exit\n\nPlease Input an option: ";
        System.out.print(print);
    }
	
	public void mainMenuHeader() {
		 String print = "\n+=================================================+\n" +
		                  "|               LIBRARY MAIN MENU                 |" +
		                "\n+=================================================+\n";
        System.out.println(print);
    }
	public void allBookHeader() {
		String print = "+=================================================+\n"
		            +  "|              ALL BOOKS IN LIBRARY DATABASE      |" 
		          +  "\n+=================================================+\n" 
				+ "\nBelow are all the book in this library. "
				+ "\n\nBook ID | \tTitle \t\t| Author";
        System.out.println(print);
    }
	public void availableBookHeader() {
		String print = "+=================================================+\n"
		            +  "|              ALL AVAILABLE BOOKS                |" 
		          +  "\n+=================================================+\n" 
				+ "\nBelow are the books still Available to borrow in this library:"
				+ "\n\nBook ID | \tTitle \t\t| Author";
        System.out.println(print);
    }
	
	public void borrowedBookHeader() {
		String print = "+=================================================+\n"
		            +  "|              BORROWED BOOKS                     |" 
		          +  "\n+=================================================+\n" 
				  + "\nBelow are book that are currently borrowed: "
		          + "\n\nBook ID | \tTitle \t\t| Author \t| \tBorrower";
        System.out.println(print);
    }
	
	public void addBookHeader() {
		String print = "+=================================================+\n"
	                +  "|              ADD A NEW BOOK                     |" 
	              +  "\n+=================================================+\n" 
	                +"\n\nTo add a new book, please input Book ID, Name of book and the Author.";
        System.out.println(print);
    }
	
	public void removeBookHeader() {
		String print = "+=================================================+\n"
	                +  "|              REMOVE A BOOK                      |" 
	              +  "\n+=================================================+\n" 
			  + "\nTo remove a book, please input the Book ID";
        System.out.println(print);
    }
	
	public void updateBookHeader() {
		String print = "+=================================================+\n"
	                +  "|          8.  UPDATE A BOOK                      |" 
	              +  "\n+=================================================+\n" 
			  + "\nTo update a book, please input the Book ID. You can only update the Name and Author"
	          + "\nPress 'ENTER' if you want to skip the Name or Author";
        System.out.println(print);
    }
    

}
