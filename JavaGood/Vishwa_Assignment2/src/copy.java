import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class copy {
	public static void copying(String dir1,String dir2){
		
	File source = new File(dir1);
	File dest = new File(dir2);
	try {
	    FileUtils.copyDirectory(source, dest);
	} catch (IOException e) {
		Invalid_Path.exc();
	}
	}
}
