public class Manager extends Employee {

	ManagerType type;
	Databases data = Databases.getInstance();
	public Manager() {}
	public Manager(String name, String surname, String id, String login, String password, int salary, ManagerType type)
	{
		super(name, surname, id, login, password, salary);
		this.type = type;
	}
	
	public void setCredits(int credits,Faculty f, int yearofstudy) { // sets credits to a students within same faculty and year
		for(Student a: data.students) {
			if(a.getFaculty().equals(f) && a.getYearOfStudy()==yearofstudy) {
				a.setNumberCredits(credits);
			}
		}
	}
	
	public boolean addCourse(Teacher a,String id) {// Add course for teacher
		if(!data.findCourse(id).equals(null)) {
			a.teacherCourses.add(data.findCourse(id));
			return true;}
		return false;
	}

	public boolean addCourse(Student a,String id) {// Add course for Student
		if(!data.findCourse(id).equals(null)) {
			return a.addCourse(id);
		}
		return false;
	}
	public void addStudentsCourse(Faculty a, int year, String id) {
		Course course = data.findCourse(id); // Adds certain course to all students in a same faculty and year of study

		for(Student b: data.students) {
			if(b.getYearOfStudy() == year && course.getFaculty().equals(a)) {
				b.addCourse(id);			 
			}}
	}
	public boolean removeCourse(String id) { // removes course from database
		for(Course b: data.courses) {
			if(b.getId().equals(id)) {
				data.courses.remove(b);
				return true;
			}
		}
		return false;
	}
	public boolean addNewCourse(Faculty a,String name, String id,int credits) { // adds new course to a database
		return data.courses.add(new Course(a,name,id,credits));

	}
	public boolean sendMessage(Teacher a,String message) { // sends a message to a teacher
		return a.addMsg(message);
	}

	public void infoStudents() { // Displays info about students
		for(int i = 0; i < Databases.students.size(); i++)
			System.out.println(Databases.students.get(i).toString());
	}

	public void infoTeachers() { // Displays info about Teachers
		for(Employee e: Databases.employees) {
			if(e instanceof Teacher) {
				Teacher a = (Teacher)e;
				System.out.println(e.toString());
			}
		}
	}

	public String report() { // displays report
		int numberSt1 = 0;
		int numberSt2 = 0;
		int numberSt3 = 0;
		int numberSt4 = 0;
		int total = 0;

		for(int i = 0; i < Databases.students.size(); i++) {
			if(Databases.students.get(i).getYearOfStudy() == 1) {
				numberSt1 += 1;
			}
			else if(Databases.students.get(i).getYearOfStudy() == 2) {
				numberSt2 += 1;
			}
			else if(Databases.students.get(i).getYearOfStudy() == 3) {
				numberSt3 += 1;
			}
			else if(Databases.students.get(i).getYearOfStudy() == 4) {
				numberSt4 += 1;
			}
		}
		total = numberSt1 + numberSt2 + numberSt3 + numberSt4;

		return "The number of students of 1st course is " + numberSt1 + "\n" + 
		"The number of students of 2nd course is " + numberSt2 + "\n" +
		"The number of students of 3rd course is " + numberSt3 + "\n"+
		"The number of students of 4th course is " + numberSt4 + "\n" +
		"Total number of students is " + total;
	}

	public boolean addNews() {
		return false;
	}
	public boolean removeNews() {
		return false;
	}
	
	public String toString() {
		return super.toString() + " " + type.name();
	}
}