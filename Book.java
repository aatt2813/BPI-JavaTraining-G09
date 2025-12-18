/**
 *  Declare as abstract or inheritance to be inherited by Loan
 */
package group_9;


public abstract class Book {
	
	// adding this "id" to give you an idea on what options you can do
	private Integer id;
	private String title;
	private String author;
	private Boolean isLoaned;
	
	
	private int[] bookID = {0,1,2,3,4};
	
	private String[] bookTitle = {"The 7 Habits of Highly Effective People",
			"The Richest Man in Babylon",
			"Start With Why",
			"The Laws of Human Nature",
			"Unreasonable Hospitality"
	};
	
	private String[] bookAuthor = {"Stephen Covey",
			"George S. Clason",
			"Simon Sinek",
			"Robert Greene",
			"Will Guidara"			
	};
	
	private Boolean[] bookIsLoaned = {false,
			false,
			false,
			false,
			false
	};
	
	private int[] borrowerID = {0,0,0,0,0};
	
	public int getBookID(int ID) {
		return bookID[ID];		
	}
	
	public String getBookTitle(int ID) {
		return bookTitle[ID];		
	}
	
	public String getBookAuthor(int ID) {
		return bookAuthor[ID];		
	}
	
	public boolean getBookLoanStatus(int ID) {
		return bookIsLoaned[ID];
	}
	
	private void setBorrow(int setterVar, int userBorrowerID) {
		borrowerID[setterVar] = userBorrowerID;
		bookIsLoaned[setterVar] = true;
	}
	

    public int getBorrowerID(int ID) {
        return borrowerID[ID];
    }

    public void setBorrower(int ID, int userBorrowerID) {
        borrowerID[ID] = userBorrowerID;
    }

    public void setBookLoanStatus(int ID, boolean status) {
        bookIsLoaned[ID] = status;
    }
	
}
