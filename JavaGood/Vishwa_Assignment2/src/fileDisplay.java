import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class fileDisplay {
	
	public static void display() {
		
		
		try {
			Scanner scan = new Scanner(System.in);
			   System.out.println("Enter the file content.." );
			   String content = scan.next();
			   
			   
			File file = new File("fileVishwa.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			
			BufferedReader br = null;

			String sCurrentLine;

			br = new BufferedReader(new FileReader("FileStructure.txt"));

		    while ((sCurrentLine = br.readLine()) != null) 
		    {
					System.out.println(sCurrentLine.substring(1));
				
								
		    }
		    br.close();
		    scan.close();
		} 
		    catch (IOException e) {
			// TODO Auto-generated catch block
		    	Invalid_Path.exc();
		}
	}
	


}
