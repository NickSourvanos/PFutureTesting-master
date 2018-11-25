package DAOs;

import DBUtils.DatabaseConnection;
import Entities.Vehicle;
import Utilities.DateUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class VehicleDAO {

    public static List<Vehicle> getListOfVehiclesExp(int numberOfDays) throws SQLException{

        Connection connection = null;
        List<Vehicle> vehicles = new ArrayList<>();
        String date = DateUtils.getDate(numberOfDays);
        String query = "SELECT V.PLATE, I.EXPIRATION_DATE FROM INSURANCE I\n" +
                "INNER JOIN INSURANCE_VEHICLE IV ON(I.ID = IV.INSURANCE_ID)\n" +
                "INNER JOIN VEHICLE V ON(V.ID = IV.VEHICLE_ID)\n" +
                "WHERE \"" + date + "\" >= CURRENT_DATE();";
        try{
            connection = DatabaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);
            while(set.next()){
                vehicles.add(new Vehicle(set.getString(1),
                        set.getDate(2)));
            }
            Collections.sort(vehicles);

        }catch(ClassNotFoundException e){}
        finally { connection.close(); }

       return vehicles;
    }
}
