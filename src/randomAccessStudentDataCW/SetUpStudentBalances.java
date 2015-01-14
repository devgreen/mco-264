package randomAccessStudentDataCW;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SetUpStudentBalances {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null,"specify the randomaccessdatafile");
		JFileChooser fileChooser = new JFileChooser();
		 fileChooser.showOpenDialog(null);
		String dataFileName = fileChooser.getSelectedFile().getPath();
		
		ManageStudentBalances studentBalances = new ManageStudentBalances(10, dataFileName);
		
		try{ //enter data into the system
		    studentBalances.addStudentRecord(1, 1000.00);
		    studentBalances.addStudentRecord(2, 2000.00);
		    studentBalances.addStudentRecord(3,3000.00);
		}
		catch (Exception e){
			if (e instanceof FileNotFoundException ){
				System.out.println("Data files was not found");
			}
			else 
				if (e instanceof DuplicateDataException ){
					System.out.println("student data was entered already in file");
				}
				else
					if (e instanceof IOException){
						System.out.println("problem reading data from file - contact IT");
					}
		}
		
		JOptionPane.showMessageDialog(null,"indicate index file name");
		fileChooser.showOpenDialog(null);
		String indexFileName = fileChooser.getSelectedFile().getPath();
		
		try{
		studentBalances.shutdown(indexFileName);
		}
		catch(Exception e){
			if (e instanceof FileNotFoundException){
				System.out.println("cant store index , file not found");
				System.exit(1);
			}
			else{
				if (e instanceof IOException){
					System.out.println("problem storing data in index file");
					System.exit(1);
				}
			}
		}
		
		System.out.println("have a nice day!");
		
		
		

	}

}
