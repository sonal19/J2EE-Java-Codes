import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class MyDir {

	/**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public static void listFilesAndFolders(String directoryName){
    	File folder = new File(directoryName);
    	File[] listOfFiles = folder.listFiles();

    	
    	    try {
				for (int i = 0; i < listOfFiles.length; i++) {
				  if (listOfFiles[i].isFile()) {
				    System.out.println("File -> " + listOfFiles[i].getName());
				  } else if (listOfFiles[i].isDirectory()) {
				    System.out.println("Directory -> " + listOfFiles[i].getName());
				  }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Path p = Paths.get(directoryName);
				String file = p.getFileName().toString();		
				 System.out.println("It is a File and only filename is -> " + file);
			}
    }
    public static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("Directory :" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					System.out.println("     File:" + file.getCanonicalPath());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
}
