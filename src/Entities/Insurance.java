package Entities;

import java.util.Date;

public class Insurance {
    private Date startDate;
    private Date expirationDate;
    private boolean status;

    public Insurance(Date startDate, Date expirationDate, boolean status) {
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.status = status;
    }

    public Insurance(boolean status){
        this.status = status;
    }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getExpirationDate() { return expirationDate; }

    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public boolean isStatus() { return status; }

    public void setStatus(boolean status) { this.status = status; }
}
