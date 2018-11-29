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

public interface VehicleDAO {

     List<Vehicle> getListOfVehiclesExp(int numberOfDays) throws SQLException;

     List<Vehicle> getListOfOUninsuredVehicles() throws SQLException;
}
