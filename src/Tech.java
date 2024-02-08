import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Tech {


	int id=0;
	String product; 	// Name of product
	String unit;		// How many of the product is available
	String about;		// Information about the product
	String cat;			// What category is the product under
	String amount;		// The price of the product

//	ArrayList<String> List= new ArrayList();
	Scanner in= new Scanner(System.in);
	int number;
	static final String url = "jdbc:mysql://localhost/crude_project";
	static final String driver= "com.mysql.cj.jdbc.Driver";
	static final String username="root";
	static final String password="password";

	// sql cmds for some of the method

//	static final String

	Tech(int id, String unit, String about, String cat, String amout){
		this.id=id;
		this.unit=unit;
		this.about=about;
		this.cat=cat;
		this.amount=amout;
	}
	Tech(){

	}

	static Connection conn=null;
	static Statement stm=null;
	static PreparedStatement pstm=null;
	static ResultSet rs= null;
	static {
			// Establishes the Connection to the database
			try {
				conn= DriverManager.getConnection(url, username, password);
				stm= conn.createStatement();
				Class.forName(driver);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}

			System.out.println("Connecting to the database...");
	}

	// Lists all products and its details in the database
	void allProd() throws SQLException {
		final String all_prod="SELECT * FROM food_chain;"; //for allProd()

		rs=stm.executeQuery(all_prod);
		while(rs.next()) {
			id= rs.getInt("id");
			product=rs.getString("product");
			unit=rs.getString("unit");
			cat=rs.getString("category");
			amount=rs.getString("amount");
			about=rs.getString("about");
			System.out.println(id+" : "+product+" : "+unit+" : "+cat+" : "+amount+" : "+about);
		}
		
	}
	// Searchs for a prod through the id of the database
	void searchProd() throws SQLException { //Press 2 to Search for a prod by ID
		System.out.print("What is the id number of the product: ");
		id= in.nextInt();
		final String search_prod="SELECT * FROM food_chain WHERE id=?"; //for searchProd with a condition

		pstm= conn.prepareStatement(search_prod);
		pstm.setInt(1, id);
		rs= pstm.executeQuery();
		rs.next();
		System.out.println("\n"+rs.getInt(1)+" : " +rs.getString(2)+" : " +rs.getString(3)+" : " +rs.getString(4)
		+" : " +rs.getString(5)+" : " +rs.getString(6)+"\n\n");
	}
	// Inserts a prod and its details to the database
	void newProd() throws SQLException { //Press 3 to Add a new prod
		System.out.println("Number: ");
		id=in.nextInt();

		System.out.print("Category of the product: ");
		cat=in.next();
		System.out.println();
		System.out.print("Name of product: ");
		product=in.next();
		System.out.println();
		System.out.print("Unit of the product: ");
		unit=in.next();
		System.out.println();
		System.out.print("About the product: ");
		about=in.next();
		System.out.println();
		System.out.print("The price of the product");
		amount=in.next();
		System.out.println();
		String newprod="INSERT INTO food_chain VALUES (?,?,?,?,?,?)";
		pstm= conn.prepareStatement(newprod);
		pstm.setInt(1, id);
		pstm.setString(2, product);
		pstm.setString(3, unit);
		pstm.setString(4, about);
		pstm.setString(5, cat);
		pstm.setString(6, amount);

		int r=pstm.executeUpdate();
		System.out.println("Numbers of rows aftected: "+r);
	}
	// deletes a database
	void delProd() throws SQLException { //Press 4 to Delete a prod through the ID
		allProd();
		System.out.print("Select the product by ID to be deleted: ");
			number= in.nextInt();
			final String delprod="DELETE FROM food_chain WHERE id=?";
			pstm= conn.prepareStatement(delprod);
			pstm.setInt(1, number);
			number=pstm.executeUpdate();
			
	}
	//exits the program
	void exitProg() throws SQLException { //Press 5 to exit the program
		conn.close();
		stm.close();
		rs.close();
		System.out.println("You have succesfully exited the program3");
		System.exit(0);
	}
	// Updates a detail of products in the database
	void updateList() throws SQLException {
		allProd();
		System.out.println("Select the product by ID to be updated: ");
		number=in.nextInt();
		System.out.print("What do you want to update in this database:"
				+ " \n Select 1.Product 2.Unit 3.Amount 4.About 5.Category");
		number=in.nextInt();
		switch(number) {
		case 1:System.out.print("New name of product: ");
			product=in.nextLine();
			rs=stm.executeQuery("UPDATE food_chain SET product="+product+" WHERE id="+number+";");
			break;
		case 2:System.out.print("Unit update: ");
			unit=in.nextLine();
			rs=stm.executeQuery("UPDATE food_chain SET unit="+unit+" WHERE id="+number+";");
			break;
		case 3:System.out.print("New Amount of the product: ");
			amount=in.nextLine();
			rs=stm.executeQuery("UPDATE food_chain SET product="+amount+" WHERE id="+number+";");
			break;
		case 4:System.out.print("About the product: ");
			about=in.nextLine();
			rs=stm.executeQuery("UPDATE food_chain SET product="+about+" WHERE id="+number+";");
			break;
		case 5:System.out.print("Category of the product: ");
			cat=in.nextLine();
			rs=stm.executeQuery("UPDATE food_chain SET product="+cat+" WHERE id="+number+";");
			break;
		}
	}
}
