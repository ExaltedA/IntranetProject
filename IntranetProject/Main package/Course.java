import java.util.*;
public class Course {
	private String name,id;
	private int credits;
	private Faculty faculty;
	
	HashSet<Course> Pre = new HashSet<Course>();

	Course(){
		this.name=name;
		this.id=id;
		this.credits=0;}

	Course(Faculty a,String name, String id,int credits){
		faculty =a;
		this.name=name;
		this.id=id;
		this.credits=credits;
	}
	public boolean hasPrereq() { // returns True if vector has prerequisite, False otherwise
		return !Pre.isEmpty();
	}
	public boolean addPrereq(Course a) {

		if(Pre.size()<3) {
			Pre.add(a);
			return true;
		}

		else {System.out.println("Error!! Course reached upper limit of prerequisites!!");
		return false;
		}}
	public void showPrereq() {
		System.out.println("Course Prerequisites: ");
		for(Course q:Pre) {
			System.out.println(q.toString() + " ");
		}	
	}
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getId(){
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public boolean removePrereq(String id) {
		for(Course q:Pre) {
			if(q.id.equals(id)) {
				Pre.remove(q);
				System.out.println("Delete completed." + "");
				return true;
			}

		}return false;	
	}
	public boolean removePrereq(Course i) {
		for(Course q:Pre) { if(q.equals(i)) {
			Pre.remove(q);
			System.out.println("Delete completed." + "");
			return true;
		}}
		return false;
	}	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits=credits;
	}
	public String toString() {
		return "Course [" + name + ", id = " + id + ", weight: " +credits + " credits ]";
	}
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + id.hashCode();
		return result;
	};

	public boolean equals(Object obj) {
		Course a = (Course) obj;
		return (this.name.equals(a.name) && this.id.equals(a.id) );

	}

}



