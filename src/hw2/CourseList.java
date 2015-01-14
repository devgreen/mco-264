package hw2;

import hw1.DuplicateDataException;
import hw1.InvalidDataException;
import hw1.NotFoundException;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseList implements Serializable {
	
	private ArrayList<Course> list; 
	
	public CourseList(){
		list = new ArrayList <Course>();
	}
	
	public void addCourse(Course newCourse)throws DuplicateDataException{
		if (list.contains(newCourse)){
			throw new DuplicateDataException();
		}
		else {
			list.add(newCourse);
		}
		
	}
	
	public void addCourse(String courseID, String courseName, Integer numOfCredits, String departmentID) throws InvalidDataException, DuplicateDataException{
		Course course = new Course(courseID, courseName, numOfCredits, departmentID);
		if (list.contains(course)){
			throw new DuplicateDataException();
		}
		else {
			list.add(course);
		}
		
	}
	
	public void remove(String courseID) throws NotFoundException{
		boolean found = false;
		for (Course a : list){
			if (a.getCourseID().equals(courseID)){
				list.remove(a);
				found = true;
				break;
			}
			
		}
		if (found == false){
			throw new NotFoundException();
		}
			
	}
	
	public void modifyCourseName(String courseID, String newName) throws NotFoundException{
		boolean found =false;
		for (Course a : list){
			if (a.getCourseID().equals(courseID)){
				a.setCourseName(newName);
				found = true;
				break;	
			}	
		}
		if (found == false){
			throw new NotFoundException();
		}
		
	}
	
	public void modifyCourseCredits(String courseID, Integer credits) throws NotFoundException{
		boolean found =false;
		for (Course a : list){
			if (a.getCourseID().equals(courseID)){
				a.setNumOfCredits(credits);
				found = true;
				break;	
			}	
		}
		if (found == false){
			throw new NotFoundException();
		}
		
	}
	public void modifyCourseDepartmentCredits(String courseID, String departmentID) throws NotFoundException{
		boolean found =false;
		for (Course a : list){
			if (a.getCourseID().equals(courseID)){
				a.setDepartmentID(departmentID);
				found = true;
				break;	
			}	
		}
		if (found == false){
			throw new NotFoundException();
		}
		
	}
	
	public  ArrayList<Course> getCourses(){
		ArrayList <Course> courses = list;
		return courses;
	}
	
	public String toString(){
		StringBuilder info = new StringBuilder();
		for (Course a : list){
			info.append(a.toString());
			info.append("\n");
			
		}
		return info.toString();
	}

}
