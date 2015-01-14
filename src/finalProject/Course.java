package finalProject;


import java.io.Serializable;

public class Course implements Serializable{
	private String courseID;
	private String courseName;
	private Integer numOfCredits;
	private String departmentID;
	
	public Course(String courseID, String courseName, Integer numOfCredits, String departmentID) throws InvalidDataException{
		if(courseID.equals(null) || courseName.equals(null) ||numOfCredits.equals(null)||departmentID.equals(null)){
			throw new InvalidDataException ();
		}
		
		this.courseID = courseID;
		this.courseName = courseName;
		this.numOfCredits = numOfCredits;
		this.departmentID = departmentID;
	}

	public String getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getNumOfCredits() {
		return numOfCredits;
	}

	public void setNumOfCredits(Integer numOfCredits) {
		this.numOfCredits = numOfCredits;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	
	public int compareTo(Course other) {
		return this.courseID.compareTo(other.courseID); 
	}
	
	public boolean equals(Object other){
		if ( other instanceof Course){
			return this.courseID.equals(((Course) other).getCourseID());
			
		}
		else {
			return false;
		}
	}
	
	public String toString(){
		StringBuilder info = new StringBuilder();
		info.append("Course ID: ");
		info.append(courseID);
		info.append(" Course Name: ");
		info.append(courseName);
		info.append(" Number of credits: ");
		info.append(numOfCredits);
		info.append(" Depatrment: ");
		info.append(departmentID);
		
		return info.toString();
	}

}
