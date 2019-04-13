/*************************************************************************************
 *  This program creates and manages an inventory list in a separate text file
 *  products.txt
 *  
 *************************************************************************************/
import java.io.*;
import java.util.Scanner;


public class InventoryList {

	// main method
	public static void main(String[] args) {
		
		// display main menu for user
		displayMenu();
		
	}
	
	/****************************************
	 * This method displays the menu 
	 ****************************************/
	public static void displayMenu() {
		clrscr();
		Scanner input = new Scanner(System.in);
		
		// display header and menu options
		System.out.println("\n\nWelcome to Simple Inventory Program ");
		System.out.println("Presented by Alani Gilbert and Jurdan Escobedo\n\n");
		System.out.println("What do you want to do? \n 1 - Add product  "
				+ "\n 2 - Edit Product  \n 3 - Add product info  \n 4 - DisplayInventory  "
				+ "\n 5 - Add product stock \n 6 - Quit");
		int menu = input.nextInt();
		
		// filter input selection here
		try {

			switch (menu) {
			case 1:
				addProduct();
				waitInput(null);
				break;
			case 2:
				editProduct();
				waitInput(null);
				break;
			case 3:
				addDetails();
				waitInput(null);
				break;
			case 4:
				displayInventory();
				waitInput(null);
				break;
			case 5:
				addStock();
				waitInput(null);
				break;
			case 6:
				System.out.println("Quiting program...");
				break;
			default :
				System.out.println("Please Enter 1 to 5 only.");
				break;
			}
			displayMenu();
			// error handling
			} catch(Exception e){
			System.out.println("Please Enter 1 to 5 only!");
			waitInput(null);
			}
		
		input.close();
	}// end of displayMenu 
	
	
	/*********************************************************
	 * This method clears the screen in windows System only
	 * code from - https://stackoverflow.com/questions/2979383/java-clear-the-console
	 *********************************************************/
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
	
	
	/*********************************************************
	 * This method pause and wait for the user to 
	 * press enter to continue
	 *********************************************************/
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
	
	
	/**********************************************************
	 * This method creates a product object and
	 * adds that Product to inventory
	 **********************************************************/
	private static void addProduct() {
		Scanner input = new Scanner(System.in);
		
		// prompt user for product 
		System.out.print("Enter Product name: ");
		String name= input.nextLine();
		System.out.print("Enter Product ID: ");
		String id = input.nextLine();
		System.out.print("Enter price: ");
		double price = input.nextDouble();
		input.close();
		
		System.out.println("You Entered: "+ id + "  " + name + ", " + price);
		
		// create product object and add to inventory
		Product newProduct = new Product(id, name, price);
		newProduct.addToInventory();
		
		// return to display menu
		//displayMenu();
	} // end of add product
	
	
	/*************************************************************
	 * This method edits a product
	 *************************************************************/
	private static void editProduct() {
		Scanner input = new Scanner(System.in);
		
		// prompt user for change
		System.out.println("Give product ID of what product you would like to edit: ");
		String id = input.nextLine();
		System.out.println("Enter new name and price: ");
		String newName = input.nextLine();
		String newPrice = input.nextLine();
		input.close();
         
		// read file
		try {
			BufferedReader br = new BufferedReader(new FileReader("products.txt")); 
			FileWriter wr = new FileWriter("products.txt");
			String productList; 
			while ((productList = br.readLine()) != null) { 
			
				if (productList.contentEquals(id)) {
					//Replacing oldString with newString in the oldContent 
					String newLine = (id + "  " + newName + "................ $" + newPrice);
					String newContent = productList.replaceAll(id, newLine);
	
					//Rewriting the input text file with newContent                          
					wr.write(newContent);
				}
		    } 
			
			wr.close();
			br.close();
			
		} catch (IOException e) {
			System.out.println("ERROR");
		}
		
       		
	}
		
	
	/******************************************************
	 * This method reads and displays the full inventory
	 ******************************************************/
	private static void displayInventory() {
		
		// read file
		try {
			BufferedReader br = new BufferedReader(new FileReader("products.txt")); 
		  
			String productList; 
			while ((productList = br.readLine()) != null) { 
		    System.out.println(productList); 
		    } 
			
			br.close();
			
		} catch (IOException e) {
			System.out.println("ERROR");
		}
		
		// return to display menu
		//displayMenu();
	} // end of display inventory
	
	
	/******************************************************************
	 * This method allows the user to add extra details to a product
	 ******************************************************************/
	private static void addDetails() {
		Scanner input = new Scanner(System.in);
		
		// prompt user for options
		System.out.print("What product? ");
		String name = input.nextLine();
		System.out.print("What detail do you want to add? ");
		String topic = input.nextLine();
		System.out.print("What " + topic + " does " + name + " come in? ");
		String detail = input.nextLine();
		input.close();
			
		// create detail object and add to inventory
		ProductDetail newDetail = new ProductDetail(name, topic, detail);
		newDetail.addToInventory();
		
		// return to display menu
		displayMenu();
	} // end of add details
	
	private static void addStock() {
		Scanner input = new Scanner(System.in);

		// prompt user for product
		System.out.print("\nWhat product? ");
		String name = input.nextLine();
		System.out.print("\nHow much stock is there? ");
		int stock = input.nextInt();
		input.close();
		
		// create stock object and add to inventory
		ProductStock newStock = new ProductStock(name, stock);
		newStock.addToInventory();
		
		// return to display menu
		displayMenu();
	} // end of add stock
	
} // end of program
