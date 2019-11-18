import java.util.*;
public class Course {
	private	Course Prereq,Prereq1,Prereq2;
	private String name,id;
	boolean isPrereq;
	Stack<Course> Pre = new Stack();
	Course(){}
	Course(String name, String id){
		this.name=name;
		this.id=id;
	}
	public void addPrereq(Course a) {
		if(Pre.size()<3)
			Pre.add(a);
		else System.out.println("");
	}
	public void showPrereq() {
		return Prereq;	
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
	public void removePrereq() {
		
	}
	
	public boolean equals(Object obj) {
        return (this == obj);
}
	}
}
