import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class Core {
	User curSession;
	Databases data = Databases.getInstance();
	static int maxAttempt = 0;
	Core(){

		data.students.add(new Student("Daniyar",
				"Moldakhan", "18BD112356", "a_esenturov", "Aldik12", Faculty.FIT, "CSS", 2, 21, StudentType.BACHELOR));}
	

	public void Start() throws IOException, ClassNotFoundException {
		System.out.println("Welcome to the KBTU Intranet!");
		System.out.println("Please Enter your login and Password: ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data.desCourses();
		data.desEmployee();
		data.desStudents();
		
		
		processSignIn();
		
		String any = br.readLine();
		if(!any.isEmpty()) {
		try {
		 
			if(curSession instanceof Student) {
				studentMenu();
			}
			else if(curSession instanceof Teacher) 
			{
				teacherMenu();
			}

		}
		catch (Exception e) {
			System.out.println("Unexpected error ... /n Saving resources...");
			e.printStackTrace();
			data.serCourses();
			data.serStudents();
			data.serEmployee();
		}}

	}
	public void processSignIn() throws IOException { // Login and Password function
		maxAttempt++;
		// data.add();
		boolean found = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Login: ");
		String login = br.readLine();
		System.out.print("Password: ");
		String password = br.readLine();

		for(int i = 0; i < data.students.size(); i++) {

			if(login.equals(data.students.get(i).getLogin()) && password.equals(data.students.get(i).getPassword())) {
				curSession = data.students.get(i);
				System.out.println("Welcome!");
				found= true;
				showNews();
				break;
			}  }
		for(int i = 0; i < data.employees.size(); i++) {

			if(login.equals(data.employees.get(i).getLogin()) && password.equals(data.employees.get(i).getPassword())) {
				curSession = data.employees.get(i);
				System.out.println("Welcome!");
				found= true;
				showNews();
				break;
			}  
		}
		if(maxAttempt<5) {
			if(!found) {
				System.out.println("Try again");
				processSignIn();
			}}
		else {System.out.println("Your entry data is invalid, please seek help from the Techguy or Admin, Telegram: @ExaltedA");
		System.out.println("Press any key..");
	}}
	public void showNews() throws IOException { 

		BufferedReader in = new BufferedReader(new FileReader("C:/Users/aldie/Documents/Intranet/IntranetProject/bin/news.txt"));
		String line = in.readLine();
		while(line != null)
		{
			System.out.println(line);
			line = in.readLine();
		}
		in.close();
		System.out.println("Press any key to proceed to menu..");
	}
	
	public void studentMenu() throws IOException, ClassNotFoundException {
		Student a = (Student)curSession;
		System.out.println("1.View Attestation");
		System.out.println("2.Register for course");
		System.out.println("3.Drop Course");
		System.out.println("4.View transcript");
		System.out.println("5.View Files");
		System.out.println("6.View My Courses");
		System.out.println("Q for Quit and P for password changing.");
		System.out.println("Press the number or Keys Q/P and Enter ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command= br.readLine();
		command.toUpperCase();
		
		if(command.equals("1")) {
			a.viewMarks();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				studentMenu();
			}
		}
		if(command.equals("2")) {

			while(true) {
				System.out.println("Enter id of the course to enroll(Q to go back): ");
				command = br.readLine();
				if(command.equalsIgnoreCase("Q")) {
					studentMenu();
				}
				if(a.addCourse(command)){
					System.out.println("Course has been Added!");
				}}
		}	
		if(command.equals("3")) {
			while(true) {
			System.out.println("Enter id of the course to drop(Q to go back): ");
			command = br.readLine();
			if(command.equalsIgnoreCase("Q")) {
				studentMenu();
			}
			if(a.removeCourse(command)){
				System.out.println("Course has been Dropped!");
			}}}
		
		if(command.equals("4")) {
			a.viewTransript();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				studentMenu();
			}
			
		}
		if(command.equals("5")) {
			a.viewFiles();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				studentMenu();
			}
		}
		if(command.equals("6")) {
			a.viewCourse();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				studentMenu();
			}
		}
		if(command.equals("Q")) {
			data.serCourses();
			data.serStudents();
			data.serEmployee();
			System.out.println("Logout Completed.");
			Start();
		}
		if(command.equals("P")) {
			System.out.println("Enter new password: ");
			a.setPassword(br.readLine());
			System.out.println("Password changed successful! Q for returning to menu!");
			if(br.readLine().equalsIgnoreCase("Q")) {
				data.serCourses();
				data.serStudents();
				data.serEmployee();
				studentMenu();
			}
		}


	}	
	
	public void teacherMenu() throws IOException, ClassNotFoundException {
		Teacher a = (Teacher)curSession;
		System.out.println("1.View My Courses");
		System.out.println("2.View Course Files");
		System.out.println("3.Add Course Fies");
		System.out.println("4.Reomve Course Files");
		System.out.println("5.Put Mark");
		System.out.println("6.View Inbox");
		System.out.println("7.Clear Inbox");
		System.out.println("8.View Student Marks");
		System.out.println("Q for Quit and P for password changing.");
		System.out.println("Press the number or Keys Q/P and Enter ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command= br.readLine();
		command.toUpperCase();
		
		if(command.equals("1")) {
			a.viewCourse();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				teacherMenu();
			}
		}
		if(command.equals("2")) {
			a.showCourseFiles();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				teacherMenu();
			}
			
		}
		if(command.equals("3")) {

			while(true) {
				System.out.println("Enter id, title, message to add Course File (Q to go back): ");
				if(br.readLine().equalsIgnoreCase("Q")) {
					studentMenu();
				}
				if(a.addCourseFile(br.readLine(),br.readLine(),br.readLine())){
					System.out.println("Course File has been Added!");
				}}
		}	
		if(command.equals("4")) {
			while(true) {
			System.out.println("Enter id, title to add Course File (Q to go back): ");
			if(br.readLine().equalsIgnoreCase("Q")) {
				studentMenu();
			}
			if(a.removeCourseFile(br.readLine(),br.readLine())){
				System.out.println("Course File has been Dropped!");
			}}}
		
	
		if(command.equals("5")) {
			System.out.println("Enter StudentID, CourseID, a1/a2/f, Mark");
			a.putMark(br.readLine(), br.readLine(), br.readLine(), Double.parseDouble(br.readLine()));
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				teacherMenu();
			}
		}
		if(command.equals("6")) {
			a.showInbox();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				teacherMenu();
			}
		}
		if(command.equals("7")) {
			a.removeMsgs();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				teacherMenu();
			}
		}
		if(command.equals("8")) {
			a.viewMarks();
			System.out.println("Q for back");
			if(br.readLine().equalsIgnoreCase("Q")) {
				teacherMenu();
			}
		}
		if(command.equalsIgnoreCase("Q")) {
			data.serCourses();
			data.serStudents();
			data.serEmployee();
			System.out.println("Logout Completed.");
			Start();
		}
		if(command.equalsIgnoreCase("P")) {
			System.out.println("Enter new password: ");
			a.setPassword(br.readLine());
			System.out.println("Password changed successful! Q for returning to menu!");
			if(br.readLine().equalsIgnoreCase("Q")) {
				data.serCourses();
				data.serStudents();
				data.serEmployee();
				teacherMenu();
			}
		}


	}	




}


