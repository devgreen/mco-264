package books2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CollegeText implements Comparable<CollegeText>{
	private String isbn; // must always be 13 characters
	private String courseID; //always 6 characters
	private Double cost;
	
	public CollegeText(String isbn, String courseID, Double cost) throws InvalidDataException{
		//verify that the isbn and courseid are of the correct length
		//throw invaliddataexception if the data is missing or not of correct length
		
		if (isbn == null || courseID==null || cost == null){
			throw new InvalidDataException();
			
		}
		else {
			if (isbn.length()!= 13 || courseID.length()!=6){
				throw new InvalidDataException();
				
			}
			else {
				//set up the instance 
				this.isbn = isbn;
				this.courseID = courseID;
				this.cost = cost;
			}
		}
		
		
		
	}
	
	public CollegeText(String randomFileName, Long filePosition) throws FileNotFoundException, IOException{
		//read data from a randomaccessfile
		RandomAccessFile random = new RandomAccessFile (new File (randomFileName), "rw");
		random.seek(filePosition);
		this.isbn = random.readUTF();
		this.courseID = random.readUTF();
		this.cost = random.readDouble();
		random.close();
		
		
		
		
	}
	public Long writetoFile(String randomFileName)throws FileNotFoundException, IOException{
		RandomAccessFile random = new RandomAccessFile (new File (randomFileName), "rw");
		Long filePosition = random.length();
		random.seek(random.length());
		//for debugging
		System.out.println ("writing at location" + filePosition);
		random.writeUTF(this.isbn);
		random.writeUTF(this.courseID);
		random.writeDouble(cost);
		random.close();
		return filePosition;
		
		
	}
	public void rewriteToFile(String randomFileName, Long fileLocation)throws FileNotFoundException, IOException{
		RandomAccessFile random = new RandomAccessFile (new File (randomFileName), "rw");
		random.seek(fileLocation);
		random.writeUTF(this.isbn);
		random.writeUTF(this.courseID);
		random.writeDouble(this.cost);
		random.close();
		
		
	}
	public Double getCost (){
		return cost;
		
	}
	public void setCost(Double cost){
		this.cost = cost;
	}
	
	public String getISBN(){
		return isbn;
	}
	
	public String getCourseID(){
		return courseID;
		
	}
	
	//base the comparison on isbn, college textx will be sorted based on isbn
	
	public int compareTo(CollegeText otherText){
		return isbn.compareTo(otherText.getISBN());
		
	}
	
	//return data of a particular instance of CollegeText
	public String toString(){
		StringBuffer info = new StringBuffer();
		info.append(isbn);
		info.append(" ");
		info.append(courseID);
		info.append(" ");
		info.append(cost);
		info.append(" ");
		
		return info.toString();
		
	}

}
