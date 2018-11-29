

import DAOs.OwnerDAO;
import DAOs.OwnerImpl;
import DAOs.VehicleDAO;
import DAOs.VehicleImpl;
import Entities.Vehicle;
import Utilities.Menu;
import Utilities.ValidationUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        double fine = ValidationUtils.getFine();

//        int mainMenuSelection = -1;
//        do{
//            mainMenuSelection = Menu.runMainMenu();
//        }while(mainMenuSelection != Menu.getExitCondition());

        //ValidationUtils.validateNumberOfDays();

        /*Scanner in = new Scanner(System.in);
        System.out.println("Enter first name: " );
        String firstName = in.nextLine();
        System.out.println("Enter last name: " );
        String lastName = in.nextLine();
        System.out.println("Enter fine: ");
        double fine = in.nextDouble();
        Owner owner = OwnerDAO.getListOfOUninsuredVehiclesPerOwner(firstName, lastName);
        System.out.println(owner.getFirstName() + ", " + owner.getLastName());
        System.out.println("Plates: ");

        for(Vehicle v : owner.getVehicles()){
            System.out.println(v.getPlate());

        }
        System.out.println("Total fine cost: " + FineUtils.getTotalFineCost(fine, owner.getVehicles().size()));

        //createCSVFile();
        /*Scanner in = new Scanner(System.in);
        System.out.println("Enter first name: " );
        String firstName = in.nextLine();
        System.out.println("Enter last name: " );
        String lastName = in.nextLine();

        Owner owner = OwnerDAO.getListOfOUninsuredVehiclesPerOwner(firstName, lastName);
        System.out.println("First Name: " + owner.getFirstName());
        System.out.println("Last Name: " + owner.getLastName());

        for(Vehicle vehicle : owner.getVehicles()){
            System.out.println("Vehicle: " + vehicle.getPlate());
        }*/



/*
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of days: ");
        int numberOfDays = in.nextInt();

        List<Vehicle> vehicles = VehicleDAO.getListOfVehiclesExp(numberOfDays);
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.getPlate() + "\t" + vehicle.getExpirationDate());

        }

        /*Scanner in = new Scanner(System.in);
        System.out.println("Enter plate number: ");
        String plateNumber = in.nextLine();

        if(InsuranceDAO.getInsuranceStatus(plateNumber)){
            System.out.println("Active");
        }else{
            System.out.println("Exprired!");
        }

        /*
        Menu menu = new Menu();
        do{
            menu.runFunctionalityMenu();
        }while(menu.getFunctionalityMenuSelection() != menu.getExitCondition());



        /*System.out.println("Enter first name: ");
        String firstName = in.nextLine();
        System.out.println("Enter last name: ");
        String lastName = in.nextLine();


        for(Owner owner : OwnerDAO.getListOfOUninsuredVehiclesPerOwner(firstName, lastName)) {

            System.out.println("Plate: " + owner.getVehicle());
        }*/
        /*
        System.out.println("Enter late number: ");
        String plate = in.nextLine();


        if(InsuranceDAO.getInsuranceStatus(plate)){
            System.out.println("Active");
        }else{
            System.out.println("Expired!");
        }
        */

        //System.out.println("Response: " + InsuranceDAO.getInsuranceStatus("ASD-1234"));

    }
/*
    public static void createCSVFile(){
        String PATH = "C://";
        String directoryName = PATH.concat("ProjectFutureFolder");

        try{
            File directory = new File(directoryName);
            if (! directory.exists()){
                directory.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            }
            FileWriter writer = new FileWriter(directoryName + "/" + CSVUtils.fileName());

            CSVUtils.writeLine(writer, Arrays.asList("Plate","Expiration Date"));
            for(Vehicle v : VehicleDAO.getListOfVehiclesExp(5)){
                List<String> plates = new ArrayList<>();
                plates.add(v.getPlate());
                plates.add(v.getExpirationDate().toString());

                CSVUtils.writeLine(writer, plates);
            }

            writer.flush();
            writer.close();


        }catch(IOException | SQLException e){}
    }
*/
}
