package m3_group9_project;

import java.util.ArrayList;
import java.util.List;

public class Library extends DisplayController{
	
	protected static List<Book> books = new ArrayList<>(); 
	protected static List<Loan> loans = new ArrayList<>();
	
	public void initBooks() {
		//initialize library: Array of Books
		books.add(new Book(001,"To Kill a Mockingbird", "Harper Lee",false));
		books.add(new Book(002,"1984", "George Orwell",false));
		books.add(new Book(003,"The Great Gatsby", "F. Scott Fitzgerald",false));
		books.add(new Book(004,"Pride and Prejudice", "Jane Austen",false));
		books.add(new Book(005,"Moby-Dick", "Herman Melville",false));
	}

	public List<Book> getBooks() {
		return books;
	}
	

	public void setBooks(List<Book> books) {
		Library.books = books;
	}


	public List<Loan> getLoans() {
		return loans;
	}


	public static void setLoans(List<Loan> loans) {
		Library.loans = loans;
	}


	@Override
	public void printUser(String print, String username) {
		System.out.println("Library Options\t\t\t\tUser: " + username + "\n");
	}




}
