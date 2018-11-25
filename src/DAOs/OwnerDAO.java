package DAOs;

import DBUtils.DatabaseConnection;
import Entities.Owner;
import Entities.Vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {

    public static List<Owner> getListOfOUninsuredVehiclesPerOwner(String firstName, String lastName)
            throws SQLException{

        Connection connection = null;
        List<Owner> owners = new ArrayList<>();
        String query = "SELECT PLATE FROM OWNER O\n" +
                " INNER JOIN VEHICLE V ON(O.ID = V.OWNER_ID)\n" +
                " INNER JOIN INSURANCE_VEHICLE IV ON(IV.VEHICLE_ID = V.ID)\n" +
                " WHERE FIRST_NAME = \""+ firstName + "\" AND LAST_NAME = \""
                + lastName + "\" AND IV.INSURANCE_ID IS NULL;";
        try{
            connection = DatabaseConnection.getDatabaseConnection();

            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);
            while(set.next()){
                owners.add(new Owner(firstName, lastName,
                        new Vehicle(set.getString(1))));
            }

        }catch(ClassNotFoundException e){}
        finally { connection.close(); }


        return owners;
    }

}
