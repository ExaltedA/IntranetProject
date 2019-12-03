import java.util.*;
public class Teacher extends Employee implements Viewable{
	Teacher(){}
	public Teacher(String name, String surname, String id, String login, String password, int salary) {
		super(name, surname, id, login, password, salary);
	}

	public String order;
	public Vector<String> inbox = new Vector<String>();

	public Vector <Course> teacherCourses = new Vector<Course>();
	Databases data = Databases.getInstance();
	
	public boolean addCourse(String id) {// Add course for teacher
		if(!data.findCourse(id).equals(null)) {
			return teacherCourses.add(data.findCourse(id));
			}
		return false;
	}
	public boolean addCourseFile(String id, String title,String msg) {
		if(!data.findCourse(id).equals(null)) {
			return data.findCourse(id).addFile(title, msg);
			}
		return false;
	}
	public boolean removeCourseFile(String id, String title,String msg) {
		if(!data.findCourse(id).equals(null)) {
			return data.findCourse(id).removeFile(title);
			}
		return false;
	}

	public void viewCourse() {
		for(Course tc: teacherCourses)
			System.out.println(teacherCourses.toString());
	}
	public boolean addMsg(String message) {
		return inbox.add(message);
	}
	public void showInbox() {
		for(String a : inbox) {
			System.out.println(a);
		}
	}
	public boolean removeMsgs() {
		if(!inbox.isEmpty()) {
			inbox.clear();
			return true;
		}
		else return false;
	}
	public String toString() {
		return super.toString() + " " + .name();
	}
}

