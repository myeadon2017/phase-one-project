package phase.end.project1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

	//This method is used to show the menu to the user
	public void showMenu() {
		System.out.println("----------------------------------");
		System.out.println("Welcome to Company Lockers Pvt. Ltd.");
		System.out.println("Developer: Matthew Yeadon");
		System.out.println("----------------------------------");
	}
	
	//This method is used to show the choices and have the user select what they desire
	public int showChoices() {
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("----------------------------------");
		System.out.println("Please enter 1 to show all files");
		System.out.println("Please enter 2 to delete a file");
		System.out.println("Please enter 3 to add a file");
		System.out.println("Please enter 4 to search for a file");
		System.out.println("Please enter 5 to exit application");
		System.out.println("----------------------------------");
		
		choice = Integer.parseInt(scan.nextLine());
		return choice;
	}
	
	//This is the beginning of my program
	public static void main(String[] args) throws FileMismatchException {
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		int selection;
		menu.showMenu();
		
		//This line will prompt the user to type in what directory they wish to use
		System.out.println("Please enter your root file directory");
		System.out.println("ex:C:\\Users\\matthew.yeadon\\eclipse-workspace\\phase.end.project1 ");
		String root = scan.nextLine();
		File file = new File(root);
		if(file.exists()) {
			boolean check = file.exists();
			System.out.println("File " +root+ " Is a valid path " +check);
			FileClass myFile = new FileClass();
			myFile.showFileList(root);
		}
		else {
			throw new FileMismatchException("Root directory was not found");
		}
		selection = menu.showChoices();
		System.out.println(selection);
		
		//This while loop is used to iterate though the menu options based on the users selection
				//If you wish to exit the program then the user would press 5
		while(selection != 5) {
		if (selection == 1) {
			FileClass myFile = new FileClass();
			myFile.showFileList(root);
			menu.showMenu();
			selection = menu.showChoices();
			System.out.println(selection);
		}
		else if(selection == 2) {
			FileClass myFile = new FileClass();
			myFile.remove(root);
			menu.showMenu();
			selection = menu.showChoices();
			System.out.println(selection);
		}
	
		else if (selection == 3) {
			FileClass myFile = new FileClass();
			myFile.add();
			menu.showMenu();
			selection = menu.showChoices();
			System.out.println(selection);
		}
		else if (selection == 4) {
			FileClass myFile = new FileClass();
			myFile.searchFile(root);
			menu.showMenu();
			selection = menu.showChoices();
			System.out.println(selection);
		}
		else {
			System.out.println("Not a valid selection");
			menu.showMenu();
			selection = menu.showChoices();
			System.out.println(selection);
		}
	
	}
		//This option will be displayed if the program exits via entering 5
		System.out.println("Thank you for using Company Lockers Pvt. Ltd.");
	}
}

