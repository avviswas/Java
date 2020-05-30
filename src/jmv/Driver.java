package jmv;
import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Comparator;

//Created Driver class
public class Driver {

	public static void main(String[] args) {
		
	List<Invoice1> invoices = new ArrayList<Invoice1>();  //Created ArrayList
	
	//Adding properties(Part Number,Part Description,Quantity,Price) in ArrayList 
	invoices.add(new Invoice1(83, "Electric sander", 7,57.98));
	invoices.add(new Invoice1(24, "Power Saw", 18,99.99));	
	invoices.add(new Invoice1(7, "Sledge Hammer", 11, 21.50));	
	invoices.add(new Invoice1(77, "Hammer  ", 76, 11.99));	
	invoices.add(new Invoice1(39, "Lawn mower", 3, 79.50));
	invoices.add(new Invoice1(68, "Screwdriver", 106, 6.99));
	invoices.add(new Invoice1(56, "Jig Saw  ", 21, 11.00));
	invoices.add(new Invoice1(3, "Wrench  ", 34, 7.50));
	
	//Print original invoice
	System.out.println("Original Invoices:");
	Invoice1.printHeader();	
	invoices
		.stream()
		.forEach( (invoice)->System.out.println(invoice));
	
	//Comparator to sort the invoice by part description
	Comparator<Invoice1> descriptionComparator = (aDescription, bDescription) ->
	aDescription.getPartDescription().compareTo(bDescription.getPartDescription());
	
	// sort the Invoice objects by PartDescription , then display the results
	System.out.println("\nAfter Sorting by description:");	
	Invoice1.printHeader();
	invoices
		.stream()
		.sorted(descriptionComparator)
		.forEach( (invoice) ->System.out.println(invoice));
	
	//compares by price
	Comparator<Invoice1> priceComparator = (aPrice, bPrice) ->
	new Double(aPrice.getPrice()).compareTo(new Double(bPrice.getPrice()));
	
	System.out.println("\nAfter Sorting by price:");	
	Invoice1.printHeader();
	invoices
	.stream()
	.sorted(priceComparator)
	.forEach( (invoice) ->System.out.println(invoice));
		
	//Comparator that compares by quantity
		Comparator<Invoice1> quantityComparator = (a, b) ->
		new Integer(a.getQuantity()).compareTo(new Integer(b.getQuantity()));
	
	//Map each Invoice to its PartDescription and Quantity and then sorts the
	//results by Quantity then display the results
	System.out.println("\nMapping invoice to part Description and quantity then sorting results by quantity: \n" +
	String.format("%-30s %-8s","Part Description","Quantity"));
	invoices
		.stream()		
		.sorted(quantityComparator)
		.map(invoice ->String.format("%-30s %-8s", invoice.getPartDescription() , invoice.getQuantity()))
		.forEach( (invoice)->System.out.println(invoice));
		
	//comparator that compares values	
	Comparator<Invoice1> totalValueComparator = (a, b) ->
	new Double(a.getInvoiceValue()).compareTo(new Double(b.getInvoiceValue()));
	
	// map each Invoice to its PartDescription and the value of the
	//Invoice ( Quantity * Price ). Order the results by Invoice value.
	System.out.println("\nMapping each invoice to part description and value, the sorting by total value: \n" +
	String.format("%-30s %-8s","Part Description","Invoice Value"));
	invoices
	.stream()
	.sorted(totalValueComparator)
	.map(invoice ->String.format("%-30s %-8s", invoice.getPartDescription() , invoice.getInvoiceValue()))
	.forEach( (invoice)->System.out.println(invoice));
	
	//Predicate to set range of values
	Predicate<Invoice1> range = invoice -> (invoice.getInvoiceValue() >= 200 && invoice.getInvoiceValue() <= 500);
	
	//Printing invoices whose total value is between $200 and $500
	System.out.println("\nSelecting only invoices between $200 to $500 ordered by invoice value: \n" +
	String.format("%-30s %-8s","Part Description","Invoice Value"));
	invoices
	.stream()
	.filter(range)
	.sorted(totalValueComparator)
	.map(invoice ->String.format("%-30s %-8s", invoice.getPartDescription() , invoice.getInvoiceValue()))
	.forEach( (invoice)->System.out.println(invoice));	
	
	}

} //end of class
