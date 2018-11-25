package DAOs;

import DBUtils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsuranceDAO {

    public static boolean getInsuranceStatus(String plate) throws SQLException{

        Connection connection = null;
        boolean status = false;
        String query = "SELECT STATUS FROM INSURANCE I \n" +
                "INNER JOIN INSURANCE_VEHICLE IV ON (I.ID = IV.INSURANCE_ID) \n" +
                "INNER JOIN VEHICLE V ON (V.ID = IV.VEHICLE_ID) " +
                "WHERE V.PLATE = \"" + plate + "\";";
        try{
            connection = DatabaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);
            set.next();
            status = set.getBoolean(1);

        }catch(ClassNotFoundException e){}
        finally{ connection.close(); }

        return status;
    }

}
