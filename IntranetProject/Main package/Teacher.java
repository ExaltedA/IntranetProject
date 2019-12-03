import java.util.*;
public class Teacher extends Employee implements Viewable{

	public Teacher(String name, String surname, String id, String login, String password, int salary, String order) {
		super(name, surname, id, login, password, salary, order);
	}

	public String order;
	public Vector <Course> teacherCourses = new Vector<Course>();
	Databases data = Databases.getInstance();
	public void addCourse(Course course) {
		teacherCourses.add(course);
	}

	public void viewCourse() {
		for(Course tc: teacherCourses)
		System.out.println(teacherCourses.toString());
	}

}
