package randomAccessStudentDataCW;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StudentsIndex implements Serializable {
	private StudentIndexRec[] index;
	private int numStudents;

	/**
	 * set up an index array for the first time
	 * 
	 * @param initialqty
	 */
	public StudentsIndex(int initialqty) {
		index = new StudentIndexRec[initialqty];

	}

	/**
	 * 
	 * @param studentID
	 * @param fileLocation
	 * @throws Exception
	 *             if duplicate or no more room in the index array
	 */
	public void addStudentToIndex(Integer studentID, Long fileLocation) throws Exception {
		StudentIndexRec student = new StudentIndexRec(studentID, fileLocation);
		index[numStudents] = student;
		numStudents++;

	}

	/**
	 * 
	 * @param studentID
	 * @return Long - location of record in the data file
	 * @throws NotFoundException
	 */

	public Long findStudentLocation(Integer studentID) throws NotFoundException {
		for (int i = 0; i < index.length; i++) {
			if (studentID == index[i].getStudentID()) {
				return index[i].getFileLocation();
			}

		}
		return null;
	}

	/**
	 * 
	 * @param studentID
	 * @return element number of the studentindexrec in the array
	 * @throws NotFoundException
	 */
	private int findStudent(Integer studentID) throws NotFoundException {
		for (int i = 0; i < index.length; i++) {
			if (studentID == index[i].getStudentID()) {
				return index[i].getStudentID();
			}

		}
		return -1;

	}

	/**
	 * 
	 * @param studentID
	 * @return true if studentid appears in the index array
	 */

	public boolean hasStudent(Integer studentID) {
		for (int i = 0; i < index.length; i++) {
			if (studentID == index[i].getStudentID()) {
				return true;
			}

		}
		return false;

	}

}
