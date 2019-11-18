import java.util.*;
public class Course {
	private	Course Prereq;
	private String name,id;
	boolean isPrereq;
	Vector<Course> Pre = new Vector<Course>();
	Course(){}
	Course(String name, String id){
		this.name=name;
		this.id=id;
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
	

	@Override
	public String toString() {
		return "Course [name=" + name + ", id=" + id + "]";
	}
	public int hashCode() {
		 int result = 17;
	        result = 31 * result + name.hashCode();
	        result = 31 * result + id.hashCode();
	        return result;
	};

	public boolean equals(Course obj) {
        return (this.name.equals(obj.name) && this.id.equals(obj.id) );
        	
        }
     
}
	
	 

