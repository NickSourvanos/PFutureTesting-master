import DAOs.VehicleDAO;
import Entities.Vehicle;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private int functionMenuChoice; // the main menu
    private final static int FUNCTIONALITY_MENU_EXIT_CONDITION = 5;
    private int exportMenuChoice;   // the sub-menu

    public Menu(){
        this.functionMenuChoice = -1;
        this.exportMenuChoice = -1;
    }

    private void printFunctionalityMenu() {
        System.out.println("\n\n");
        System.out.println("--- SELECT FUNCTIONALITY TO PERFORM ---");
        System.out.println("\t* 1 Vehicle Insurance Status");
        System.out.println("\t* 2 Forcoming Expiries");
        System.out.println("\t* 3 Expiries by Plate");
        System.out.println("\t* 4 Owner Fine Calculation");
        System.out.println("\t* 5 Exit");
    }

    public void runFunctionalityMenu() throws SQLException {

        this.printFunctionalityMenu();      // print the main menu
        this.setFunctionalityMenuChoice();  // set functionMenuChoice class variable by user input

        /* get functionMenuChoice value and operate */
        switch (this.getFunctionalityMenuSelection()) {
            case 1:
                System.out.println("\t\tPlease insert Vehicle's Plate Number");
                // Scanner in = new Scanner(System.in);
                this.runExportTypeMenu();
                break;
            case 2:
                this.runExportTypeMenu();
                List<Vehicle> vehicles = VehicleDAO.getListOfVehiclesExp(5);
                for(Vehicle v : vehicles){
                    System.out.println("\t\t\t" + v.getPlate());
                }
                break;
            case 3:
                System.out.println("\tYou printed 3");
                this.runExportTypeMenu();
            case 4:
                System.out.println("\tYou printed 4");
                this.runExportTypeMenu();
                break;
            case 5:
                System.out.println("\tExiting Program ...");
                break;
        }
    }

    private void printExportTypeMenu() {
        System.out.println("--- ENTER EXPORT TYPE ---");
        System.out.println("\t* 1 File");
        System.out.println("\t* 2 Console");
        System.out.println("\t* 3 Back");
    }

    private void runExportTypeMenu() {

        this.printExportTypeMenu();
        this.setExportTypeMenuChoice();

        switch (this.getExportTypeMenuChoice()) {
            case 1:
                // System.out.println("\tYou printed 1");
                break;
            case 2:
                System.out.println("\tYou printed 2");
                break;
            case 3:
                break;
        }
    }

    private int readUserInput(int minSelection, int maxSelection) {

        int choice = -1;
        do{
            System.out.print("\t\tPlease select among the numbers above: ");
            Scanner input = new Scanner(System.in);
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Selection");
            }

        }while( choice < minSelection | maxSelection < choice );

        return choice;
    }


    private void setFunctionalityMenuChoice() {
    /*  This function stores user's selection for functionality menu in the class variable.
    *   @parameters     -
    *   @return         -
    */
        this.functionMenuChoice = this.readUserInput(1, 5);
    }

    public int getFunctionalityMenuSelection() {
        return this.functionMenuChoice;
    }

    private void setExportTypeMenuChoice() {
        this.exportMenuChoice = this.readUserInput(1, 3);
    }

    public int getExportTypeMenuChoice() {
        return this.exportMenuChoice;
    }

    public int getExitCondition() {
        return FUNCTIONALITY_MENU_EXIT_CONDITION;
    }
}
