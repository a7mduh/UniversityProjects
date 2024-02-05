
public class Person {
	protected String name, user_id, password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person(String name, String user_id, String password) {
		this.name = name;
		this.user_id = user_id;
		this.password = password;
	}

	public Person() {
		
	}
	
}
