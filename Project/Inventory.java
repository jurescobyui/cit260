import java.io.IOException;
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
		System.out.println("\t\t\t\t\t\tPresented by Group 4\n\n\n\n");
		System.out.println("What do you want to do?  1 - Add Product    2 - Search Product   3 - Edit Product      4 - Delete Product  5 - Quit");
		Scanner input = new Scanner(System.in);
		
		
		// filter input selection here
		try {
			int menu = input.nextInt();
			switch (menu) {
			case 1:
				System.out.println("You want to Add Product");
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
			
			input.close();
		}
		
	}// end of displayMenu 
	
	
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

