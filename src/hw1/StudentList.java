package hw1;

import java.io.Serializable;

public class StudentList implements Serializable{
	
	Student students[];
	int numStudents;
	
	public StudentList(int total){
		students = new Student[total];
		numStudents = 0;
		
	}
	
	public void addStudent(Student other)throws DuplicateDataException, ArrayIndexOutOfBoundsException{
		for (int i = 0; i<numStudents; i++){
			if (students[i].getStudentID().equals(other.getStudentID())){
				throw new DuplicateDataException();
			}
		}
		if (numStudents < students.length){
		students[numStudents] = other;
		numStudents++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		
	}
	public void addStudent(Integer studentID, String firstName, String lastName, Character gender, String major) throws ArrayIndexOutOfBoundsException ,InvalidDataException, DuplicateDataException{
		if (numStudents > students.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		Student student = new Student (studentID, firstName, lastName, gender, major);
		for (int i = 0; i<numStudents; i++){
			if (students[i].getStudentID().equals(studentID)){
				throw new DuplicateDataException();
			}
		}
		
		students[numStudents] = student;
		numStudents++;
		
		
		
		
	}
	
	public void remove(Integer studentID)throws NotFoundException{
		boolean found = false;
		for (int i = 0; i<numStudents; i++){
			if (students[i].getStudentID().equals(studentID) && i < numStudents-1 ){
				students[i] = students[numStudents-1];
				numStudents--;
				found = true;
				break;
				
			}
			else if (students[i].getStudentID().equals(studentID)){
				numStudents--;
				break;
				
			}
			
		}
		if (found == false){
			throw new NotFoundException();
		}
		
	}
	
	public void modifyStudentLastName(Integer studentID,/*String currentLastName,*/ String newLastName)throws NotFoundException{
		Student student = null;
		for (int i =0; i<numStudents; i++){
			if (students[i].getStudentID().equals(studentID)){
				student = students[i];	
				break;
				}
			
			
		}
		if (student != null){
			student.setLastName(newLastName);
		}
		else {
			throw new NotFoundException();
		}
		
		
			
		
		
	}
	public void modifyStudentAddress(Integer studentID, String street, String city, String state, String zip) throws NotFoundException, InvalidDataException{
		if (street.equals(null) || city.equals(null) || state.equals(null) || zip.equals(null)){
			throw new InvalidDataException();
			
		}
		Student student = null;
		for (int i =0; i<numStudents; i++){
			if (students[i].getStudentID().equals(studentID)){
				student = students[i];	
				
				break;
				}
		}
		if (student != null){
			student.setAddress(street);
			student.setCity(city);
			student.setState(state);
			student.setZip(zip);
		}
		else {
			throw new NotFoundException();
		}
		
	}
	public void modifyStudentGPA(Integer studentID, double gpa) throws NotFoundException, InvalidDataException{
		Student student = null;
		for (int i =0; i<numStudents; i++){
			if (students[i].getStudentID().equals(studentID)){
				student = students[i];	
				break;
				}
		}
		if (student != null){
			student.setGpa(gpa);
		}
		else {
			throw new NotFoundException();
		}
		
	}
	public void modifyStudentMajor(Integer studentID, String major) throws NotFoundException{
		Student student = null;
		for (int i =0; i<numStudents; i++){
			if (students[i].getStudentID().equals(studentID)){
				student = students[i];	
				break;
				}
		}
		if (student != null){
			student.setMajor(major);
		}
		else {
			throw new NotFoundException();
		}
		
	}
	public void modifyStudentCredits(Integer studentID, Integer amountOfCredits) throws NotFoundException, InvalidDataException{
		Student student = null;
		for (int i =0; i<numStudents; i++){
			if (students[i].getStudentID().equals(studentID)){
				
				student = students[i]; 
				break;
				}
		}
		if (student !=null){
			student.setNumCredits(amountOfCredits);
		}
		else {
			throw new NotFoundException();
		}
		
		
	}
	
	public Student [] getStudentList(){
		Student [] getList = new Student[numStudents];
		for (int i = 0; i < numStudents; i++){
			getList[i] = students[i];
			
			
		}
		return getList;
	}

	
	public String toString(){
		StringBuilder info = new StringBuilder();
		for (int i =0; i< numStudents; i++){
			info.append(students[i].toString());
			info.append("\n");
		}
		return info.toString();
	}

	
}
