package presentation;

import java.util.HashMap;
import java.util.Scanner;

import constant.Constants;

import validation.CustomExceptionClass;
import implementation.ImportedItemType;
import implementation.ItemsDetails;
import implementation.RawItemType;


public class DisplayAllDetails {

	public static void main(String args[]) throws CustomExceptionClass{
		
		/*try {
			u.inputParser();
		} catch (CustomExceptionClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		HashMap itemHashMapDetails=new HashMap();
		Scanner scanner=new Scanner(System.in);
		String wantToEnterMore=null;
		do{
			itemHashMapDetails=UserInput.inputParser();
			if(itemHashMapDetails.containsKey(Constants.TYPE_OF_ITEM)){
				
				ItemsDetails rid=new RawItemType("raw", itemHashMapDetails.get(Constants.NAME_OF_ITEM).toString(), 
						Double.parseDouble(itemHashMapDetails.get(Constants.PRICE_OF_ITEM).toString()), 5);
				System.out.println("Tax: "+rid.calculateTax());	
				rid.calculateTotalPrice();
			}
			//ItemsDetails id=new ImportedItemType("abc", "", 2.5, 5);
			//id.calculateTotalPrice();
			
			
			System.out.print("Want to Enter more (Y/y) (Press any key to exit): ");
			wantToEnterMore=scanner.nextLine();
			
		}while(wantToEnterMore.equalsIgnoreCase("y"));
		
	
		
		
	}
}
