package DAOs;

import Entities.Vehicle;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDAO {

     List<Vehicle> getListOfVehiclesExp(int numberOfDays) throws SQLException;

     List<Vehicle> getListOfOUninsuredVehicles() throws SQLException;
}
