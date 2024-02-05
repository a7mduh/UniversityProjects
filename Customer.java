import java.util.Vector;

public class Customer extends Person{
	private int PhoneNumber;
	Vector<Customer> CustomersList;
	public Customer()
	{
		super();
		CustomersList=new Vector<Customer>();
	}
	public Customer(String name, String user_id, String password, int PhoneNr) {
		super(name, user_id, password);
		this.PhoneNumber=PhoneNr;
	}
	public Customer(String name, String password, int PhoneNr, String user_id) {
		this.name=name;
		this.password=password;
		this.PhoneNumber=PhoneNr;
		this.user_id=user_id;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Vector<Customer> getCustomersList() {
		return CustomersList;
	}
	public void setCustomersList(Vector<Customer> customersList) {
		CustomersList = customersList;
	}
	
}
