import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Core {
	Databases data = Databases.getInstance();

	Core(){

		data.students.add(new Student("Daniyar", "Moldakhan", "18BD112356", "d_moldakhan", "Kbtu111", "FIT", "CSS", 2, 3, 21, StudentType.BACHELOR));
		data.students.add(new Student("Assel", "Bekbayeva", "17BD120125", "a_bekbayeva", "Novembar2019", "FOGI", "FOGI" , 3, 3.5, 19,StudentType.BACHELOR));
		data.students.add(new Student("Adil", "Seitzhanov", "19BD32208", "a_seitzhanov", "August2019", "SCE", "CTOS", 1, 2.8, 19,StudentType.BACHELOR));
		data.students.add(new Student("Zhanna", "Kissenova", "18BD240613", "zh_kissenova", "Astana2017", "BS", "Finance" , 2, 3.2, 21,StudentType.BACHELOR));

	}
	public void Start() throws IOException {
		System.out.println("Welcome to the KBTU Intranet!");
		System.out.println("Please Enter your login and Password: ");
		processSignIn();
	}
	public void processSignIn() throws IOException {

		// data.add();
		boolean found = false;
		int maxAttempt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Login: ");
		String login = br.readLine();
		System.out.print("Password: ");
		String password = br.readLine();

		for(int i = 0; i < data.students.size(); i++) {

			if(login.equals(data.students.get(i).getLogin()) && password.equals(data.students.get(i).getPassword())) {
				System.out.println("Welcome!");
				found= true;
				break;
			}    	
			
		}
		if(maxAttempt<5) {
		if(!found) {
			System.out.println("Try again");
			maxAttempt++;
			processSignIn();
		}}
	}

}
