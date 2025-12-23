package m3_group9_project;

import java.util.Objects;

public class Book {

	// adding this "id" to give you an idea on what options you can do
	private Integer id;
	private String title;
	private String author;
	private boolean loanTagger;
	
	// feel free to add fields that may help
	
	public Book(Integer id, String title, String author, boolean loanTagger) {
		this.id=id;
		this.title=title;
		this.author=author;
		this.loanTagger=loanTagger;
	}
	
	public Book() {
		
	}

    public void reset() {
    	/*
    	 * Resetting values in case needed for bookContainer(temporary Book)
    	 * Used to empty the values to avoid Null errors
    	 */
        this.id = Integer.MIN_VALUE;
        this.loanTagger = false;
        this.title = "";
        this.author = "";
    }
    
	public Integer getId() {
		return id;
		}
	public void setId(Integer id) {
		this.id = id;
		}
	
	public String getTitle() {
		return title;
		}
	public void setTitle(String title) {
		this.title = title;
		}
	public String getAuthor() {
		return author;
		}
	public void setAuthor(String author) {
		this.author = author;
		}
	public boolean getLoanTagger() {
		return loanTagger;}
	
	public void setLoanTagger(boolean loanTagger) {
		this.loanTagger = loanTagger;
		}
	
	/*
	 * Override equals() and hasCode()
	 * Per google this override is required to Use .contains() with custom element/objects
	 * Objects.equals(id, books.id) means it will only check the id element and ignore the other book elements (title,author)
	 * can be overridden depending on the use case
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book books = (Book) o;
        return Objects.equals(id, books.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
