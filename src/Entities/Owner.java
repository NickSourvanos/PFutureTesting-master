package Entities;

public class Owner {
    private String firstName;
    private String lastName;
    private Vehicle vehicle;

    public Owner( String firstName, String lastName, Vehicle vehicle) {
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

    public Vehicle getVehicle() { return vehicle; }

    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
