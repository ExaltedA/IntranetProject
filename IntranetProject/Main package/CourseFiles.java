
public class CourseFiles {

	Course course;
	private String name;
	
	public CourseFiles(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return course + " " + name;
	}
}
