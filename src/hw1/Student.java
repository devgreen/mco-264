package hw1;

import java.io.Serializable;

public class Student implements Serializable{
	private Integer studentID;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private Character gender;
	private String major;
	private Integer numCredits;
	private double gpa;
	
	
	
	
	public Student(Integer studentID, String firstName, String lastName, Character gender, String major ) throws InvalidDataException{
		if(studentID == null || firstName == null ||lastName == null|| gender == null || major == null ){
			throw new InvalidDataException ();
		}
		if (gender != 'M' && gender != 'F'){
			throw new InvalidDataException ();
			
		}
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.major = major;
		
		
	}
	
	public String getFirstName() {
		return firstName;
	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getStudentID() {
		return studentID;
	}
//	public void setStudentID(Integer studentID) {
//		this.studentID = studentID;
//	}
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Character getGender() {
		return gender;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getNumCredits() {
		return numCredits;
	}
	public void setNumCredits(Integer numCredits) {
		this.numCredits = numCredits;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) throws InvalidDataException{
		this.gpa = gpa;
		if (gpa> 4.0 || gpa < 0.0){
			throw new InvalidDataException();
			
		}
		
	}
	public int compareTo(Student other) {
		return this.studentID.compareTo(other.studentID); 
	}
	
	public boolean equals(Student student){
		return this.studentID.equals(student.getStudentID());
			
		
	}
	
	public String toString(){
		StringBuilder info = new StringBuilder();
		info.append("StudentID: ");
		info.append(studentID);
		info.append(" Student Name: ");
		info.append(firstName);
		info.append(" ");
		info.append(lastName);
		info.append(" Gender: ");
		info.append(gender);
		info.append(" Major: ");
		info.append(major);
		if (address != null){
			info.append(" Address: ");
			info.append(address);
			info.append(" ");
			info.append(city);
			info.append(" ");
			info.append(state);
			info.append(" ");
			info.append(zip);
			
		}
		if (numCredits != null){
			info.append(" Number of credits: ");
			info.append(numCredits);
			
		}
		if (gpa > 0){
			info.append(" GPA: ");
			info.append(gpa);
			
		}
		return info.toString();
	}

}
