import java.time.LocalDate;

public class Borrow {
	private final String memberID;
	private final String bookID;
	private final LocalDate borrowDate;
	private final LocalDate dueDate;
	
	public Borrow(String memberID, String bookID, LocalDate borrowDate){
		this.memberID = memberID;
		this.bookID = bookID;
		this.borrowDate = borrowDate;
		this.dueDate = borrowDate.plusDays(14);
	}
	
	public String getMemberID() {
		return memberID;
	}
	
	public String getBookID() {
		return bookID;
	}
	
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public void printData() {
		System.out.println("Member ID: " + memberID + ", BookID: " + bookID + ", Borrow Date: " + borrowDate + ", Due Date: "  + dueDate);
	}
}
