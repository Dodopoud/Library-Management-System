import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

//SOS:Library Class is the brain of the system. All logic lives here. Book and Member just hold data.
//Here Members and Books are created and added to the ArrayLists.

public class Library {
	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Borrow> borrows = new ArrayList<Borrow>();
	private int bookCounter = 0;
	private int memberCounter = 0;

	
	//add members method
	public void addMember(String name, String surname) {
		memberCounter++;
		String id = "M" + String.format("%03d", memberCounter ); //Create the M001 sequence, memberCounter increased so there are no duplicates
		Member m = new Member(name, surname, id); //create the object member
		members.add(m);//add the new member to the list
		
	}
	
	public void addBook(String title, String author, String category, int copies) {
		bookCounter++;
		String id = "B" + String.format("%03d", bookCounter ); //Create the B001 sequence, bookCounter increased so there are no duplicates
		Book b = new Book (title, author,id, category, copies);
		books.add(b);
		
	}
	
	public void printAllMembers() {
		if (members.isEmpty()) {
			System.out.println("No active members!");
		}
		else {
			for (Member m : members) {
			m.printData();
		}
		}
	}	
	
	public void printAllBooks() {
		if(books.isEmpty()) {
			System.out.println("No books available!");
		}
		else {
			for(Book b : books) {
				b.printData();
			}
		}	
	}
	
	public void printAllBorrows() {
		if(borrows.isEmpty()) {
			System.out.println("No active borrows!");
		}
		else {
			for(Borrow b : borrows) {
				b.printData();
			}
		}	
	}
	
	public Book searchBookByTitle(String title) {
		for(Book b : books) {
			if( b.getTitle().equals(title)) {
				return b;
			}
			
		}
			return null;
	}
	
	public Book searchBookByID(String id) {
		for(Book b : books) {
			if(b.getBookID().equals(id)){
				return b;
			}
		}
		return null;
	}
	
	public Member searchMemberByID(String id) {
		for (Member m : members) {
			if (m.getID().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	public void removeMember(String id) { //find the member by id and remove them
		Member m = searchMemberByID(id);
		if (m != null) {
			members.remove(m);
		}
		else {
			System.out.println("Member not found!");
		}
		
	}
	
	public void removeBook(String id) {
		Book b = searchBookByID(id);
		if (b != null) {
			books.remove(b);
		}
		else {
			System.out.println("Book not found!");
		}
	}
	
	public void saveBooksToFile() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("books.csv"))){
			for (Book b : books) {
				bw.write(b.getBookID() + "," + b.getTitle()+ "," + b.getAuthor() + "," + b.getCategory() + "," + b.getCopies() );
				bw.newLine();
			}
			System.out.println("Successfully wrote books to the file.");

		}
		catch (IOException e) {
			System.out.println("Error writing file.");
		}			
	}
	
	public void saveMembersToFile() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("members.csv"))){
			for (Member m : members) {
				bw.write(m.getID() + "," + m.getName() +"," + m.getSurname()  );
				bw.newLine();
			}
			System.out.println("Successfully wrote members to the file.");

		}
		catch (IOException e) {
			System.out.println("Error writing file.");
		}			
	}
	
	public void saveBorrowsToFile() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("borrows.csv"))){
			for (Borrow b : borrows) {
				bw.write(b.getMemberID() + "," + b.getBookID() + "," + b.getBorrowDate());
				bw.newLine();
			}
			System.out.println("Successfully wrote borrows to the file.");

		}
		catch (IOException e) {
			System.out.println("Error writing file.");
		}			
	}

	public void loadBooksFromFile() {
		File f = new File("books.csv");
		if (!f.exists()){
			try {
				f.createNewFile();
			}
			catch (IOException e) {
				System.out.println("Error creating file.");
			}
		}
		try(BufferedReader br = new BufferedReader(new FileReader("books.csv"))){
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				String id = parts[0];
				String title = parts[1];
				String author = parts[2];
				String category = parts[3];
				int copies = Integer.parseInt(parts[4]);
				Book b = new Book(title, author, id, category, copies);
				books.add(b);
				bookCounter++;
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file.");
		}	
	}
	
	public void loadMembersFromFile() {
		File f = new File("members.csv");
		if (!f.exists()) {
			try {
				f.createNewFile();
			}
			catch(IOException e){
				System.out.print("Error creating file.");
			}
		}
		try(BufferedReader br = new BufferedReader(new FileReader("members.csv"))){
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				String id = parts[0];
				String name = parts[1];
				String surname = parts[2];
				Member m = new Member(name, surname, id);
				members.add(m);
				memberCounter++;
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file.");
		}	
	}
	
	public void loadBorrowsFromFile() {
		File f = new File("borrows.csv");
		if (!f.exists()) {
			try {
				f.createNewFile();
			}
			catch(IOException e) {
				System.out.println("Error creating file.");
			}
		}
		try(BufferedReader br = new BufferedReader(new FileReader("borrows.csv"))){
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				String memberID= parts[0];
				String bookID = parts[1];
				LocalDate borrowDate = LocalDate.parse(parts[2]);
				Borrow b = new Borrow(memberID,bookID, borrowDate);
				borrows.add(b);
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file.");
		}	
	}

	public void borrowBook(String memberID, String bookID) {
		Member m = searchMemberByID(memberID);
		Book b = searchBookByID(bookID);
		if (m == null) {
			System.out.println("Member not found!");
		}
		else if ( b == null) {
			System.out.println("Book not found!");
		}
		else if (b.getCopies() == 0 ) {
			System.out.println("No copies available!");
		}
		else {
			Borrow borrow = new Borrow (m.getID(), b.getBookID(), LocalDate.now());
			borrows.add(borrow);
			b.setCopies(b.getCopies() - 1);
			System.out.println(m.getName() + " " + m.getSurname() + " " + " borrowed " + b.getTitle() + " book!");
				}
		}
	
	public Borrow searchBorrow(String memberID, String bookID) {
		for (Borrow borrow : borrows) {
			if(borrow.getMemberID().equals(memberID) && borrow.getBookID().equals(bookID)) {
				return borrow;
			}
		}
		return null;
	}
	
	public void returnBook(String memberID, String BookID) {
		Borrow b = searchBorrow(memberID, BookID); //find the record
		if (b != null) {
			borrows.remove(b);
			Book b1 = searchBookByID(BookID);
			b1.setCopies(b1.getCopies() + 1);
			System.out.println("Book return successfully!");
		}
		else {
				System.out.println("Borrow not found!");
		}
		}
	
	public void checkOverDue() {
		boolean found = false;
		for(Borrow b : borrows) {
			if (b.getDueDate().isBefore(LocalDate.now())) {
				System.out.println(b.getBookID() + " is overdue!");
				found = true;
			}
		}
		if(!found) {
			System.out.println("No overdue books!");
		}
	}
	}

