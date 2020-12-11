package phase.end.project1;

//This interface is for the business logic of all the methods used in the application
public interface BusinessLogic {

	public void showFileList(String root);
	
	public void searchFile(String root);
	
	public void add();
	
	public void remove(String root) throws FileMismatchException;
}
