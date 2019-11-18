
public class Course {
	private	Course Prereq;
	private String name,id;
	boolean isPrereq;

	Course(){}
	Course(String name, String id){
		this.name=name;
		this.id=id;
	}
	public void setPrereq(Course a) {
		this.Prereq = a;
	}
	public Course getPrereq() {
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

}
