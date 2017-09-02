package implementation;

import constant.Constants;

public class RawItemType extends ItemsDetails {

	
	
	public RawItemType(String itemType, String itemName, double itemPrice,int itemQuantity) {
		super(itemType, itemName, itemPrice, itemQuantity);
		// TODO Auto-generated constructor stub
	}

	public double calculateTax() {
		// TODO Auto-generated method stub
		double totalTax=(Constants.RAW_TAX_PERCENTAGE/100)*getItemPrice();
		return totalTax;
	}

	public void calculateTotalPrice() {
		// TODO Auto-generated method stub
		double totalPrice=(calculateTax()+getItemPrice())*getItemQuantity();
		System.out.println("Total Price: "+totalPrice);
		//System.out.println(getItemName()+"---"+getItemPrice());
		
	}
	
	

}
