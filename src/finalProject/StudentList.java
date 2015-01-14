package finalProject;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentList implements Serializable {

	SortedLinkedList<Student> students;

	public StudentList() {
		students = new SortedLinkedList<Student>();
	}

	public void addStudent(Student other) throws DuplicateDataException {
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student student = iter.next();
			if (student.getStudentID().equals(other.getStudentID())){
				throw new DuplicateDataException();
			}
			
		}
		students.insert(other);
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(other.getStudentID())) {
//				throw new DuplicateDataException();
//			}
//		}
//		students.add(other);

	}

	public void addStudent(Integer studentID, String firstName, String lastName, Character gender, String major)
			throws InvalidDataException, DuplicateDataException {

		Student student = new Student(studentID, firstName, lastName, gender, major);
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(student.getStudentID())){
				throw new DuplicateDataException();
			}
			
		}
		students.insert(student);

	}

	public void remove(Integer studentID) throws Exception {
		// boolean found = false;
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student student = iter.next();
			if (student.getStudentID().equals(studentID)){
				students.remove(student);
				return;
			}
			
		}
		
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				students.remove(i);
//				return;
//
//			}
//		}

		throw new NotFoundException();

	}

	public void modifyStudentLastName(Integer studentID, String newLastName) throws NotFoundException {
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				next.setLastName(newLastName);
				return;
			}
			
		}
//		
//		
//		
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				student = students.get(i);
//				student.setLastName(newLastName);
//				return;
//			}
//
//		}

		throw new NotFoundException();

	}

	public void modifyStudentAddress(Integer studentID, String street, String city, String state, String zip)
			throws NotFoundException, InvalidDataException {
		if (street.equals(null) || city.equals(null) || state.equals(null) || zip.equals(null)) {
			throw new InvalidDataException();

		}
		
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				next.setAddress(street);
				next.setCity(city);
				next.setState(state);
				next.setZip(zip);
				return;
				
			}
			
		}
		
		
//		Student student;
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				student = students.get(i);
//				student.setAddress(street);
//				student.setCity(city);
//				student.setState(state);
//				student.setZip(zip);
//				return;
//			}
//		}

		throw new NotFoundException();

	}

	public void modifyStudentGPA(Integer studentID, double gpa) throws NotFoundException, InvalidDataException {
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				next.setGpa(gpa);
				return;
			}
			
		}
		
		
//		
//		Student student = null;
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				student = students.get(i);
//				student.setGpa(gpa);
//				return;
//			}
//		}

		throw new NotFoundException();

	}

	public void modifyStudentMajor(Integer studentID, String major) throws NotFoundException {
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				next.setMajor(major);
				return;
			}
			
		}
		
//		
//		Student student = null;
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				student = students.get(i);
//				student.setMajor(major);
//				return;
//			}
//		}

		throw new NotFoundException();

	}

	public void modifyStudentCredits(Integer studentID, Integer amountOfCredits) throws NotFoundException,
			InvalidDataException {
		
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				next.setNumCredits(amountOfCredits);
				return;
			}
			
		}
//		Student student = null;
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				student = students.get(i);
//				student.setNumCredits(amountOfCredits);
//				return;
//			}
//		}

		throw new NotFoundException();

	}

	public int getTotalCredits(Integer studentID) throws NotFoundException {
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				return next.getNumCredits();
				
			}
			
		}
//		
//		
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				return students.get(i).getNumCredits();
//			}
//		}
		throw new NotFoundException();
	}

	public void addCompletedCourse(Integer studentID, CompletedCourse course) throws DuplicateDataException,
			NotFoundException {
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				next.addCompletedCourse(course);
				return;
			}
			
		}
		
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				students.get(i).addCompletedCourse(course);
//				return;
//			}
//
//		}

		throw new NotFoundException();

	}

	public double getGPA(Integer studentID) throws NotFoundException {
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				return next.getGPA2(next);
				
			}
			
		}
		

		throw new NotFoundException();

	}

	public Student getStudent(Integer studentID) throws NotFoundException {
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				
				return next;
			}
			
		}
		
//		Student student;
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				student = students.get(i);
//				return student;
//			}
//
//		}
		throw new NotFoundException();

	}

	public ArrayList<Student> studentForSpecificMajor(String major) {
		ArrayList<Student> majorList = new ArrayList<Student>();
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getMajor().equals(major)){
				majorList.add(next);
				
			}
			
		}
//		
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getMajor().equals(major)) {
//				majorList.add(students.get(i));
//			}
//
//		}
		return majorList;

	}

	public String toString() {
		StringBuilder info = new StringBuilder();
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			info.append(iter.next().toString());
			info.append("\n");
			
		}
		
//		for (int i = 0; i < students.size(); i++) {
//			info.append(students.get(i).toString());
//			info.append("\n");
//		}
		return info.toString();
	}

	public String toString(Integer studentID) {
		StringBuilder info = new StringBuilder();
		
		LinkedListIterator <Student> iter = students.iterator();
		while (iter.hasNext()){
			Student next = iter.next();
			if (next.getStudentID().equals(studentID)){
				info.append(next.toString());
				break;
			}
			
		}
		
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStudentID().equals(studentID)) {
//				info.append(students.get(i).toString());
//				break;
//			}
//		}
		return info.toString();

	}

}
