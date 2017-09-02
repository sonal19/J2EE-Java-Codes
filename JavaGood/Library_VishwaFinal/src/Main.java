import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
	
	private static int max_numberOfDays = 0;
	private static int max_numberOfBooks = 0;
	
	
	private static List<Student> stu_iiitd=new ArrayList<Student>();
	private static List<Student> stu_dtu=new ArrayList<Student>();
	private static List<Student> stu_other=new ArrayList<Student>();
	
	private static List<Books> book_iiitd=new ArrayList<Books>();
	
	private static List<Books> book_dtu=new ArrayList<Books>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		
		String ch="";
		do{
/////////////////////////////STUDENT DETAILS///////////////////////////////////////////
		
			for(i=0;i<10;i++){
			Student stu=new Student();
			stu.setRoll(i);
			stu.setCardNumber("IIITD"+i);
			stu.setClg("IIITD");
			if(i<4)stu.setClassType("UG");
			else if(i<8) stu.setClassType("PG");
			else stu.setClassType("Phd");
			stu.setIssuedBooks_iiitd(0);
			stu.setIssuedBooks_dtu(0);
			stu_iiitd.add(stu);
		}
		
		for(i=0;i<10;i++){
			Student stu1=new Student();
			stu1.setRoll(i);
			stu1.setCardNumber("DTU"+i);
			stu1.setClg("DTU");
			if(i<4)stu1.setClassType("UG");
			else if(i<8) stu1.setClassType("PG");
			else stu1.setClassType("Phd");
			stu1.setIssuedBooks_iiitd(0);
			stu1.setIssuedBooks_dtu(0);
			stu_dtu.add(stu1);
		}
		
		for(i=0;i<10;i++){
			Student stu2=new Student();
			stu2.setRoll(i);
			stu2.setCardNumber("other"+i);
			stu2.setClg("other");
			if(i<4)stu2.setClassType("UG");
			else if(i<8) stu2.setClassType("PG");
			else stu2.setClassType("Phd");
			stu2.setIssuedBooks_iiitd(0);
			stu2.setIssuedBooks_dtu(0);
			stu_other.add(stu2);
		}
////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////BOOKS DETAILS////////////////////////////////////////////////////
		
		
		 Random randomGenerator = new Random();
		 
		for(i=0;i<10;i++){
			Books bk=new Books();
			bk.setBookName("BookIIITD#"+i);
			bk.setBookId(i);
			bk.setNumber(randomGenerator.nextInt(10)+1);
			
			book_iiitd.add(bk);
		}
		
		for(i=0;i<10;i++){
			Books bk1=new Books();
			bk1.setBookName("BookDTU#"+i);
			bk1.setBookId(i);
			bk1.setNumber(randomGenerator.nextInt(10)+1);
			
			book_dtu.add(bk1);
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////show Books and books number//////////////////////////////////////////////////////
		System.out.println("IIITD Books");
		for(i=0;i<10;i++){
			System.out.println(book_iiitd.get(i).getBookId()+"  "+book_iiitd.get(i).getBookName()+"  "+book_iiitd.get(i).getNumber());
		}
		System.out.println("DTU Books");
		for(i=0;i<10;i++){
			System.out.println(book_dtu.get(i).getBookId()+"  "+book_dtu.get(i).getBookName()+"  "+book_dtu.get(i).getNumber());
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\n\n1. Enter DTU Library \n"+"2. Enter IIITD Library");
		Scanner cn = new Scanner(System.in);
		int num= cn.nextInt();
		if(num==1)
		dtuLib();
		else
		iiitdLib();
		
		
		System.out.println("Want to Stay Library (Y/N): ");
		Scanner crn = new Scanner(System.in);
		ch= crn.nextLine();
		
		}while(ch.equals("Y") || ch.equals("y"));
		
		
	}//end of void main

	public static void dtuLib(){
		String clgname="",classtype="";
		try{
				System.out.println("Enter Cardnum number: ");
				Scanner cn = new Scanner(System.in);
				String cardnum= cn.nextLine();
				
				System.out.println("Enter Book Name: ");
				Scanner bn = new Scanner(System.in);
				String bname= bn.nextLine();	
				
				//System.out.println("Enter Clg Name: ");
				//Scanner clgn = new Scanner(System.in);
				//String clgname= clgn.nextLine();	
				
				int c_index=0;	
				for(int j=0;j<10;j++){
					if(stu_iiitd.get(j).getCardNumber().equals(cardnum))
					{
						c_index=j;
						clgname=stu_iiitd.get(j).getClg();
						classtype=stu_iiitd.get(j).getClassType();
					}
					
				}
				
				if(clgname.equals("IIITD")){
					max_numberOfBooks = 3;
					max_numberOfDays = 5;
				
					
					
					int b_index=0;	
					for(int j=0;j<10;j++){
						if(book_dtu.get(j).getBookName().equals(bname))
						b_index=j;	
					}
					
					if(stu_iiitd.get(c_index).getIssuedBooks_dtu()<=max_numberOfBooks){
					
						stu_iiitd.get(c_index).setIssuedBooks_dtu(stu_iiitd.get(c_index).getIssuedBooks_dtu()+1);
						book_dtu.get(b_index).setNumber((book_dtu.get(b_index)).getNumber()-1);
					
					}
				
				}
				else if(clgname.equals("DTU")){
					if(classtype.equals("UG")){
						max_numberOfBooks = 4;
						max_numberOfDays = 10;
						
						
						
						int b_index=0;	
						for(int j=0;j<10;j++){
							if(book_dtu.get(j).getBookName().equals(bname))
							b_index=j;	
						}
						
						if(stu_dtu.get(c_index).getIssuedBooks_dtu()<=max_numberOfBooks){
						
							stu_dtu.get(c_index).setIssuedBooks_dtu(stu_dtu.get(c_index).getIssuedBooks_dtu()+1);
							book_dtu.get(b_index).setNumber((book_dtu.get(b_index)).getNumber()-1);
						
						}
					}
					else if(classtype.equals("PG")){
							max_numberOfBooks = 3;
							max_numberOfDays = 10;
							
							int b_index=0;	
							for(int j=0;j<10;j++){
								if(book_dtu.get(j).getBookName().equals(bname))
								b_index=j;	
							}
							
							if(stu_dtu.get(c_index).getIssuedBooks_dtu()<=max_numberOfBooks){
							
								stu_dtu.get(c_index).setIssuedBooks_dtu(stu_dtu.get(c_index).getIssuedBooks_dtu()+1);
								book_dtu.get(b_index).setNumber((book_dtu.get(b_index)).getNumber()-1);
							
							}
						}
					else {
						
							max_numberOfBooks = 2;
							max_numberOfDays = 10;
							
							
							
							int b_index=0;	
							for(int j=0;j<10;j++){
								if(book_dtu.get(j).getBookName().equals(bname))
								b_index=j;	
							}
							
							if(stu_dtu.get(c_index).getIssuedBooks_dtu()<=max_numberOfBooks){
							
								stu_dtu.get(c_index).setIssuedBooks_dtu(stu_dtu.get(c_index).getIssuedBooks_dtu()+1);
								book_dtu.get(b_index).setNumber((book_dtu.get(b_index)).getNumber()-1);
							
							}
					}
					
					
				}
				else{
					
					max_numberOfBooks=1;
					max_numberOfDays = 3;
					
					
					
					int b_index=0;	
					for(int j=0;j<10;j++){
						if(book_dtu.get(j).getBookName().equals(bname))
						b_index=j;	
					}
					
					if(stu_other.get(c_index).getIssuedBooks_dtu()<=max_numberOfBooks){
					
						stu_other.get(c_index).setIssuedBooks_dtu(stu_other.get(c_index).getIssuedBooks_dtu()+1);
						book_dtu.get(b_index).setNumber((book_dtu.get(b_index)).getNumber()-1);
					
					}
				}
				
				System.out.println("DTU Books");
				for(int i=0;i<10;i++){
					System.out.println(book_dtu.get(i).getBookId()+"  "+book_dtu.get(i).getBookName()+"  "+book_dtu.get(i).getNumber());
				}
				System.out.println("IIITD Books");
				for(int i=0;i<10;i++){
					System.out.println(book_iiitd.get(i).getBookId()+"  "+book_iiitd.get(i).getBookName()+"  "+book_iiitd.get(i).getNumber());
				}
				
				System.out.println("Student IIITD Details"); 
				for (int i=0 ; i<10; i++){
					System.out.println( "dtu books-->"+stu_iiitd.get(i).getIssuedBooks_dtu());
					
					
				}
				for (int i=0 ; i<10; i++){
					
					System.out.println( "iiitd books-->"+stu_iiitd.get(i).getIssuedBooks_iiitd());
					
				}
				System.out.println("\n\nStudent DTU Details"); 
				for (int i=0 ; i<10; i++){
					System.out.println("dtu books-->"+ stu_dtu.get(i).getIssuedBooks_dtu() );
					
					
				}
				for (int i=0 ; i<10; i++){
					
					System.out.println( "iiitd books-->"+stu_dtu.get(i).getIssuedBooks_iiitd());
					
				}
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
		
	public static void iiitdLib(){
		String clgname="",classtype="";
		try{
				System.out.println("Enter Cardnum number: ");
				Scanner cn = new Scanner(System.in);
				String cardnum= cn.nextLine();
				
				System.out.println("Enter Book Name: ");
				Scanner bn = new Scanner(System.in);
				String bname= bn.nextLine();		
				
				int c_index=0;	
				for(int j=0;j<10;j++){
					if(stu_dtu.get(j).getCardNumber().equals(cardnum))
					{
						c_index=j;
						clgname=stu_dtu.get(j).getClg();
						classtype=stu_dtu.get(j).getClassType();
					}
					
				}
				
				if(clgname.equals("DTU")){
					max_numberOfBooks = 2;
					max_numberOfDays = 4;
				
					
					
					int b_index=0;	
					for(int j=0;j<10;j++){
						if(book_iiitd.get(j).getBookName().equals(bname))
						b_index=j;	
					}
					
					if(stu_dtu.get(c_index).getIssuedBooks_iiitd()<=max_numberOfBooks){
					
						stu_dtu.get(c_index).setIssuedBooks_iiitd(stu_dtu.get(c_index).getIssuedBooks_iiitd()+1);
						book_iiitd.get(b_index).setNumber((book_iiitd.get(b_index)).getNumber()-1);
					
					}
				
				}
				else if(clgname.equals("IIITD")){
					if(classtype.equals("UG")){
						max_numberOfBooks = 5;
						max_numberOfDays = 12;
						
												
						int b_index=0;	
						for(int j=0;j<10;j++){
							if(book_iiitd.get(j).getBookName().equals(bname))
							b_index=j;	
						}
						
						if(stu_iiitd.get(c_index).getIssuedBooks_iiitd()<=max_numberOfBooks){
						
							stu_iiitd.get(c_index).setIssuedBooks_iiitd(stu_iiitd.get(c_index).getIssuedBooks_iiitd()+1);
							book_iiitd.get(b_index).setNumber((book_iiitd.get(b_index)).getNumber()-1);
						
						}
					}
					else if(classtype.equals("PG")){
							max_numberOfBooks = 3;
							max_numberOfDays = 12;
							
							
							int b_index=0;	
							for(int j=0;j<10;j++){
								if(book_iiitd.get(j).getBookName().equals(bname))
								b_index=j;	
							}
							
							if(stu_iiitd.get(c_index).getIssuedBooks_iiitd()<=max_numberOfBooks){
							
								stu_iiitd.get(c_index).setIssuedBooks_iiitd(stu_iiitd.get(c_index).getIssuedBooks_iiitd()+1);
								book_iiitd.get(b_index).setNumber((book_iiitd.get(b_index)).getNumber()-1);
							
							}
						}
					else {
						
							max_numberOfBooks = 2;
							max_numberOfDays = 12;
							
							
							int b_index=0;	
							for(int j=0;j<10;j++){
								if(book_iiitd.get(j).getBookName().equals(bname))
								b_index=j;	
							}
							
							if(stu_iiitd.get(c_index).getIssuedBooks_iiitd()<=max_numberOfBooks){
							
								stu_iiitd.get(c_index).setIssuedBooks_iiitd(stu_iiitd.get(c_index).getIssuedBooks_iiitd()+1);
								book_iiitd.get(b_index).setNumber((book_iiitd.get(b_index)).getNumber()-1);
							
							}
							
					}
					
					
				}
				
				System.out.println("DTU Books");
				for(int i=0;i<10;i++){
					System.out.println(book_dtu.get(i).getBookId()+"  "+book_dtu.get(i).getBookName()+"  "+book_dtu.get(i).getNumber());
				}
				System.out.println("IIITD Books");
				for(int i=0;i<10;i++){
					System.out.println(book_iiitd.get(i).getBookId()+"  "+book_iiitd.get(i).getBookName()+"  "+book_iiitd.get(i).getNumber());
				}
				

				System.out.println("Student IIITD Details"); 
				for (int i=0 ; i<10; i++){
					System.out.println( "dtu books-->"+stu_iiitd.get(i).getIssuedBooks_dtu());
					
					
				}
				for (int i=0 ; i<10; i++){
					
					System.out.println( "iiitd books-->"+stu_iiitd.get(i).getIssuedBooks_iiitd());
					
				}
				System.out.println("\n\nStudent DTU Details"); 
				for (int i=0 ; i<10; i++){
					System.out.println("dtu books-->"+ stu_dtu.get(i).getIssuedBooks_dtu() );
					
					
				}
				for (int i=0 ; i<10; i++){
					
					System.out.println( "iiitd books-->"+stu_dtu.get(i).getIssuedBooks_iiitd());
					
				}
		}
		catch(Exception e){
			System.out.print(e);
		}
	}
	
}//end of main class
