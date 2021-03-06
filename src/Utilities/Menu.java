/*  This class implements a menu for user interaction through the console. It consists of a collection of static
    methods. Use this menu by implementing additional loop logic with outside of this scope.

    Methods

        public:
            # getExitCondition      -       returns menu's exit condition. Useful for exit loop
            # runMainMenu           -       starts the menu

        private:
            # runExportTypeMenu     -       runs a sub menu where user selects the output (file ot console) for
                                            Forthcoming Expiries
            # printMainMenu         -       shows main menu's possible choices
            # printExportTypeMenu   -       shows export type menu's possible selections
            # getMenuSelection      -       I/O user's selection (Console Input)
                                            function that performs and validates user input
*/

package Utilities;

import DAOs.*;
import Entities.Owner;
import Entities.Vehicle;
import ExceptionUtils.InvalidUserInputException;
import ExceptionUtils.NameNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final static int MAIN_MENU_EXIT_CONDITION = 5;

    public static int getExitCondition() {
        return MAIN_MENU_EXIT_CONDITION;
    }

    public static int runMainMenu() {

        printMainMenu();                                   // print the main menu
        int mainMenuSelection = getMenuSelection(1, 5);    // set getMainSelection class variable by user input

        /* get functionMenuChoice value and operate */
        switch (mainMenuSelection) {
            case 1:
                try {
                    String plateNumber = ValidationUtils.readPlateNumber();
                    InsuranceDAO insurance = new InsuranceImpl();
                    if (insurance.getInsuranceStatus(plateNumber)) {
                        System.out.println("\t\t\tActive Insurance");
                    } else {
                        System.out.println("\t\t\tExpired Insurance");
                    }
                }catch(InvalidUserInputException e){
                    System.out.println("\t\t\t Error: Invalid Plate format. Expected format: 'ABC-1234'");
                } catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            case 2:
                runExportTypeMenu();
                break;
            case 3:
                try{
                    VehicleDAO plates = new VehicleImpl();
                    for(Vehicle v : plates.getListOfOUninsuredVehicles()){
                        System.out.println(v.getPlate());
                    }
                }catch(SQLException e){}

                break;
            case 4:
                try {
                    //TODO: add custom exception package

                    String firstName = ValidationUtils.getName("first");
                    String lastName = ValidationUtils.getName("last");

                    if(ValidationUtils.checkIfNameExists(firstName, lastName)){
                        double fine = ValidationUtils.getFine();

                        OwnerDAO owner = new OwnerImpl();
                        Owner ownerObj = owner.getListOfOUninsuredVehiclesPerOwner(firstName, lastName);

                    for (Vehicle v : ownerObj.getVehicles()) {
                        System.out.println("\t\t\tPlates: " + v.getPlate());


                        }
                        System.out.println("\t\t\tTotal fine cost: " + FineUtils.getTotalFineCost(fine, ownerObj.getVehicles().size()));
                    }else {

                        System.out.println("There are no uninsured vehicles or user does not exist!");


                    }
                }catch(SQLException | NameNotFoundException e){}
                break;
            case 5:
                System.out.println("\tExiting Program ...");
                break;
        }

        return mainMenuSelection;
    }

    private static void runExportTypeMenu() {

        printExportTypeMenu();
        int exportMenuSelection = getMenuSelection(1,3);

        System.out.print("\t\tPlease select number of days: ");
        Scanner in = new Scanner(System.in);
        int nextDays = Integer.parseInt(in.nextLine());

        switch (exportMenuSelection) {
            case 1:
                try{
                    CSVUtils.createCSVFile(nextDays);
                }catch(IOException e){}

                break;
            case 2:
                List<Vehicle> vehicles = null;
                try {
                    VehicleDAO vehicle = new VehicleImpl();
                    vehicles = vehicle.getListOfVehiclesExp(nextDays);
                } catch (SQLException e) { e.printStackTrace(); return; }

                try {
                    for (Vehicle v : vehicles) {
                        System.out.println("\t\t\tPlate: " + v.getPlate() + ", " +
                                "Expiration Date: " + v.getExpirationDate());
                    }
                } catch (NullPointerException e){ System.out.println("\t\t\tEntry not found");}
                break;
            case 3:
                break;
        }
    }

    private static void printMainMenu() {
        System.out.println("\n\n");
        System.out.println("--- SELECT FUNCTIONALITY TO PERFORM ---");
        System.out.println("\t* 1 Vehicle Insurance Status");
        System.out.println("\t* 2 Forcoming Expiries");
        System.out.println("\t* 3 Expiries by Plate");
        System.out.println("\t* 4 Owner Fine Calculation");
        System.out.println("\t* 5 Exit");
    }

    private static void printExportTypeMenu() {
        System.out.println("--- ENTER EXPORT TYPE ---");
        System.out.println("\t* 1 File");
        System.out.println("\t* 2 Console");
        System.out.println("\t* 3 Back");
    }

    private static int getMenuSelection(int minSelection, int maxSelection) {

        int selection = -1;
        do{
            System.out.print("\t\tPlease select among the numbers above: ");
            Scanner input = new Scanner(System.in);
            try {
                selection = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\t\t\tInvalid Selection");
            }
        }while(selection < minSelection | maxSelection < selection);

        return selection;
    }
}
