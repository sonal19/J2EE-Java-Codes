package validation;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import constant.Constants;
import presentation.UserInput;

public class UserInputValidation {
	
	private static String userInputString;
	private static Pattern patternSearchHyphen; 
	private static Pattern patternSearchspace; 
	private static Matcher matcherHyphen;
	private static Matcher matcherspace;
	private static HashMap inputValueHashMap;
	
	public static void inputValidator() throws CustomExceptionClass{
		inputValueHashMap=new HashMap();
		//ArrayList inputValues=new ArrayList();
		userInputString=UserInput.getUserInput()+" ";
		//Pattern patternSearch = Pattern.compile("(-)|( )");  
		patternSearchHyphen = Pattern.compile("-"); 
		patternSearchspace = Pattern.compile(" "); 
		matcherHyphen=patternSearchHyphen.matcher(userInputString);
		matcherspace=patternSearchspace.matcher(userInputString);
        //Matcher matcher = patternSearch.matcher(userInputString); 
        boolean typeFound = false; 
        int firstCount=0;
        String checkString = null;
        while (matcherHyphen.find() && matcherspace.find(matcherHyphen.start())) {  
        	
            /*System.out.println("I found the text  starting at index "+  
            		matcherHyphen.start()+" and ending at index "+matcherspace.end());  
        	*/
        		
	        checkString=userInputString.substring(matcherHyphen.end(), matcherspace.start());
	        if(firstCount==0){
	        	
		       	if(!(checkString.equalsIgnoreCase(Constants.NAME_OF_ITEM))){
		       		throw new CustomExceptionClass(constant.ErrorMessages.ENTER_NAME);
		       	}
		       	else
		       	{
		       		setKeyValuePairs(Constants.NAME_OF_ITEM);
		       		/*inputValues.add(userInputString.substring(matcherspace.start(),
		       				matcherspace.start()+(userInputString.substring(
		       						matcherspace.end()).indexOf(" "))).trim());*/
		       		firstCount++;
		       		continue;
		       	}
	        }
        	
        	if((checkString.equalsIgnoreCase(Constants.TYPE_OF_ITEM))){
        		setKeyValuePairs(Constants.TYPE_OF_ITEM);
        		typeFound=true;
        		continue;
        		
        	}
        	
        	if((checkString.equalsIgnoreCase(Constants.PRICE_OF_ITEM))){
        		setKeyValuePairs(Constants.PRICE_OF_ITEM);
        		continue;
        		
        	}
        	
        	if((checkString.equalsIgnoreCase(Constants.QUANTITY_OF_ITEM))){
        		//System.out.println(matcherspace.start()+"-------"+matcherHyphen.start()+"======"+userInputString.substring(matcherspace.end()).indexOf(" "));
        		setKeyValuePairs(Constants.QUANTITY_OF_ITEM);
        		continue;
        		
        	}
           
        }  
        if(!typeFound)  
        	throw new CustomExceptionClass(constant.ErrorMessages.ENTER_TYPE);
           
       
	}
	
	public static HashMap itemDetailsStorage(){
		
		return inputValueHashMap;
		
	}
	
	public static void setKeyValuePairs(String key){
		inputValueHashMap.put(key, userInputString.substring(matcherspace.start(),
   				matcherspace.start()+(userInputString.substring(
   						matcherspace.end()).indexOf(" "))+1).trim());
	}

}
