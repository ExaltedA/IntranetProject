import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class Core {
	User curSession;
	Databases data = Databases.getInstance();
	static int maxAttempt = 0;
	Core(){

		data.students.add(new Student("Daniyar", "Moldakhan", "18BD112356", "a_esenturov", "Aldik12", Faculty.FIT, "CSS", 2, 21, StudentType.BACHELOR));
		data.students.add(new Student("Assel", "Bekbayeva", "17BD120125", "a_bekbayeva", "Novembar2019", Faculty.FOGI, "FOGI" , 3, 19,StudentType.BACHELOR));
		data.students.add(new Student("Adil", "Seitzhanov", "19BD32208", "a_seitzhanov", "August2019", Faculty.SCE, "CTOS", 1, 19,StudentType.BACHELOR));
		data.students.add(new Student("Zhanna", "Kissenova", "18BD240613", "zh_kissenova", "Astana2017", Faculty.BS, "Finance" , 2, 21,StudentType.BACHELOR));

	}
	public void Start() throws IOException {
		System.out.println("Welcome to the KBTU Intranet!");
		System.out.println("Please Enter your login and Password: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		processSignIn();
		showNews();
		String any = br.readLine();
		if(!any.isEmpty()) {
			
		}

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
				break;
			}    	

		}
		if(maxAttempt<5) {
			if(!found) {
				System.out.println("Try again");
				processSignIn();
			}}
		else System.out.println("Your entry data is invalid, please seek help from the Techguy or Admin, Telegram: @ExaltedA");
	}
	public void showNews() throws IOException { 
		
		BufferedReader in = new BufferedReader(new FileReader("news.txt"));
		String line = in.readLine();
		while(line != null)
		{
		  System.out.println(line);
		  line = in.readLine();
		}
		in.close();
		System.out.println("Press any key to proceed to menu..");
	}
	
	public void studentMenu() throws IOException {
		System.out.println("");
		
		
		Keys keys;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command= br.readLine();
		command.toUpperCase();
		if(command.equals("1")) {
		
		}
		
	}
	
}
