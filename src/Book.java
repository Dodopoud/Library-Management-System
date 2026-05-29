//Book Class

public class Book {
	private String title;
	private String author;
	private String bookID;
	private String category;
	private int copies;
	
	public Book(String title, String author, String bookID, String category, int copies){
		this.title = title;
		this.author = author;
		this.bookID = bookID;
		this.category = category;
		this.copies = copies;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
		
	}
	
	public String getBookID() {
		return bookID;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getCopies() {
		return copies;
	}
	
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public void printData() {
		System.out.println("BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Category: " + category + ", Number of copies: " + copies);
		}
}
