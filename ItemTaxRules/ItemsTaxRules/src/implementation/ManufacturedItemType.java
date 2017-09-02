package implementation;

import constant.Constants;

public class ManufacturedItemType extends ItemsDetails {

	public ManufacturedItemType(String itemType, String itemName,double itemPrice, int itemQuantity) {
		super(itemType, itemName, itemPrice, itemQuantity);
		// TODO Auto-generated constructor stub
	}

	public double calculateTax() {
		double taxPart=(Constants.MANUFACTURED_TAX_PERCENTAGE/100)*getItemPrice();
		double addedTaxPart=(Constants.ADDED_MANUFACTURED_TAX_PERCENTAGE/100)*taxPart;
		double totalTax=taxPart+addedTaxPart;
		return totalTax;
		// TODO Auto-generated method stub
		
	}

	public void calculateTotalPrice() {
		// TODO Auto-generated method stub
		double totalPrice=(calculateTax()+getItemPrice())*getItemQuantity();
		System.out.print("Total Price: "+totalPrice);
	}

}
