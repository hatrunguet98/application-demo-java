package model.saleitem.typeitem;

import model.saleitem.room.Room;

import java.util.ArrayList;

public class SaleItemBuilder {
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

    public SaleItemBuilder(String id, double length, double width, double unitPrice, String rateType, String dateAudit, String address, String idHost) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.unitPrice = unitPrice;
        this.rateType = rateType;
        this.dateAudit = dateAudit;
        this.address = address;
        this.idHost = idHost;
    }

    public SaleItemBuilder setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
        return this;
    }

    public SaleItemBuilder setNumberOfPerson(String describe) {
        this.describe = describe;
        return this;
    }

    public SaleItemBuilder setNumberOfPerson(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
        return this;
    }
    public SaleItem build() {
        return new SaleItem(this.id,this.length,this.width,this.unitPrice,this.rateType,this.dateAudit,this.address,this.numberOfPerson,this.listRoom,this.describe,this.idHost);
    }
}


