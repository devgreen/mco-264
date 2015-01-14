package finalProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UseStudentRecords {

	public static void main(String[] args) {

		StudentRecords records = new StudentRecords();
		Scanner keyboard = new Scanner(System.in);

		int choice;
		do {
			choice = menu();
			try {
				switch (choice) {
				case 1: // add a student
					System.out.println("please put in student id");
					Integer id = keyboard.nextInt();
					System.out.println("please put in students first name");
					keyboard.nextLine();
					String firstName = keyboard.nextLine();
					System.out.println("please put in students last name");
					String lastName = keyboard.nextLine();
					System.out.println("please put in student gender ( M or F)");
					Character gender = keyboard.next().charAt(0);
					System.out.println("please put in student major");
					keyboard.nextLine();
					String major = keyboard.nextLine();
					Student student = new Student(id, firstName, lastName, gender, major);
					records.addStudent(student);
					break;

				case 2: // view all students
					System.out.println(records.toString(2));
					break;

				case 3: // view a specific student
					System.out.println("what is the students id?");
					Integer studentID7 = keyboard.nextInt();
					System.out.println(records.toString(studentID7));
					break;

				case 4: // remove a student
					System.out.println("what is the students id?");
					Integer studentID = keyboard.nextInt();
					records.removeStudent(studentID);
					break;

				case 5: // modify last name
					System.out.println("what is the students id?");
					Integer studentID2 = keyboard.nextInt();
					System.out.println("What is the new last name?");
					keyboard.nextLine();
					String newLastName = keyboard.nextLine();
					records.modifyStudentLastName(studentID2, newLastName);
					break;

				case 6: // modify address
					System.out.println("what is the students id?");
					Integer studentID3 = keyboard.nextInt();
					System.out.println("What is the new street");
					keyboard.nextLine();
					String street = keyboard.nextLine();

					System.out.println("What is the new city");
					String city = keyboard.nextLine();

					System.out.println("What is the new state");
					String state = keyboard.nextLine();

					System.out.println("What is the new zip");
					String zip = keyboard.nextLine();
					records.modifyStudentAddress(studentID3, street, city, state, zip);
					break;

				case 7: // modify major
					System.out.println("what is the students id?");
					Integer studentID4 = keyboard.nextInt();
					System.out.println("What is the new major?");
					keyboard.nextLine();
					String newMajor = keyboard.nextLine();
					records.modifyStudentMajor(studentID4, newMajor);
					break;

				case 8: // modify gpa
					System.out.println("what is the students id?");
					Integer studentID5 = keyboard.nextInt();
					System.out.println("What is the new gpa?");
					double gpa = keyboard.nextDouble();
					records.modifyStudentGPA(studentID5, gpa);
					break;

				case 9: // get specific students gpa
					System.out.println("what is the students id?");
					Integer studentID8 = keyboard.nextInt();
					System.out.println(records.getStudentGPA(studentID8));
					break;

				case 10: // get a specific students number of credits
					System.out.println("what is the students id?");
					Integer studentID9 = keyboard.nextInt();
					System.out.println(records.getTotalStudentCredits(studentID9));
					break;

				case 11: // modify number of credits
					System.out.println("what is the students id?");
					Integer studentID6 = keyboard.nextInt();
					System.out.println("What is the new number of credits ?");
					Integer newCredits = keyboard.nextInt();
					records.modifyStudentCredits(studentID6, newCredits);
					break;

				case 12: // list all students of a specific major
					System.out.println("what major are you looking for?");
					String majorLookingFor = keyboard.nextLine();
					ArrayList<Student> majorLooking = records.getStudentByMajor(majorLookingFor);
					System.out.println(majorLooking.toString());

					break;

				case 13:// add a course
					System.out.println("What is the course id?");
					String courseid = keyboard.nextLine();
					System.out.println("What is the course name?");
					String name = keyboard.nextLine();
					System.out.println("How many credits for this course?");
					Integer credits = keyboard.nextInt();
					System.out.println("What is the department id?");
					keyboard.nextLine();
					String depID = keyboard.nextLine();
					Course course = new Course(courseid, name, credits, depID);
					records.addCourse(course);
					break;

				case 14: // view all courses
					System.out.println(records.toString(15));
					break;

				case 15: // remove a course
					System.out.println("what is the course id?");
					String courseID = keyboard.nextLine();
					records.removeCourse(courseID);
					break;

				case 16: // modify course name
					System.out.println("What is the course id?");
					String courseID2 = keyboard.nextLine();
					System.out.println("what is the new name?");
					String newName = keyboard.nextLine();
					records.modifyCourseName(courseID2, newName);
					break;

				case 17: // modify course credits
					System.out.println("What is the course id?");
					String courseID3 = keyboard.nextLine();

					System.out.println("what is the new amount of credits?");

					Integer newCredits2 = keyboard.nextInt();
					records.modifyCourseCredits(courseID3, newCredits2);
					break;

				case 18: // modify course dprtmnt
					System.out.println("What is the course id?");
					String courseID4 = keyboard.nextLine();
					System.out.println("what is the new department?");
					String newDepartment = keyboard.nextLine();
					records.modifyCourseDprtmnt(courseID4, newDepartment);
					break;

				case 19: // add a cpmpleted course
					System.out.println("What is the course id?");
					String crid = keyboard.next();
					System.out.println("What is the course name?");
					keyboard.nextLine();
					String cname = keyboard.nextLine();

					System.out.println("How many credits for this course?");
					Integer ccredits = keyboard.nextInt();
					System.out.println("What is the department id?");
					keyboard.nextLine();
					String cdepID = keyboard.nextLine();
					System.out.println("which semester was it completed?");
					String semester = keyboard.next();
					Semester completed = Semester.valueOf(semester);
					System.out.println("What was the year completed");
					int year = keyboard.nextInt();
					System.out.println("What grade was recieved?");
					String grade = keyboard.next();
					Grade recieved = Grade.valueOf(grade);
					System.out.println("what is the student id?");
					Integer studentid = keyboard.nextInt();
					CompletedCourse courseComp = new CompletedCourse(crid, cname, ccredits, cdepID, completed, year,
							recieved, studentid);
					records.addCompletedCourse(studentid, courseComp);
					break;
				case 20: // view all completed courses for a student
					System.out.println("What is the student id?");
					Integer studentid2 = keyboard.nextInt();
					Student getStudent = records.getStudent(studentid2);
					PriorityQueue<CompletedCourse> compCourses = getStudent.getCourses();
					LinkedListIterator<CompletedCourse> iter = compCourses.getIteratior();
					while (iter.hasNext()) {
						CompletedCourse course1 = iter.next();
						System.out.println(course1.toString());

					}
					break;
				case 21: // get grade for a specific course for a specific
							// student
					System.out.println("enter student id");
					Integer studID = keyboard.nextInt();
					System.out.println("enter course id");
					String courseID5 = keyboard.next();
					System.out.println(records.getGrade(studID, courseID5));
					break;
				case 22: // store
					System.out.println("What is the file name?");
					String fileName = keyboard.nextLine();
					ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
					output.writeObject(records);
					output.close();
					break;

				case 23: // retrieve
					System.out.println("What is the file name?");
					String fileName2 = keyboard.nextLine();
					ObjectInputStream indexFile = new ObjectInputStream(new FileInputStream(fileName2));
					records = (StudentRecords) indexFile.readObject();
					indexFile.close();
					break;

				}
			} catch (InvalidDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicateDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (choice != 24);

	}

	public static int menu() {

		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {

			System.out.println("What would you like to do?");
			System.out.println("1. Add a student");
			System.out.println("2. view all students");
			System.out.println("3. View a specific student");
			System.out.println("4. Remove a student");
			System.out.println("5. Modify stuent last name");
			System.out.println("6. Modify student address");
			System.out.println("7. Modify student major");
			System.out.println("8. Modify student gpa");
			System.out.println("9. Get GPA for a student");
			System.out.println("10. Get number of credits for a student");
			System.out.println("11. Modify number of credits for a student");
			System.out.println("12. List students for a specific major");

			System.out.println("13. Add a course");
			System.out.println("14. View all courses");
			System.out.println("15. Remove a course");
			System.out.println("16. Modify course name");
			System.out.println("17. Modify course credits");
			System.out.println("18. Modify course department");

			System.out.println("19. Add a completed course to a student record");
			System.out.println("20. View all completed courses for a student");
			System.out.println("21. Get the grade for a specific course for a specific student");
			System.out.println("22. Store all information");
			System.out.println("23. Retreive all information");
			System.out.println("24. Exit program");

			choice = scanner.nextInt();

		} while (choice < 1 || choice > 24);

		// scanner.close();
		return choice;

	}

}
