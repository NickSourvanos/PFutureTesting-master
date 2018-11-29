package Utilities;

import java.util.Scanner;

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

        if (plate.matches(PATTERN)){
            return true;
        } else {
            System.out.println("\t\tInvalid Plate Number");
            return false;
        }
    }

}
