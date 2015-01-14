package randomAccessStudentDataCW;

import java.io.Serializable;

public class StudentIndexRec implements Serializable {
	private Integer studentID;
	private Long fileLocation;
	
	public StudentIndexRec(Integer studentID, Long fileLocation){
		this.studentID = studentID;
		this.fileLocation = fileLocation;
	}

	
	public Integer getStudentID(){
		return studentID;
	}
	
	public Long getFileLocation (){
		return fileLocation;
	}
	
}
