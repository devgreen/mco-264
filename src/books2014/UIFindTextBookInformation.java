package books2014;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UIFindTextBookInformation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step a. get the index file name
		//get file name
		JFileChooser fileChooser = new JFileChooser();
		JOptionPane.showMessageDialog(null,  "select random access file");
		fileChooser.showOpenDialog(null);
		String randomFileName = fileChooser .getSelectedFile().getPath();
		
		JOptionPane.showMessageDialog(null, "select index file name");
		fileChooser.showOpenDialog(null);
		String indexFileName = fileChooser.getSelectedFile().getPath();
		
		//System.out.println (randomFileName + " " + indexFileName);
		try{
		ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(indexFileName));
		CollegeTextBooks index = (CollegeTextBooks) inStream.readObject();
		System.out.println ("index file was read in succesfully");
		System.out.println("enter an isbn #");
		Scanner keyboard = new Scanner (System.in);
		String isbn = keyboard.next();
		Long location = index.getLocation(isbn);
		CollegeText text = new CollegeText(randomFileName, location);
		System.out.println (text.toString());
		
		}
		catch (FileNotFoundException notFound){
			System.out.println ("file not found. exiting");
		}
		catch (IOException io){
			System.out.println ("io exception exiting application");
			
		}
		catch (ClassNotFoundException ex){
			System.out.println ("class inconsistency exiting application");
		}
		catch (NotFoundException notFound){
			System.out.println ("not found exception");
			
		}
		

	}

}
