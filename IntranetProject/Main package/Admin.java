import java.io.Serializable;

public class Admin extends User implements Serializable{
	Databases data = Databases.getInstance();
	public Admin(String name, String surname, String id, String login, String password) {
		super(name, surname, id, login, password);
	}
	public boolean addStudent(String name, String surname, String id, String login, 
			String password, Faculty faculty, String speciality, int yearOfStudy, StudentType sType) {
		return data.students.add(new Student(name, surname, id, login, password, faculty, speciality, yearOfStudy, sType));
		
	}
	public boolean addManager(String name, String surname, String id, String login, String password, int salary, ManagerType type){
		return data.employees.add(new Manager(name,surname,id,login,password,salary,type));
	}
	public boolean addExecutor(String name, String surname, String id, String login, String password, int salary) {
		return data.employees.add(new Executor(name, surname, id, login, password, salary));
	}
	public boolean addTeacher(String name, String surname, String id, String login, String password, int salary,TeacherType type) {
		return data.employees.add(new Teacher(name, surname, id, login, password, salary,type));
	}
	public boolean removeUser(Student student) {
		for(Student a: data.students) {
			if(student.equals(a)) {
				data.students.remove(a);
				return true;
			}
		}
		return false;
	}
	public boolean removeUser(Employee employee) {
		for(Employee a: data.employees) {
			if(employee.equals(a)) {
				data.employees.remove(a);
				return true;
			}
		}
		return false;
	}
	public void showInfo() {
		int aq=0,bq=0;
		for(Student a: data.students) {
			aq++;
		System.out.println(a.toString());
		}
		for(Employee a: data.employees) {
			bq++;
			System.out.println(a.toString());
			}
		System.out.println("Total num of Students: " + aq + ", total num of Employees: " + bq + ".");
		
		
	}


}

