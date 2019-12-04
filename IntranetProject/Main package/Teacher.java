import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
public class Teacher extends Employee implements Viewable,Serializable{
	private TeacherType type;
	Teacher(){}
	public Teacher(String name, String surname, String id, String login, String password, int salary,TeacherType type) {
		super(name, surname, id, login, password, salary);
	}

	public String order;
	public Vector<String> inbox = new Vector<String>();

	public Vector <Course> teacherCourses = new Vector<Course>();
	Databases data = Databases.getInstance();
	
	public void showCourseFiles() {
		for(Course a: teacherCourses) {
			for(CourseFiles v: a.files) {
				v.toString();
			}
		}
	}
	public boolean putMark(String studid, String courseid,String a,double mark) {

		if(!data.findCourse(courseid).equals(null) && !data.findStudent(studid).equals(null)) {
			if(a.equalsIgnoreCase("a1")) {
				data.findStudent(studid).curCourses.get(data.findCourse(courseid)).setA1(mark);}
			else if(a.equalsIgnoreCase("a2")) {
				data.findStudent(studid).curCourses.get(data.findCourse(courseid)).setA2(mark);}
			else if(a.equalsIgnoreCase("f")) {
				data.findStudent(studid).curCourses.get(data.findCourse(courseid)).setF(mark);}
			return true;}
		return false;
	}

	public boolean addCourse(String id) {// Add course for teacher
		if(!data.findCourse(id).equals(null)) {
			return teacherCourses.add(data.findCourse(id));
		}
		return false;
	}
	public boolean addCourseFile(String id, String title,String msg) {
		try {
		if(!data.findCourse(id).equals(null)) {
			return data.findCourse(id).addFile(title, msg);
		}
		return false;
	}
		catch(Exception e) {
			System.out.println("Some problems");
		}
		return false;}
	
	public boolean removeCourseFile(String id, String title) {
		if(!data.findCourse(id).equals(null)) {
			return data.findCourse(id).removeFile(title);
		}
		return false;
	}

	public void viewCourse() {
		for(Course tc: teacherCourses)
			System.out.println(tc.toString());
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
	public TeacherType getType() {
		return type;
	}
	public void setType(TeacherType type) {
		this.type = type;
	}
	public String toString() {
		return super.toString() + " " + type;
	}
	@Override
	public void viewMarks() {
		for(Course b : teacherCourses) {
			System.out.println(b.getName() + ": " );
			for(Student a : data.students) {
				for (Entry<Course, Mark> entry : a.curCourses.entrySet()) {
					if(entry.getKey().equals(b)){
						System.out.println(a.getName() + " " + a.getSurname() + " " +  entry.getValue().toString());
					}
				}
			}
		}
	}
}

