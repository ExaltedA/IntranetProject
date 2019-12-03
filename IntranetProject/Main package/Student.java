import java.util.*;
public class Student extends User implements Viewable{

	private int yearOfStudy;
	private double gpa;
	public int numberCredits;
	private String faculty;
	private String speciality;
	StudentType sType;
	
	Map<Course, Mark> courseMark = new HashMap<Course, Mark>();
	Databases data = Databases.getInstance();
	
	public void addCourse(Course course) {
			courseMark.put(course, new Mark());
	}
	
	public Student(String name, String surname, String id, String login, 
			String password, String faculty, String speciality, int yearOfStudy,
			double gpa, int numberCredits, StudentType sType) {
		super(name, surname, id, login, password);
		this.gpa = gpa;
		this.faculty = faculty;
		this.numberCredits = numberCredits;
		this.speciality = speciality;
		this.yearOfStudy = yearOfStudy;
		this.sType = sType;
	}
	
	public void viewCourse() {
			System.out.println(courseMark);
		}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getNumberCredits() {
		return numberCredits;
	}

	public void setNumberCredits(int numberCredits) {
		this.numberCredits = numberCredits;
	}
	
	public String getFaculty() {
		return faculty;
	}
	
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}  
	
	public String getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public String toString() {
		return super.toString() + faculty + " " + speciality + " " + " gpa " + gpa + " " + yearOfStudy;
	}
	
	public boolean equals() {
		return super.equals(getPassword());
	}
	
	public int hashCode() {
		return super.hashCode();
	}

}
