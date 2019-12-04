import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
public class Student extends User implements Viewable,Serializable{

	private int yearOfStudy;
	public int numberCredits;
	private Faculty faculty;
	private String speciality;
	StudentType sType;
	Map<Course, Mark> oldCourses = new HashMap<Course, Mark>();
	Map<Course, Mark> curCourses = new HashMap<Course, Mark>();
	Databases data = Databases.getInstance();
	public Student() {}

	public Student(String name, String surname, String id, String login, 
			String password, Faculty faculty, String speciality, int yearOfStudy, StudentType sType) {
		super(name, surname, id, login, password);
		this.faculty = faculty;
		this.speciality = speciality;
		this.yearOfStudy = yearOfStudy;
		this.sType = sType;
	}
	public Student(String name, String surname, String id, String login, 
			String password, Faculty faculty, String speciality, int yearOfStudy
			, int numberCredits, StudentType sType) {
		super(name, surname, id, login, password);
		this.faculty = faculty;
		this.numberCredits = numberCredits;
		this.speciality = speciality;
		this.yearOfStudy = yearOfStudy;
		this.sType = sType;
	}

	public void newSemester() { // Clears the maps of cur and moves the data to old
		for (Entry<Course, Mark> entry : curCourses.entrySet()) {
			if(oldCourses.containsKey(entry.getKey())) {
				oldCourses.replace(entry.getKey(), entry.getValue());
				curCourses.remove(entry.getKey());}
			else {
				oldCourses.put(entry.getKey(), entry.getValue());
				curCourses.remove(entry.getKey());
			}}
	}

	public double calculateGPA() {//Calculates and returns gpa
		double a = 0;
		for (Entry<Course, Mark> entry : curCourses.entrySet()) {
			a+=entry.getValue().getGpa();
		}
		return a/(curCourses.size());
	}
	public boolean addCourse(String id) { // adds course
		Course course = null;
		for(Course b: data.courses) {
			if(b.getId().equals(id)) {
				course=b;
			}
		}
		try {
		if(!course.equals(null)) {
		if(numberCredits>=course.getCredits()) {
			if(faculty.equals(course.getFaculty())) {
				curCourses.put(course, new Mark());
				numberCredits-=course.getCredits();
				return true;
			}
			else return false;
		}}
		 return false;
		}
		catch(Exception e) {
			System.out.println("Adding failed");
		}
		return false;
	}
	public boolean removeCourse(String id) {
		Course course = null;
		
		for(Course b: data.courses) {
			if(b.getId().equals(id)) {
				course=b;
			}
		}
		try {
			if(!course.equals(null)) {
		for (Entry<Course, Mark> entry : curCourses.entrySet()) {
			if(entry.getKey().equals(course)) {
				curCourses.remove(course);
				return true;
			}}

		}
		return false;
		}
		catch(Exception e) {
			System.out.println("Dropping failed");
		}
		return false;
	}
	public void viewCourse() { //shows in console
		for(Course a: data.courses) {
			System.out.println(curCourses.toString());
		}}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public int getNumberCredits() {
		return numberCredits;
	}

	public void setNumberCredits(int numberCredits) {
		this.numberCredits = numberCredits;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}  

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String toString() {
		return super.toString() + faculty + " " 
				+ speciality + " " + " gpa " + calculateGPA() + " " + yearOfStudy;
	}

	public boolean equals() {
		return super.equals(getPassword());
	}

	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public void viewMarks() {
		for (Entry<Course, Mark> entry : curCourses.entrySet()) {
			entry.getValue().toString();
		}
		for (Entry<Course, Mark> entry : oldCourses.entrySet()) {
			entry.getValue().toString();
		}
	}
	public void viewTransript() {
		for (Entry<Course, Mark> entry : curCourses.entrySet()) {
			entry.getValue().toString();
			System.out.print(entry.getValue().getGpa() + entry.getValue().getLet());
		}
		for (Entry<Course, Mark> entry : oldCourses.entrySet()) {
			entry.getValue().toString();
			System.out.print(entry.getValue().getGpa() + entry.getValue().getLet());
		}
		System.out.println("Total Gpa: " + calculateGPA());
	}
	public void viewFiles() {
		System.out.println("Student Files:");
		for (Entry<Course, Mark> entry : curCourses.entrySet()) {
			System.out.println(entry.getKey().getName() + ":");
			for(CourseFiles a: entry.getKey().files) {
				a.toString();
			}
		}
	}
}


