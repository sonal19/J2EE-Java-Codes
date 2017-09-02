package implementation;

public abstract class ItemsDetails {
	
	private String itemType;
	private String itemName;
	private double itemPrice;
	private int itemQuantity;
	
	public ItemsDetails(String itemType,String itemName,double itemPrice,int itemQuantity){
		this.itemName=itemName;
		this.itemPrice=itemPrice;
		this.itemType=itemType;
		this.itemQuantity=itemQuantity;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public abstract double calculateTax();
	public abstract void calculateTotalPrice();
	
	
	
	
}
