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

public interface OwnerDAO {

    Owner getListOfOUninsuredVehiclesPerOwner(String firstName, String lastName) throws SQLException;



}
