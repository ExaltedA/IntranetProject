
public class Employee extends User {
  
	private int salary;
	private String order;
	public Employee() {}
	public Employee(String name, String surname, String id, String login, 
			String password, int salary) {
		super(name, surname, id, login, password);
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return super.toString() + " salary: " + salary;
	}
	
	public boolean equals() {
		return super.equals(getPassword());
	}
	
	public int hashCode() {
		return super.hashCode();
	}
}
