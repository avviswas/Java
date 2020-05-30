package jmv;
import java.util.Scanner;

//Declared FairTax class
public class FairTax {
	 public static void main(String args[]){  
		final double FAIR_TAX_RATE=0.23;  //declare constant FAIR_TAX_RATE variable
		
		//declare variables
    	double taxable_amount,pay_fairtax;  
    	double income,housing,food,clothing,transportation,education,medical,vacation;
    	
    	//The Scanner class is used to get user input, and it is found in the java.util package.
    	Scanner in=new Scanner(System.in);  //Create a Scanner object
    	
    	
    	System.out.println("Please enter your income");
    	income=in.nextDouble();  //Read user input as Income
    	
    	System.out.println("Please enter housing expenses");
    	housing=in.nextDouble(); //Read user input as Housing Expenses
    	
    	System.out.println("Please enter food expenses");
    	food=in.nextDouble(); //Read user input as Food Expenses
    	
    	System.out.println("Please enter clothing expenses");
    	clothing=in.nextDouble(); //Read user input as Clothing Expenses
    	
    	System.out.println("Please enter transportaion expenses");
    	transportation=in.nextDouble(); //Read user input as Transportation Expenses
    	
    	System.out.println("Please enter education expenses");
    	education=in.nextDouble();  //Read User input as Education Expenses
    	
    	System.out.println("Please enter medical expenses");
    	medical=in.nextDouble(); //Read user input as Medical Expenses
    	
    	System.out.println("Please enter vacation expenses");
    	vacation=in.nextDouble(); //Read user input as vacation Expenses
    	
       //calculating taxable income=total income-(housing+food+clothing+transportation+
    	                                         //education+medical+vacation)
    	taxable_amount=income-(housing+food+clothing+transportation+education+medical+vacation);
    	
    	//calculate fair tax
    	pay_fairtax=taxable_amount*FAIR_TAX_RATE;
    	
    	System.out.println("Estimated Fair tax that person would pay :" + pay_fairtax);
    	
	 }
}  //End of Fair Tax class
