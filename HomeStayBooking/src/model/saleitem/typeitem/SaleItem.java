package model.saleitem.typeitem;

import model.saleitem.room.Room;

import java.io.Serializable;
import java.util.ArrayList;


public class SaleItem implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String id;
    private double length;
    private double width;
    private double unitPrice;
    private String rateType;
    private String dateAudit;
    private String address;
    private int numberOfPerson;
    private ArrayList<Room> listRoom;
    private String describe;
    private String idHost;

    public SaleItem() {
    }

    public SaleItem(String id, double length, double width, double unitPrice, String rateType, String dateAudit, String address, int numberOfPerson, ArrayList<Room> listRoom, String describe, String idHost) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.unitPrice = unitPrice;
        this.rateType = rateType;
        this.dateAudit = dateAudit;
        this.address = address;
        this.numberOfPerson = numberOfPerson;
        this.listRoom = listRoom;
        this.describe = describe;
        this.idHost = idHost;
    }

    public String getId() {
        return id;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getRateType() {
        return rateType;
    }

    public String getDateAudit() {
        return dateAudit;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public String getDescribe() {
        return describe;
    }

    public String getIdHost() {
        return idHost;
    }

}

