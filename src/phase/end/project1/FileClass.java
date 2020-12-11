package phase.end.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//This class is used for file manipulation
public class FileClass implements BusinessLogic{
	
	//This method is used to show all files in the directory chosen
	public void showFileList(String root) {
		Scanner scan = new Scanner (System.in);
		
		//An array of strings to store the path names
		String [] pathnames;
			File f = new File(root);
		pathnames = f.list();
		
		//This for loop iterates through the names of the paths given
		for (String pathname : pathnames) {
			System.out.println(pathname);
		}
	}
	
	//This method is used to search for the file chosen by the user
	public void searchFile(String root) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter the file name you wish to search: ");
		String fileName = scan.nextLine();
		File directory = new File(root);
		
		//This is used to create the object of the MyFileName class i created
		MyFilenameFilter filter= new MyFilenameFilter(fileName);
		
		//This function will then filter out the filename the user wants
		String[] flist = directory.list(filter);
		
		//This function will return a not found message of the file doesnt exis
		if(flist == null) {
			System.out.println("Empty directory or directory does not exists.");
		}
		
		//This function will loop through and display the file if it does exist
		else {
			for (int i = 0; i < flist.length; i++) {
				System.out.println(flist[i]+" found");
			}
		}
	}

	//This is used to add the file by which the user wants to add
	public void add() {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("please enter the name of the file you would like to add");
		String fileName = scan.nextLine();
		
		//This try catch block will capture the file name and create the file based on users input
		try {
			FileOutputStream fout= new FileOutputStream(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//This method will remove a given filename specified by the user
	public void remove(String root) throws FileMismatchException {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the name of the file you would like to delete");
		String fileName = scan.nextLine();
		File file = new File(root+"\\"+fileName);
		if(file.exists()) {
			boolean check = file.delete();
			System.out.println("File " +fileName+ " deleted " +check);
		}
		else {
			throw new FileMismatchException("File was not found");
		}
		//This if statement is used to say if the file can be detected then it will deleted
	}
	
}
