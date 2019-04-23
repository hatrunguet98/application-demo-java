package model.booking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Booking implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String id = null;
    private double totalPrice = 0;
    private Date issueAudit = null;
    private ArrayList saleItemId = new ArrayList();
    private String infoSaleItem = null;

    public Booking() {
    }

    public Booking(String id, double totalPrice, Date issueAudit, ArrayList saleItemId, String infoSaleItem) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.issueAudit = issueAudit;
        this.saleItemId = saleItemId;
        this.infoSaleItem = infoSaleItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getIssueAudit() {
        return issueAudit;
    }

    public void setIssueAudit(Date issueAudit) {
        this.issueAudit = issueAudit;
    }

    public ArrayList getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(ArrayList saleItemId) {
        this.saleItemId = saleItemId;
    }

    public String getInfoSaleItem() {
        return infoSaleItem;
    }

    public void setInfoSaleItem(String infoSaleItem) {
        this.infoSaleItem = infoSaleItem;
    }
}
