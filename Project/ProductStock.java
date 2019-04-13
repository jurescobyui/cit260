import java.io.FileWriter;
import java.io.IOException;

/**********************************************************
 * DisplayProduct extends product
 * Using the object of products, it will create the display
 * *********************************************************/

public class ProductStock extends Product {
	public int stock = 0;
	private String displayAs = "";
	
	//no-arg constructor
	public ProductStock() {
			
	}
		
	public ProductStock(String name, int stock) {
		this.stock = stock;
		displayAs = ("\t" + name + " has/have " + stock + " in stock\n");
		
	}
	
	public void addToInventory() {
		// add product to file
		try {
			FileWriter myWriter = new FileWriter("products.txt",true);
			myWriter.write(displayAs);

			myWriter.close();
			System.out.println("Successfully wrote to the file");
			
		} catch(IOException e) {
			 System.out.println("An error occured");
			 e.printStackTrace();			 
		}
	}
			

}// end class
