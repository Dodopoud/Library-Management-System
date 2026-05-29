import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryMenu {
	Scanner scanner = new Scanner(System.in);
	Library L = new Library();
	int choice = 0;
	
	public void run() {
		L.loadBooksFromFile();
		L.loadMembersFromFile();
		L.loadBorrowsFromFile();
		
		System.out.println("==== WELCOME TO THE LIBRARY ====");
		
		do {
		
		System.out.println("  ===  LIBRARY MENU   ===");
		System.out.println("1. Add Book");
		System.out.println("2. Add Member");
		System.out.println("3. Remove Book by Book ID");
		System.out.println("4. Remove Member by Member ID");
		System.out.println("5. Search Book by Book ID");
		System.out.println("6. Search Book by Title");
		System.out.println("7. Search Member by Member ID");
		System.out.println("8. Show all Books");
		System.out.println("9. Show all Members");
		System.out.println("10. Show all Borrows");
		System.out.println("11. Borrow a Book");
		System.out.println("12. Return a Book");
		System.out.println("13. Check Overdue Books");
		System.out.println("0. EXIT");
		System.out.println("Make your choice: ");
		
		try {
			choice = scanner.nextInt();
			scanner.nextLine();
		}catch (InputMismatchException e) {
			System.out.println("Please enter a number(1-13).");
			scanner.nextLine(); //buffer cleaning
			choice = -1;
		}
		
		
		switch(choice) {
			case 1: //Add a book 
				addBook();
				break;
				
			case 2: //Add a member
				addMember();
				break;
				
			case 3://Remove a book
				removeBook();
				break;	
				
			case 4: //Remove a member
				removeMember();
				break;
			
			case 5: //Search book by ID
				searchBookByID();
				break;
				
			case 6: //Search book by Title
				searchBookByTitle();
				break;
				
			case 7: //Search member by ID
				searchMemberByID();
				break;
			case 8: //Borrow a book
				borrowBook();
				break;
			
			case 9: //Return a book
				returnBook();
				break;
				
			case 10: //print all books
				L.printAllBooks();
				break;
				
			case 11: //print all members
				L.printAllMembers();
				break;
				
			case 12: //print all borrows
				L.printAllBorrows();
				break;
				
			case 13: //check overdue books
				L.checkOverDue();
				break;
				
			case 0 :
				L.saveBooksToFile();
				L.saveMembersToFile();
				L.saveBorrowsToFile();
				System.out.println("Data saved! Goodbye.");
				break;
			default:
				System.out.println("Invalid Option. Choose again.");
				
	}
	
	}	while(choice != 0);
	
		scanner.close();
} 
	private void addBook() {
		System.out.println("Enter book name: ");
		String bookName = scanner.nextLine();
		if (!isValidInput(bookName)) {
			System.out.println("Name cannot be empty!");
			return;
		}
		System.out.println("Enter author name: ");
		String authorName = scanner.nextLine();
		if (!isValidInput(authorName)) {
			System.out.println("Author name cannot be empty!");
			return;
		}
		System.out.println("Enter category name: ");
		String category = scanner.nextLine();
		if (!isValidInput(category)) {
			System.out.println("Category name cannot be empty!");
			return;
		}
		System.out.println("Enter number of copies: ");
		int copies = scanner.nextInt();
		L.addBook(bookName, authorName, category, copies);
	}
	
	private void addMember() {
		System.out.println("Enter member name: ");
	
		String name = scanner.nextLine();
		if (!isValidInput(name)) {
			System.out.println("Name cannot be empty!");
			return;
		}
		System.out.println("Enter surname: ");
		String surname = scanner.nextLine();
		if (!isValidInput(surname)) {
			System.out.println("Surname cannot be empty!");
			return;
		}
		L.addMember(name, surname);
	}
	
	private void removeBook() {
		System.out.println("Enter Book ID to be removed: ");
		String bookID = scanner.nextLine();
		System.out.println("Are you sure? Y/N");
		String bookSure = scanner.nextLine();
		if(bookSure.equals("Y")) {
				L.removeBook(bookID);
		}
		else if (bookSure.equals("N")){
			return;
		}
		else {
			System.out.println("Not valid character");
			return;
		}
	}
	
	private void removeMember() {
		System.out.println("Enter Member ID to be removed: ");
		String memberID = scanner.nextLine();
		System.out.println("Are you sure? Y/N");
		String memberSure = scanner.nextLine();
		if(memberSure.equals("Y")) {
				L.removeMember(memberID);
		}
		else if (memberSure.equals("N")){
			return;
		}
		else {
			System.out.println("Not valid character");
			return;
		}
	}
	
	private void searchBookByID() {
		System.out.println("Enter Book ID: ");
		String bookIDsearch = scanner.nextLine();
		Book b = L.searchBookByID(bookIDsearch);
		if ( b != null) {
			b.printData();
		}
		else {
			System.out.println("Book not found!");
		}
	
	}
	
	private void searchBookByTitle() {
		System.out.println("Enter Book Title: ");
		String bookTitle = scanner.nextLine();
		Book b1 = L.searchBookByTitle(bookTitle);
		if (b1 != null) {
			b1.printData();
		}
		else {
			System.out.println("Book not found!");
		}
	
	}
	
	private void searchMemberByID() {
		System.out.println("Enter Member ID: ");
		String memberIDsearch = scanner.nextLine();
		Member m = L.searchMemberByID(memberIDsearch);
		if ( m != null) {
			m.printData();
		}
		else {
			System.out.println("Member not found!");
		}
	
	}
	private void borrowBook() {
		System.out.println("Enter Member ID: ");
		String memberIDBorrow = scanner.nextLine();
		System.out.println("Enter Book ID: ");
		String bookIDBorrow = scanner.nextLine();
		L.borrowBook(memberIDBorrow, bookIDBorrow);
	}
	
	private void returnBook() {
		System.out.println("Enter Member ID: ");
		String memberIDReturn = scanner.nextLine();
		System.out.println("Enter Book ID: ");
		String bookIDReturn = scanner.nextLine();
		L.returnBook(memberIDReturn, bookIDReturn);
	}
	private static boolean isValidInput(String input) {
		return !input.trim().isEmpty();
	}
	}
