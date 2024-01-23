import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Tech tech= new Tech();
        Scanner o= new Scanner(System.in); 	
        String option;
        do {
	        System.out.println("*******************");
	        System.out.println("Press 1 to List all products");
	        System.out.println("Press 2 to Search for a prod by ID");
	        System.out.println("Press 3 to Add a new prod");
	        System.out.println("Press 4 to Update List of prod through the ID");
	        System.out.println("Press 5 to Delete a prod through the ID");
	        System.out.println("Press 6 to EXIT the program");
	        System.out.print("Your Option: ");
	        option=o.nextLine();

	        switch(option) {
	            case "1" : tech.allProd(); // Lists all products and its details in the database
	                break;
	            case "2" :tech.searchProd(); // Searchs for a prod through the id of the database
	                break;
	            case "3" : tech.newProd(); // Inserts a prod and its details to the database
	                break;
	            case "4" : tech.updateList(); // Updates a detail of products in the database
	                break;
	            case "5" : tech.delProd(); // deletes a database
	                break;
	            case "6" : tech.exitProg(); //exits the program
	                break;
	        }

        }while(option!="6");
    }
}
