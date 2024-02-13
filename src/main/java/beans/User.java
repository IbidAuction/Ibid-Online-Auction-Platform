package beans;

import java.util.Date;

public class User {
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String city;
	private String phone;
	private String region;
	private String userStatus;
	private Date registrationDate;
	private String profileImage;
	
	public User() {
		super();
	}
	public User(int userID, String firstName, String lastName, String email, String password, String city, String phone,
			String region, String userStatus, Date registrationDate, String profileImage) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phone = phone;
		this.region = region;
		this.userStatus = userStatus;
		this.registrationDate = registrationDate;
		this.profileImage = profileImage;
	}
	public User(String firstName, String lastName, String email, String password, String city, String phone,
			String region, String profileImage) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phone = phone;
		this.region = region;
		this.profileImage = profileImage;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", city=" + city + ", phone=" + phone + ", region=" + region
				+ ", userStatus=" + userStatus + ", registrationDate=" + registrationDate + ", profileImage="
				+ profileImage + "]";
	}
	
}
