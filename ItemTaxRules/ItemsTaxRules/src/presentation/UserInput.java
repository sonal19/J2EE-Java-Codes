package presentation;


import java.util.HashMap;
import java.util.Scanner;
//import java.util.StringTokenizer;

import validation.CustomExceptionClass;

public class UserInput {
	
	public static String getUserInput() throws CustomExceptionClass{
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Name of Item, Type of Item, Price of Item, Quantity of Item ");
		String userInputString=scanner.nextLine();
		if(userInputString.isEmpty()){
			throw new CustomExceptionClass(constant.ErrorMessages.EMPTY_INPUT);
		}
		return userInputString;
		
	}
	
	public static HashMap inputParser() throws CustomExceptionClass{
		
		HashMap itemHashMapDetails=new HashMap();
		//String userInputString=getUserInput();
		validation.UserInputValidation.inputValidator();
		itemHashMapDetails=validation.UserInputValidation.itemDetailsStorage();
		//Using String tokenizer
		/*StringTokenizer multiTokenizer = new StringTokenizer(userInputString, "-");
		while (multiTokenizer.hasMoreTokens())
		{
		    System.out.println(multiTokenizer.nextToken());
		   
		}*/
		
		return itemHashMapDetails;
		
	}

}
