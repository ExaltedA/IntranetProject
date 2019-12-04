import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

    public final class Databases implements Serializable{ 
    	private static final Databases ONE = new Databases();
    	private Databases() {};
    public Vector<Order> newOrders = new Vector<Order>();
    public Vector<Order> orders = new Vector<Order>();
    static Vector<Course> courses = new Vector<Course>();
	static Vector<Student> students = new Vector<Student>();
	static Vector<Employee> employees = new Vector<Employee>();
	
	public static Databases getInstance() {
		return ONE;
	}
	
	static FileInputStream fis;
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static ObjectInputStream oin;
	
	public Course findCourse(String id) {//find Course instance by id
		for(Course b: courses) {
			if(b.getId().equals(id)) {
				return b;
			}
		}
		return null;
	}
	public Student findStudent(String id) {//find Course instance by id
		for(Student b: students) {
			
			if(b.getId().equals(id)) {
				return b;
			}
		}
		return null;
	}
	  public static void desEmployee() throws IOException, ClassNotFoundException{
		    fis = new FileInputStream("employees");
		    oin = new ObjectInputStream(fis);
		    employees = (Vector<Employee>)oin.readObject();
		  }
		  
		  public static void serEmployee()throws IOException{
		    fos = new FileOutputStream("employees");
		    oos = new ObjectOutputStream(fos);
		    oos.writeObject(employees);
		    oos.close();
		  }
	public static void desCourses() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("courses");
		oin = new ObjectInputStream(fis);
		courses = (Vector<Course>) oin.readObject();
	}
	public static void serCourses()throws IOException{
		fos = new FileOutputStream("courses");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.close();
	}
	public  static void desStudents() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("students");
		oin = new ObjectInputStream(fis);
		students = (Vector<Student>) oin.readObject();
	}
	
	public static void serStudents()throws IOException{
		fos = new FileOutputStream("students");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(students);
		oos.close();
	}
	
}
