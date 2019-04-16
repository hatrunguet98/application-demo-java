package model.booking;

import java.util.ArrayList;
import java.util.Date;

public class Booking {
    private String id;
    private String totalPrice;
    private String hostId;
    private String renterId;
    private String idHomeRender;
    private ArrayList<Date> dateAudit;
    private String saleItemId;

    public Booking() {
    }

    public Booking(String id, String totalPrice, String hostId, String renterId, String idHomeRender, ArrayList<Date> dateAudit, String saleItemId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.hostId = hostId;
        this.renterId = renterId;
        this.idHomeRender = idHomeRender;
        this.dateAudit = dateAudit;
        this.saleItemId = saleItemId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }

    public String getIdHomeRender() {
        return idHomeRender;
    }

    public void setIdHomeRender(String idHomeRender) {
        this.idHomeRender = idHomeRender;
    }

    public ArrayList<Date> getDateAudit() {
        return dateAudit;
    }

    public void setDateAudit(ArrayList<Date> dateAudit) {
        this.dateAudit = dateAudit;
    }

    public String getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(String saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Date getDateIssuedAudit() {
        return this.getDateAudit().get(2);
    }

}
