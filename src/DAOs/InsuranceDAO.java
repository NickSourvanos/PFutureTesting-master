package DAOs;

import DBUtils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface InsuranceDAO {

    boolean getInsuranceStatus(String plate) throws SQLException;



}
