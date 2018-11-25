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

}
