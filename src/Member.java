//Member Class

public class Member{
	private String name;
	private String surname;
	private String id;
	
	
	public Member(String name, String surname, String id){
		this.name = name;
		this.surname = surname;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getID() {
		return id;
	}
	
	public void printData() {
		System.out.println("Member ID: " + id + ", Name: " + name + ", Surname: " + surname );
	}
	
}