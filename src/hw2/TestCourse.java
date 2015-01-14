package hw2;

import hw1.DuplicateDataException;
import hw1.InvalidDataException;
import hw1.NotFoundException;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestCourse {
	
	public static void main (String [] args){
		CourseList list = new CourseList();
		Scanner keyboard = new Scanner (System.in);
		int choice;
		do{
			
			choice = menu();
			try{
			switch (choice){
			case 1: // add a course
				System.out.println ("What is the course id?");
				String id = keyboard.nextLine();
				System.out.println ("What is the course name?");
				String name = keyboard.nextLine();
				System.out.println ("How many credits for this course?");
				Integer credits = keyboard.nextInt();
				System.out.println ("What is the department id?");
				keyboard.nextLine();
				String depID = keyboard.nextLine();
				Course course = new Course(id, name, credits, depID);
				list.addCourse(course);
				//System.out.println(course.toString());
				break;
				
			case 2: // remove a course
				System.out.println ("what is the course id?");
				String courseID = keyboard.nextLine();
				list.remove(courseID);
				break;
				
			case 3: // modify course name
				System.out.println ("What is the course id?");
				String id1 = keyboard.nextLine();
				System.out.println("what is the new name?");
				String newName = keyboard.nextLine();
				list.modifyCourseName(id1, newName);
				//System.out.println(list.toString());
				break;
				
			case 4: // modify course credits
				System.out.println ("What is the course id?");
				String id2 = keyboard.nextLine();
				System.out.println("what is the new amount of credits?");
				Integer newCredits = keyboard.nextInt();
				list.modifyCourseCredits(id2, newCredits);
				//System.out.println(list.toString());
				break;
				
			case 5: // modify course department
				//keyboard.nextLine();
				System.out.println ("What is the course id?");
				String id3 = keyboard.nextLine();
				System.out.println("what is the new department?");
				String newDepartment = keyboard.nextLine();
				list.modifyCourseDepartmentCredits(id3, newDepartment);
				//System.out.println(list.toString());
				break;
				
			case 6: // display a courses info
				boolean found = false;
				ArrayList <Course> courses = list.getCourses();
				System.out.println ("Whats the courses id?");
				String id4 = keyboard.nextLine();
				for (Course a : courses){
					if (a.getCourseID().equals(id4)){
					System.out.println (a.toString());
					found = true;
					}
				}
				if (found == false){
					System.out.println("Course not found");
					
				}
				break;
				
			case 7: // display all courses
				System.out.println (list.toString());
				break;
				
			case 8: // list all courses of a specific dprtmnt
				boolean found1= false;
				ArrayList <Course> courses1 = list.getCourses();
				System.out.println ("Which department?");
				String depID1 = keyboard.nextLine();
				for (Course a : courses1){
					if (a.getDepartmentID().equals(depID1)){
					System.out.println (a.toString());
					found1 = true;
					}
				}
				if (found1 == false){
					System.out.println("no course for this department");
					
				}
				break;
				
			case 9: // store data
				System.out.println("What is the file name?");
				String fileName = keyboard.nextLine();
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
				output.writeObject(list);
				output.close();
				break;
				
				
			case 10: // retrieve data
				System.out.println("What is the file name?");
				String fileName2 = keyboard.nextLine();
				ObjectInputStream indexFile = new ObjectInputStream(new FileInputStream(fileName2));
				list = (CourseList) indexFile.readObject();  
				indexFile.close();
				break;
				
			
			}
			}
			catch (InvalidDataException e){
				System.out.println ("invalid or missing data please try again");
				
			} catch (DuplicateDataException e) {
				System.out.println ("duplicate data. please try again");
			} catch (NotFoundException e) {
			System.out.println ("course not found. try again");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while (choice !=12);
	}
	
	public static int menu(){
		Scanner keyboard = new Scanner (System.in);
		int choice = 0;
		do{
			System.out.println ("What would you like to do?");
			System.out.println("1. add a course" + "\n2. remove a course" +
			"\n3. modify course name" + "\n4. modify course credits" + "\n5. modify course department" +
					 "\n6. display course information" +
			"\n7. list all courses information" + "\n8. list all courses of a specifc department"+
					 "\n9.Store course data" + "\n10.Retreive course data"+
			"\n12.Exit program");
			choice = keyboard.nextInt();
			
		}while (choice <1 || choice > 12);
		
		return choice;
	}

}
