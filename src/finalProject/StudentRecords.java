package finalProject;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentRecords implements Serializable{

	CourseList list;
	StudentList students;

	public StudentRecords() {
		list = new CourseList();
		students = new StudentList();
	}

	public void addStudent(Student student) throws DuplicateDataException {
		students.addStudent(student);
	}
	
	public Student getStudent(Integer id) throws NotFoundException{
		Student student = students.getStudent(id);
		return student;
		
	}

	public void removeStudent(Integer studentID) throws Exception {
		students.remove(studentID);
	}

	public void modifyStudentLastName(Integer studentID, String newLastName) throws NotFoundException {
		students.modifyStudentLastName(studentID, newLastName);
	}

	public void modifyStudentMajor(Integer studentID, String major) throws NotFoundException {
		students.modifyStudentMajor(studentID, major);
	}

	public void modifyStudentAddress(Integer studentID, String street, String city, String state, String zip)
			throws NotFoundException, InvalidDataException {
		students.modifyStudentAddress(studentID, street, city, state, zip);
	}

	public void modifyStudentGPA(Integer studentID, double gpa) throws NotFoundException, InvalidDataException {
		students.modifyStudentGPA(studentID, gpa);
	}

	public void modifyStudentCredits(Integer studentID, int amountOfCredits) throws NotFoundException,
			InvalidDataException {
		students.modifyStudentCredits(studentID, amountOfCredits);
	}

	public void removeCourse(String courseID) throws NotFoundException {
		list.remove(courseID);
	}

	public void addCompletedCourse(Integer studentID, CompletedCourse course) throws NotFoundException,
			DuplicateDataException {
		boolean found = list.findCourse(course);
		if (found) {
			Student student = students.getStudent(studentID);
			student.addCompletedCourse(course);
			//int numCredits = student.getNumCredits();
			student.setNumCredits(student.getNumCredits() + course.getNumOfCredits());

		} else {
			throw new NotFoundException();
		}
	}

	public String getStudentInformation(Integer studentID) {
		return students.toString(studentID);
	}

	public Double getStudentGPA(Integer studentID) throws NotFoundException {
		return students.getGPA(studentID);
	}

	public Integer getTotalStudentCredits(Integer studentID) throws NotFoundException {
		Student student = students.getStudent(studentID);
		return student.getNumCredits();
	}

	public void addCourse(Course course) throws DuplicateDataException {
		list.addCourse(course);
	}

	public void modifyCourseName(String courseID, String newName) throws NotFoundException {
		list.modifyCourseName(courseID, newName);
	}

	public void modifyCourseCredits(String courseID, Integer credits) throws NotFoundException {
		list.modifyCourseCredits(courseID, credits);
	}

	public void modifyCourseDprtmnt(String courseID, String departmentID) throws NotFoundException {
		list.modifyCourseDepartmentCredits(courseID, departmentID);
	}

	public Grade getGrade(Integer id, String courseID) throws NotFoundException {
		Student student = students.getStudent(id);
		LinkedListIterator<CompletedCourse> iter = student.getCourses().getIteratior();
		while (iter.hasNext()) {
			CompletedCourse course = iter.next();
			if (course.getCourseID().equals(courseID)) {
				Grade grade = course.getGrade();
				return grade;
			}
		}
		throw new NotFoundException();

	}

	public ArrayList<Student> getStudentByMajor(String major) {
		ArrayList<Student> majorList = students.studentForSpecificMajor(major);
		return majorList;
	}

	public String toString(Integer id) {
		return students.toString(id);
	}

	public String toString(int caseNum) {
		StringBuilder info = new StringBuilder();
		if (caseNum == 15){
		info.append(list.toString());
		}
		if (caseNum == 2){
		info.append(students.toString());
		}
		return info.toString();
	}

}
