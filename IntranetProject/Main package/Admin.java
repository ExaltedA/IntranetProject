
public class Admin extends User{
	
    public Admin(String name, String surname, String id, String login, String password) {
		super(name, surname, id, login, password);
	}
	public boolean addUser(User user) {
		
	return true;
}
    public boolean removeUSer(User user) {
    	return true;
    }
    
    public boolean updateInfo() {
    	return true;
    }
    
    public void showAction() {
    	
    }
}

