import java.io.*;
public class Test {

	public static void main(String[] args) throws IOException {
		Databases data = Databases.getInstance();
       // data.add();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Login: ");
        String login = br.readLine();
        System.out.print("Password: ");
        String password = br.readLine();
        
        for(int i = 0; i < data.students.size(); i++) {
        	if(login.equals(data.students.get(i).getLogin()) && password.equals(data.students.get(i).getPassword())) {
        		System.out.println("Welcome!");
        	break;
        	}    	
        else {
        	System.out.println("Try again");
        	break;
	}
    }
}

}
