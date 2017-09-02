import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class FileCreator {
	
	@SuppressWarnings("resource")
	public static void fc() {
		// TODO Auto-generated method stub
		
try {
			
			BufferedReader br = null;

			String sCurrentLine;

			br = new BufferedReader(new FileReader("FileStructure.txt"));

		    while ((sCurrentLine = br.readLine()) != null) 
		    {
					System.out.println(sCurrentLine.substring(1));
				
					try {
						File targetFile = new File(sCurrentLine.substring(1));
						File parent = targetFile.getParentFile();
						//if(sCurrentLine.substring(sCurrentLine.length()-5, sCurrentLine.length()-1).equals(".txt"))
						targetFile.createNewFile();
						if(!parent.exists() && !parent.mkdirs())
						{
						    throw new IllegalStateException("Couldn't create dir: " + parent);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						Invalid_Path.exc();
					}
				
			}
				
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
