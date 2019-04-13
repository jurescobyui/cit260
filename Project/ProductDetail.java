import java.io.FileWriter;
import java.io.IOException;

/**********************************************************
 * DisplayProduct extends product
 * Using the object of products, it will create the display
 * *********************************************************/

public class ProductDetail extends Product {
	public String topic = "";
	public String detail = "";
	private String displayAs = "";
	
	//no-arg constructor
	public ProductDetail() {
			
	}
		
	public ProductDetail(String name, String topic, String detail) {
		this.topic = topic;
		this.detail = detail;
		displayAs = ("\t" + name + "'s come in different " + topic + "s like " + detail + "\n");

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