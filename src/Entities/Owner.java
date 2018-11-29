package Entities;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String firstName;
    private String lastName;
    private List<Vehicle> vehicle;

    public Owner(String firstName, String lastName, List<Vehicle> vehicle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vehicle = vehicle;
    }

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public List<Vehicle> getVehicles() { return vehicle; }

    public void setVehicles(List<Vehicle> vehicle) { this.vehicle = vehicle; }
}
