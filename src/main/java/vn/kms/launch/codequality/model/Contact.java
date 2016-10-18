package vn.kms.launch.codequality.model;

import vn.kms.launch.codequality.annotation.Length;
import vn.kms.launch.codequality.annotation.Pattern;
import vn.kms.launch.codequality.annotation.State;

public class Contact {
	private int id;
	@Length(min=1, max=10)
	private String firstName;
	
	@Length(min=1, max=10)
	private String lastName;
	
	@Length(max=20)
	private String address;
	
	@Length(max=15)
	private String city;
	
	@State
	private String state;
	
	@Pattern(pattern="^\\d{4,5}$")
	private String zipcode;
	
	@Pattern(pattern="^\\d{3}\\-\\d{3}\\-\\d{4}$")
	private String mobilePhone;
	
	@Pattern(pattern="^.+@.+\\..+$")
	private String email;
	
	private int age;
	
	@Length(min=10, max=10)
	private String dayOfBirth;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipcode;
	}

	public void setZipCode(String zipCode) {
		this.zipcode = zipCode;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
	public String toLine() {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s", id,
				firstName, lastName, dayOfBirth, address, city, state, zipcode,
				mobilePhone, email);
	}

	@Override
	public String toString() {
		return "Contact [id=" + this.id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipcode
				+ ", mobilePhone=" + mobilePhone + ", email=" + email
				+ ", age=" + age + ", dayOfBirth=" + dayOfBirth + "]";
	}

}
