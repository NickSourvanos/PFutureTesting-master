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
import java.util.List;

public class VehicleImpl implements VehicleDAO{

    public List<Vehicle> getListOfVehiclesExp(int numberOfDays) throws SQLException {

        List<Vehicle> vehicles = new ArrayList<>();
        String date = DateUtils.getDate(numberOfDays);
        String query = "SELECT V.PLATE, I.EXPIRATION_DATE FROM INSURANCE I\n" +
                "INNER JOIN INSURANCE_VEHICLE IV ON(I.ID = IV.INSURANCE_ID)\n" +
                "INNER JOIN VEHICLE V ON(V.ID = IV.VEHICLE_ID)\n" +
                "WHERE I.EXPIRATION_DATE BETWEEN CURRENT_DATE() AND \"" + date + "\";";
        ResultSet set = null;
        try(Statement connection = DatabaseConnection.getDatabaseConnection().createStatement()){


            set = connection.executeQuery(query);
            while(set.next()){
                vehicles.add(new Vehicle(set.getString(1),
                        set.getDate(2)));
            }
            Collections.sort(vehicles);
            System.out.println();
        }finally { set.close(); }

        return vehicles;
    }

    @Override
    public List<Vehicle> getListOfOUninsuredVehicles() throws SQLException {

        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT PLATE FROM OWNER O\n" +
                "\tINNER JOIN VEHICLE V ON(O.ID = V.OWNER_ID)\n" +
                "    INNER JOIN INSURANCE_VEHICLE IV ON(IV.VEHICLE_ID = V.ID)\n" +
                "    WHERE IV.INSURANCE_ID IS NULL\n" +
                "UNION\n" +
                "SELECT PLATE FROM VEHICLE V \n" +
                "INNER JOIN INSURANCE_VEHICLE IV ON (V.ID = IV.VEHICLE_ID)\n" +
                "INNER JOIN INSURANCE I ON (I.ID = IV.INSURANCE_ID)\n" +
                "WHERE I.EXPIRATION_DATE < CURRENT_DATE();\n";
        ResultSet set = null;

        try(Statement connection = DatabaseConnection.getDatabaseConnection().createStatement()){

            set = connection.executeQuery(query);
            while(set.next()){
                vehicles.add(new Vehicle(set.getString(1)));
            }

            Collections.sort(vehicles);

        } finally { set.close(); }


        return vehicles;
    }
}
