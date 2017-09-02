import java.io.File;
import java.util.Scanner;


public class MyFile {

	public void findFile(String name,File file)
    {
		
        try {
			File[] list = file.listFiles();
			if(list!=null)
			for (File fil : list)
			{
			    if (fil.isDirectory())
			    {
			        findFile(name,fil);
			    }
			    else if (name.equalsIgnoreCase(fil.getName()))
			    {
			        System.out.println("File contains inside the path: "+fil.getParentFile());
			    }
			    else
			    	System.out.println("File not found!!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Invalid_Path.exc();
		}
    }
    
}
