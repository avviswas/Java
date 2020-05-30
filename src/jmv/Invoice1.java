package jmv;

//Created Invoice Class
public class Invoice1 {
	private int partNumber;
	private String partDescription;
	private int quantity;
	private double price;

	//Created Constructor
	public Invoice1() {
		partNumber = 0;
		partDescription ="";
		quantity = 0;
		price = 0.00;
	}
	
	public Invoice1(int partNumber, String partDescription, int quantity, double price) {
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.price = price;
	}
	//Set PartNumber
	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	//Set PartDescription
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	//Set Quantity
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	//set Price
	public void setPrice(int price) {
		this.price = price;
	}
	//Getting PartNumber
	public int getPartNumber() {
		return partNumber;
	}
	//Getting PartDescription
	public String getPartDescription() {
		return partDescription;
	}
	//Getting Quantity
	public int getQuantity() {
		return quantity;
	}
	//Getting Price
	public double getPrice() {
		return price;
	}
	//Getting InvoiceValue
	public double getInvoiceValue(){
		return quantity * Math.round(price * 100.0) / 100.0;
	}
	//Printing Header
	public static void printHeader(){
	System.out.println(String.format("%-12s %-30s %-10s %-10s","Part Number","Part Description","Quantity","Price"));
	}
	
	public String toString() {
    return String.format("%-12s %-30s %-10s %-10s",getPartNumber(),getPartDescription(),getQuantity(),getPrice() );
	}	
	
}//End of Class
