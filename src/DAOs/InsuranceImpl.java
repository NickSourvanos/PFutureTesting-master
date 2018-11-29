package DAOs;

import DBUtils.DatabaseConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsuranceImpl implements InsuranceDAO{

    @Override
    public boolean getInsuranceStatus(String plate) throws SQLException {

        boolean status = false;
        String query = "SELECT STATUS FROM INSURANCE I \n" +
                "INNER JOIN INSURANCE_VEHICLE IV ON (I.ID = IV.INSURANCE_ID) \n" +
                "INNER JOIN VEHICLE V ON (V.ID = IV.VEHICLE_ID) " +
                "WHERE V.PLATE = \"" + plate + "\";";
        ResultSet set = null;

        try(Statement statement = DatabaseConnection.getDatabaseConnection().createStatement()){

            set = statement.executeQuery(query);
            set.next();
            status = set.getBoolean(1);

        } finally{ set.close(); }

        return status;
    }
}
