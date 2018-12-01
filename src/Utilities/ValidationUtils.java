package Utilities;

import DBUtils.DatabaseConnection;
import Entities.Owner;
import Entities.Vehicle;
import ExceptionUtils.NameNotFoundException;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class ValidationUtils {

    public static boolean validateNumberOfDays(){
        Scanner in = new Scanner(System.in);
        int numberOfDays;

        do{
            while(!in.hasNextInt()){
                String input = in.next();
                System.out.printf("Invalid input", input);
            }

            numberOfDays = in.nextInt();
        }while(numberOfDays < 0);

        return true;

    }

    public static boolean checkIfNameExists(String firstName, String lastName) throws NameNotFoundException {

        boolean flag = false;

        String query = "SELECT FIRST_NAME, LAST_NAME FROM OWNER O\n" +
                " WHERE FIRST_NAME = \""+ firstName + "\" AND LAST_NAME = \""
                + lastName + "\";";

        try(ResultSet set = DatabaseConnection.getDatabaseConnection().createStatement().executeQuery(query)){

            while(set.next()){
                if(set != null){
                    flag = true;
                }
                else{
                    throw new NameNotFoundException();

                }
            }
        }catch(SQLException e){}
        return flag;
    }

    public static boolean validPlate(String plate){
        final String PATTERN = "[A-Z]{3}-[1-9]{4}";

        if (plate.trim().matches(PATTERN)){
            return true;
        } else {
            System.out.println("\t\tInvalid Plate Number");
            return false;
        }
    }

    public static String getName(String nameType) {
        final String PATTERN = "[a-zA-Z ]+";
        String name;
        boolean validName;

        do {
            System.out.println("Enter " + nameType + " name: ");

            Scanner inp = new Scanner(System.in);
            name = inp.nextLine();
            validName = name.trim().matches(PATTERN);
            if(!validName){
                System.out.println("Invalid input! Please enter a "+ nameType+ " using only letters (spaces are allowed).");
            }
        }while (!validName);

        return name;
    }

    public static double getFine() {
        double fine;
        do {
            try {
                System.out.println("Enter fine: ");
                Scanner inp = new Scanner(System.in);
                fine = Double.parseDouble(inp.nextLine().trim());
                return fine;
            }catch(NumberFormatException e){
                System.out.println("Invalid input! Please enter a fine using only numbers (spaces are not allowed).");
            }
        }while(true);
    }
}
