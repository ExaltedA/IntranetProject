import java.util.*;
public class Course {
	private String name,id;
	private int credits=0;
	
	HashSet<Course> Pre = new HashSet<Course>();
	
	Course(){}
	
	Course(String name, String id,int credits){
		this.name=name;
		this.id=id;
		this.credits=credits;
	}
	public boolean hasPrereq() { // returns True if vector has prerequisite, False otherwise
		return !Pre.isEmpty();
	}
	public void addPrereq(Course a) {
		if(Pre.size()<3)
			Pre.add(a);
		else {System.out.println("Error!! Course reached upper limit of prerequisites!!");
			
		}}
	public void showPrereq() {
		System.out.println("Course Prerequisites: ");
		for(Course q:Pre) {
		System.out.println(q.toString() + " ");
		}	
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
	public void removePrereq(String id) {
		for(Course q:Pre) { if(q.id.equals(id)) {
			Pre.remove(q);
			System.out.println("Delete completed." + "");
		}
			
			}	
	}
	public void removePrereq(Course i) {
		for(Course q:Pre) { if(q.equals(i)) {
			Pre.remove(q);
			System.out.println("Delete completed." + "");
		}}
			
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
	
	 

