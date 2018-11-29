package Utilities;

import java.io.IOException;
import java.util.InputMismatchException;
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
