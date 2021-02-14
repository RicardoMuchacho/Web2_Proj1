package helpers;

public class User {


	private String name;
	private String pass;
	private int age;
	private String address;
	private Boolean subscribed;
	private String email;

	public User(String name, String pass, int age, String address, Boolean subscribed, String email) {
		super();
		this.name = name;
		this.pass = pass;
		this.age = age;
		this.address = address;
		this.subscribed = subscribed;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

