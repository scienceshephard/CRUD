import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Tech {
	
	
	int id=0;
	String product;
	String unit;
	String about;
	String cat;
	String amount;
	ArrayList<String> List= new ArrayList();
	Scanner in= new Scanner(System.in);
	String number;
	
	Tech(int id, String unit, String about, String cat, String amout){
		this.id=id;
		this.unit=unit;
		this.about=about;
		this.cat=cat;
		this.amount=amout;
	}
	Tech(){
		
	}
	public static void connect() throws SQLException {
		Connection conn=null;
		String url= "jdbc:sqlite:C:/sqlite/JTP.dp";
		conn= DriverManager.getConnection(url);
		System.out.println("The connection  to the SQLite has been estabished");
		if(conn!=null) {
			conn.close();
		}
			
	}
	
	void allProd() { //Press 1 to List all products
		for(int i=1; i<=List.size();i++) {
			System.out.println("id \t\t product \t\t unit \t\t about \t\t cat \\ amout");
			System.out.println(i+"\t\t "+List.get(i)+"\t\t "+unit+"\t\t "+about+"\t\t "+cat+"\t\t "+amount );	
		}
	}
	void searchProd() { //Press 2 to Search for a prod by ID
		System.out.print("What is the id number of the product: ");
		number= in.nextLine();
		System.out.println("id \t\t unit \t\t about \t\t cat \\ amout");
		System.out.println(id+"\t\t"+ unit +"\t\t"+ about+ "\t\t" + cat+ "\t\t" + "amout");
	}
	void newProd() { //Press 3 to Add a new prod
		System.out.print("name of product: ");
		number=in.nextLine();
		number=product;
		List.add(product);
	}
	
	void delProd() { //Press 4 to Delete a prod through the ID
		allProd();
		System.out.print("Select the product by ID to be deleted: ");
		try{
			number= in.nextLine();
			List.remove(number);
		}catch(IndexOutOfBoundsException e) {
			number=e.getMessage();
		}
		System.out.println(number+" is not in the product id above");
	}
	void exitProg() { //Press 5 to exit the program
		System.exit(0);
	}
	void updateList() {
		allProd();
		System.out.println("Select the product by ID to be updated: ");
		number=in.nextLine();
		
	}
}
