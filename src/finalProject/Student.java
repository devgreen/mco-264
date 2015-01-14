package finalProject;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Student implements Serializable, Comparable<Student> {
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
	private PriorityQueue<CompletedCourse> courses;

	public Student(Integer studentID, String firstName, String lastName, Character gender, String major)
			throws InvalidDataException {
		if (studentID == null || firstName == null || lastName == null || gender == null || major == null) {
			throw new InvalidDataException();
		}
		if (gender != 'M' && gender != 'F' && gender != 'f' && gender != 'm') {
			throw new InvalidDataException();

		}
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.major = major;
		numCredits = 0;
		gpa = 0.0;
		courses = new PriorityQueue<CompletedCourse>(new YearComparetor());

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getStudentID() {
		return studentID;
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

	public void setGpa(double gpa) throws InvalidDataException {

		if (gpa > 4.0 || gpa < 0.0) {
			throw new InvalidDataException();
		} else {
			this.gpa = gpa;
		}

	}

	public PriorityQueue<CompletedCourse> getCourses() {
		return courses;
	}

	public int compareTo(Student other) {
		return this.studentID.compareTo(other.studentID);
	}

	public boolean equals(Object other) {
		if (other instanceof Student) {
			return this.studentID.equals(((Student) other).getStudentID());
		} else {
			return false;
		}
	}

	public void addCompletedCourse(CompletedCourse course) throws DuplicateDataException {
		courses.enqueue(course);

	}

	public double getGPA2(Student student) {
		LinkedListIterator<CompletedCourse> iter = student.getCourses().getIteratior();
		CompletedCourse next;
		int numCredits = 0;
		int pointValue = 0;
		int total = 0;
		while (iter.hasNext()) {
			next = iter.next();
			numCredits = next.getNumOfCredits();
			pointValue = next.getGrade().getNumGrade();
			total += numCredits * pointValue;
		}

		double gpa = total / student.getNumCredits();
		return gpa;

	}

	public String toString() {
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
		if (address != null) {
			info.append(" Address: ");
			info.append(address);
			info.append(" ");
			info.append(city);
			info.append(" ");
			info.append(state);
			info.append(" ");
			info.append(zip);

		}
		
			info.append(" Number of credits: ");
			info.append(numCredits);
			info.append(" GPA: ");
			info.append(gpa);

		
		LinkedListIterator<CompletedCourse> iter = courses.getIteratior();
		if (iter.hasNext()) {
			CompletedCourse c = iter.next();
			info.append(c.toString());
		}

		return info.toString();
	}

}
