package implementation;

import constant.Constants;

public class ImportedItemType extends ItemsDetails {
	
	private double surcharge;

	public ImportedItemType(String itemType, String itemName, double itemPrice,int itemQuantity) {
		super(itemType, itemName, itemPrice, itemQuantity);
		// TODO Auto-generated constructor stub
	}

	public double calculateTax() {
		double taxPart=(Constants.IMPORTED_TAX_PERCENTAGE/100)*getItemPrice();
		if((taxPart+getItemPrice())<=100)
			surcharge=5;
		else if((taxPart+getItemPrice())>100 && (taxPart+getItemPrice())<=200)
			surcharge=10;
		else 
			surcharge=(5/100)*(taxPart+getItemPrice());
		
		double totalTax=taxPart;
		return totalTax;		// TODO Auto-generated method stub
		
	}

	public void calculateTotalPrice() {
		// TODO Auto-generated method stub
		double totalPrice=((calculateTax()+getItemPrice())*getItemQuantity())+surcharge;
		System.out.print("Total Price: "+totalPrice);
	}

}
