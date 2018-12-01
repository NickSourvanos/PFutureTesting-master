package DAOs;

import DBUtils.DatabaseConnection;
import Entities.Owner;
import Entities.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerImpl implements OwnerDAO{

    @Override
    public Owner getListOfOUninsuredVehiclesPerOwner(String firstName, String lastName)
            throws SQLException {

        Owner owner = null;
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT PLATE FROM OWNER O\n" +
                " INNER JOIN VEHICLE V ON(O.ID = V.OWNER_ID)\n" +
                " INNER JOIN INSURANCE_VEHICLE IV ON(IV.VEHICLE_ID = V.ID)\n" +
                " WHERE FIRST_NAME = \""+ firstName + "\" AND LAST_NAME = \""
                + lastName + "\" AND IV.INSURANCE_ID IS NULL;";
        ResultSet set = null;

        try(Statement connection = DatabaseConnection.getDatabaseConnection().createStatement()){
            set = connection.executeQuery(query);
            while(set.next()){
                vehicles.add(new Vehicle(set.getString(1)));
            }
            owner = new Owner(firstName, lastName, vehicles);

        } finally { set.close(); }

        return owner;
    }
}
