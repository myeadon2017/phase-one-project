package phase.end.project1;

import java.io.File;
import java.io.FilenameFilter;

//This calls will be used for the FilenameFilter implementation
public class MyFilenameFilter implements FilenameFilter {

	//This declaration is where the file will have a string for what file the user wishes to search
	String initials;
	
	//This is the method that gets called when executing in the FileClass.java
	public MyFilenameFilter(String initials) {
		this.initials = initials;
	}
	//This is an inherited abstract method needed with the implementation of FilenameFilte
	public boolean accept(File dir, String name) {
		return name.startsWith(initials);
	}
}
