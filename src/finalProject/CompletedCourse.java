package finalProject;

import java.io.Serializable;


public class CompletedCourse extends Course implements Serializable, Comparable<CompletedCourse> {

	Semester semesterCompleted;
	Integer yearCompleted;
	Grade grade;
	int studentID;

	public CompletedCourse(String courseID, String courseName, Integer numOfCredits, String departmentID, Semester semester, Integer year, Grade grade, int id)
			throws InvalidDataException {
		super(courseID, courseName, numOfCredits, departmentID);
		this.semesterCompleted = semester;
		this.yearCompleted = year;
		this.grade = grade;
		this.studentID = id;
	}

	public CompletedCourse(Course course, Semester semester,Integer year, Grade grade, int id) throws InvalidDataException {
		super(course.getCourseID(), course.getCourseName(), course.getNumOfCredits(), course.getDepartmentID());
		this.semesterCompleted = semester;
		this.yearCompleted = year;
		this.grade = grade;
		this.studentID = id;

	}
	
	public int compareTo(CompletedCourse course){
		return this.getCourseID().compareTo(course.getCourseID());
	}
	
	public Semester getSemesterCompleted() {
		return semesterCompleted;
	}

	public Integer getYearCompleted() {
		return yearCompleted;
	}

	public Grade getGrade() {
		return grade;
	}

	public int getStudentID() {
		return studentID;
	}
	
	public String toString(){
		StringBuilder info = new StringBuilder();
		info.append(super.toString());
		return info.toString();
		
	}
	
	
	

}
