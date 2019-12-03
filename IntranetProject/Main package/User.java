
public class User {
	
private String name;
private String surname;
private String id;
private String login;
private String password;

public User(String name, String surname, String id, String login, String password) {
	this.name = name;
	this.surname = surname;
	this.id = id;
	this.login = login;
	this.password = password;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String toString() {
	return surname + " " + name + " " + " id: " + id;
}

public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	return result;
}

public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (login == null) {
		if (other.login != null)
			return false;
	} else if (!login.equals(other.login))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	return true;
}


}
