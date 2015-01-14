package hw1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;



public class TestStudent {
	
	
	
	public static void main (String [] args){
	  StudentList list = new StudentList(10);
	 int numStudents = 0;
	 Scanner keyboard = new Scanner (System.in);
	
		int choice;
		do {
			choice = menu();
			try{
			switch (choice){
			case 1: //add a student
				
				System.out.println("please put in student id");
				Integer id = keyboard.nextInt();
				//keyboard.nextLine();
				System.out.println("please put in students first name");
				keyboard.nextLine();
				String firstName = keyboard.nextLine();
				//keyboard.nextLine();
				System.out.println("please put in students last name");
				String lastName = keyboard.nextLine();
				//keyboard.nextLine();
				System.out.println("please put in student gender ( M or F)");
				Character gender = keyboard.next().charAt(0);
				System.out.println("please put in student major");
				keyboard.nextLine();
				String major = keyboard.nextLine();
				//keyboard.nextLine();
				list.addStudent(id, firstName, lastName,gender, major);
				numStudents++;
				//System.out.println(list.toString());
				break;
				
			case 2: //remove a student
				
				System.out.println ("what is the students id?");
				Integer studentID = keyboard.nextInt();
					list.remove(studentID);
				
				break;
			case 3://modify last name
				System.out.println ("what is the students id?");
				Integer studentID2 = keyboard.nextInt();
				System.out.println ("What is the new last name?");
				keyboard.nextLine();
				String newLastName = keyboard.nextLine();
				
				
				list.modifyStudentLastName(studentID2, newLastName);
				
				
				break;
			case 4://modify student address
				System.out.println ("what is the students id?");
				Integer studentID3 = keyboard.nextInt();
				System.out.println ("What is the new street");
				keyboard.nextLine();
				String street = keyboard.nextLine();
				
				System.out.println ("What is the new city");
				String city = keyboard.nextLine();
				
				System.out.println ("What is the new state");
				String state = keyboard.nextLine();
				
				System.out.println ("What is the new zip");
				String zip = keyboard.nextLine();
				
				list.modifyStudentAddress(studentID3, street, city, state, zip);
				//System.out.println (list.toString());
				
				break;
			case 5: //modify student major
				System.out.println ("what is the students id?");
				Integer studentID4 = keyboard.nextInt();
				System.out.println ("What is the new major?");
				keyboard.nextLine();
				String newMajor = keyboard.nextLine();
				
				
				list.modifyStudentMajor(studentID4, newMajor);
				//System.out.println (list.toString());
				break;
				
			case 6: //modify student gpa
				System.out.println ("what is the students id?");
				Integer studentID5 = keyboard.nextInt();
				System.out.println ("What is the new gpa?");
				double gpa = keyboard.nextDouble();
				
				
				list.modifyStudentGPA(studentID5, gpa);
				//System.out.println (list.toString());
				break;
				
			case 7: //modify student credits
				System.out.println ("what is the students id?");
				Integer studentID6 = keyboard.nextInt();
				System.out.println ("What is the new number of credits ?");
				Integer newCredits = keyboard.nextInt();
				list.modifyStudentCredits(studentID6, newCredits);
				//System.out.println (list.toString());
				break;
				
			case 8://display student info
				Student [] student1 = list.getStudentList();
				System.out.println ("what is the students id?");
				Integer studentID7 = keyboard.nextInt();
				for (int i= 0; i< student1.length; i++){
					if (student1[i].getStudentID().equals(studentID7)){
						System.out.println (student1[i].toString());
						
					}
					
				}
				break;
				
			case 9: //list all students info
				System.out.println (list.toString());
				break;
				
			case 10: // list students of a specific major
				Student [] student = list.getStudentList();
				System.out.println ("what major are you looking for?");
				String majorLookingFor = keyboard.nextLine();
				
				for (int i= 0; i< student.length; i++){
					if (student[i].getMajor().equals(majorLookingFor)){
						System.out.println (student[i].toString());
						
					}
					
				}
				break;
				
			case 11: // list students with a min num of credits
				Student [] student2 = list.getStudentList();
				System.out.println ("how many credits?");
				Integer credits = keyboard.nextInt();
				
				for (int i= 0; i< student2.length; i++){
					if (student2[i].getNumCredits() >= credits){
						System.out.println (student2[i].toString());
						
					}
					
				}
				break;
				
		case 12: // store students data
				System.out.println("What is the file name?");
				String fileName = keyboard.nextLine();
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
				output.writeObject(list);
				output.close();
				break;
				
			case 13://read in student data
				System.out.println("What is the file name?");
				String fileName2 = keyboard.nextLine();
				ObjectInputStream indexFile = new ObjectInputStream(new FileInputStream(fileName2));
				list = (StudentList) indexFile.readObject();  //reads in entire index and restructures it in RAM
				indexFile.close();
				break;
				
					
				}
				
				
			
				
				
				
			}	catch(InvalidDataException e){
				System.out.println ("Invalid data please try again.");
				
				
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println ("No more room to add students. please choose another option");
				
			} catch (DuplicateDataException e) {
				System.out.println ("Duplicate data please try again");
			
			} catch (NotFoundException e) {
				System.out.println ("Student not found. please try again");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}while (choice != 14);
			}
		

	
		
	
	public static int menu(){
		Scanner keyboard = new Scanner (System.in);
		int choice = 0;
		do{
			System.out.println ("What would you like to do?");
			System.out.println("1. add a student" + "\n2. remove a student" +
			"\n3. modify student last name" + "\n4. modify student address" + "\n5. modify student major" +
					"\n6. modify student gpa" + "\n7. modify student credits" + "\n8. display student information" +
			"\n9. list all students information" + "\n10.list all students of  a specifc major"+
					"\n11.list students with a specific number of credits"+ "\n12.Store student data" + "\n13.Retreive student data"+
			"\n14.Exit program");
			choice = keyboard.nextInt();
			
		}while (choice <1 || choice > 14);
		
		return choice;
	}
	


}
