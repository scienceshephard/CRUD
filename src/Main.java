import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tech tech= new Tech();
        Scanner o= new Scanner(System.in);
        System.out.println("*******************");
        System.out.println("Press 1 to List all products");
        System.out.println("Press 2 to Search for a prod by ID");
        System.out.println("Press 3 to Add a new prod");
        System.out.println("Press 4 to Update List of prod through the ID");
        System.out.println("Press 5 to Delete a prod through the ID");
        System.out.println("Press 6 to EXIT the program");
        System.out.print("Your Option: ");

        String option=o.nextLine();
        switch(option) {
            case "1" : tech.allProd();
                break;
            case "2" :tech.searchProd();
                break;
            case "3" : tech.newProd();
                break;
            case "4" : tech.updateList();
                break;
            case "5" : tech.delProd();
                break;
            case "6" : tech.exitProg();
                break;
        }

    }

}
