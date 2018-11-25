package Entities;

import java.util.Date;

public class Vehicle implements Comparable<Vehicle>{
    private String plate;
    private Date expirationDate;

    public Vehicle(String plate, Date expirationDate){
        this.plate = plate;
        this.expirationDate = expirationDate;
    }

    public Vehicle(String plate){
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public int compareTo(Vehicle o) {

        return this.getPlate().compareTo(o.getPlate());
    }
}
