package customer;

import java.time.LocalDate;

import com.servicePlan.ServicePlan;

public class Customer implements Comparable<Customer> {

	public static int idGenrator=0;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private int registrationAmount;
	private ServicePlan servicePlan;

	
	public Customer(String email) {
		this.email=email;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName, String lastName, String email, String password, LocalDate dob,
			int registrationAmount, ServicePlan servicePlan) {
		super();
		this.id=idGenrator++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.registrationAmount = registrationAmount;
		this.servicePlan = servicePlan;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(int registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public ServicePlan getServicePlan() {
		return servicePlan;
	}

	public void setServicePlan(ServicePlan servicePlan) {
		this.servicePlan = servicePlan;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob
				+ ", servicePlan=" + servicePlan + "]";
	}
		
	
	public boolean equals(Object o) {
		if(o instanceof Customer) {
			Customer c=(Customer)o;
			return this.email.equals(c.email);
		}
		return false;
		
	}

	@Override
	public int compareTo(Customer c1) {
		//calling String class compareTo
		return this.email.compareTo(c1.email);
		
	}
	
	
	
}
