import java.io.FileWriter;
import java.io.IOException;

/*--------------------------------
 *         Class Product         |
 * ------------------------------|
 * - id :  String                   |
 * - name : String               |
 * - price : double              |
 * ------------------------------|
 * + setId() : void              |
 * + setName()                   |
 * + setPrice()                  |
 * + getID()                     |
 * + getName()                   |
 * + getPrice()                  |
 * *-----------------------------*/
public class Product {
	protected String id = "";
	protected String name = "";
	protected double price = 0.0;
	private String displayAs = "";
	
	//no-arg constructor
	public Product() {
		
	}
	
	public Product(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		displayAs = (id + "  " + name + "..................... $" + price + "\n");
		
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
