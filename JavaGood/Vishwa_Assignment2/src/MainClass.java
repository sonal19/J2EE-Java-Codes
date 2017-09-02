import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFile mf=new MyFile();
		MyDir md=new MyDir();
		Scanner scan = new Scanner(System.in);
		FileCreator fc=new FileCreator();
		fileDisplay fd= new fileDisplay();
		System.out.println("1.Choose to show directroy tree structure" );
		System.out.println("2.choose to search the file.. " );
		System.out.println("3.Write/Display from file " );
		System.out.println("4.Create a new file " );
		System.out.println("5.copy " );
		System.out.println("Enter the choice " );
		
       int i = scan.nextInt();
		
       try {
		switch(i){
		   case 2: MyFile ff = new MyFile();
		  // Scanner scan = new Scanner(System.in);
		   System.out.println("Enter the file to be searched.. " );
		   String name = scan.next();
		   System.out.println("Enter the directory where to search\n(You can choose the base directory , it will automatically go \ninside all directories and find the file needed but, \nit may take time) ");
		   String directory = scan.next();
		   ff.findFile(name,new File(directory));
		   break;
		   
		   case 1: System.out.println("Enter the directory Path: ");
		Scanner sc=new Scanner(System.in);  
		String path=sc.next();  
		
		MyDir.listFilesAndFolders(path);
		
		System.out.println("\n////////////////////////////////////////////");
		System.out.println("\nDirectory Structure of Current Directory : \n");
		File currentDir = new File("."); // current directory
			MyDir.displayDirectoryContents(currentDir);
			System.out.println("\n////////////////////////////////////////////");
			
			sc.close();
			
			break;
			
		   case 4:FileCreator.fc();
		   break;
		   
		   case 3: fileDisplay.display();
		   break;
		   
		   case 5:
			   System.out.println("Enter the source and destination Directory.. " );
		       String dir1 = scan.next();
		       String dir2 = scan.next();
		       copy.copying(dir1, dir2);
		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		Invalid_Path.exc();
	}
		//File file = new File("FileStructure.txt");
		
		// if file doesnt exists, then create it
		//if (!file.exists()) {
		//	file.createNewFile();
		//}

		//FileWriter fw = new FileWriter(file.getAbsoluteFile());
		//BufferedWriter bw = new BufferedWriter(fw);
		//bw.write(content);
		//bw.close();
	}

}
