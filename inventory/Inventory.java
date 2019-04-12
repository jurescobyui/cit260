import java.util.*;
import java.io.*;
public class Inventory {

	public static void main(String[] args) {
		
		// Displays the main menu 
		displayMenu();  // call to method displayMenu()
	
		
	}// end void main
	
	/**************************
	 * This the menu Display
	 * ***********************/
	public static void displayMenu() {
		clrscr();
		System.out.println("\t\t\t\t\tWelcome to Simple Inventory Program ");
		System.out.println("\t\t\t\t\t\tPresented by Group 4\n\n\n\n\n\n");
		System.out.println("What do you want to do?  1 - Add Product    2 - Search Product   3 - Edit Product      4 - Delete Product  5 - Quit");
		Scanner input = new Scanner(System.in);
		
		
		// filter input selection here
		try {
			int menu = input.nextInt();
			switch (menu) {
			case 1:
				//System.out.println("You want to Add Product");
				
				addProduct();
				waitInput(null, null);
				displayMenu();
				break;
			case 2:
				System.out.println("You want to Search for a product");
				waitInput(null, null);
				displayMenu();
				break;
			case 3:
				System.out.println("You want to Edit Product");
				waitInput(null, null);
				displayMenu();
				break;
			case 4:
				System.out.println("You want to Delete a Product");
				waitInput(null, null);
				displayMenu();
				break;
			case 5:
				System.out.println("Quiting program...");
				break;
			default :
				System.out.println("Please Enter 1 to 5 only.");
				waitInput(null,null);
				displayMenu();
				break;
			}
			
				
			}
			catch(Exception e){
			System.out.println("Please Enter 1 to 5 only.");
			waitInput(null,null);
			displayMenu();
			
			
		}
		
	}// end of displayMenu 
	
	// addProduct Method
	private static void addProduct() {
		Scanner input = new Scanner(System.in);
		boolean continueInput =true;
		System.out.print("Enter Product name: ");
		String name= input.nextLine();
		do {
			try {
				System.out.print("Enter price: ");
				double price = input.nextDouble();
				int id=getLastProductID();
				System.out.println("You Entered: " + name + " and " + price);
				addProductToFile(id,name,price);
				continueInput=false;
			}
			catch(Exception e) {
				System.out.println("Please Enter a double value.");
				input.nextLine();
							
			}
		}
		while(continueInput);
		
		
		
		
		
		
		
	}

	private static void addProductToFile(int id, String name, double price) {
		String strID=Integer.toString(id);
		String strPrice=Double.toString(price);
		try {
			FileWriter myWriter = new FileWriter("products.txt",true);
			myWriter.write(strID + ", " + name + ", " + strPrice + "\r\n");
			
			myWriter.close();
			System.out.println("Successfully wrote to the file");
		}
		 catch(IOException e) {
			 System.out.println("An error occured");
			 e.printStackTrace();
			 
		 }
		
	}

	private static int getLastProductID() {
		// TODO Auto-generated method stub
		return 0;
	}

	/***********
	 * This method clears the screen in windows System only
	 * code from - https://stackoverflow.com/questions/2979383/java-clear-the-console
	 * 
	 * ************/
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
	/*********
	 * This method pause and wait for the user to press enter to continue
	 * *******/
	public static void waitInput(String message, Object... args) {
		Console c = System.console();
	    if (c != null) {
	        // printf-like arguments
	        if (message != null)
	            c.format(message, args);
	        c.format(" Press ENTER to proceed.  ");
	        c.readLine();
	    }
	}

}// end class
