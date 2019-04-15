package model.saleitem;

import model.saleitem.room.Room;

import java.io.Serializable;
import java.util.ArrayList;


public class SaleItem implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String id;
    private String type;
    private double length;
    private double width;
    private double unitPrice;
    private String rateType;
    private String dateAudit;
    private String address;
    private int numberOfPerson;
    private ArrayList<Room> listRoom;
    private String describe;
    private String hostId;

    public SaleItem() {
    }

    public SaleItem(SaleItemBuilder saleItemBuilder) {
        this.id = saleItemBuilder.id;
        this.type = saleItemBuilder.type;
        this.length = saleItemBuilder.length;
        this.width = saleItemBuilder.width;
        this.unitPrice = saleItemBuilder.unitPrice;
        this.rateType = saleItemBuilder.rateType;
        this.dateAudit = saleItemBuilder.dateAudit;
        this.address = saleItemBuilder.address;
        this.numberOfPerson = saleItemBuilder.numberOfPerson;
        this.listRoom = saleItemBuilder.listRoom;
        this.describe = saleItemBuilder.describe;
        this.hostId = saleItemBuilder.hostId;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
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

    public String getHostId() {
        return hostId;
    }

    public static class SaleItemBuilder {

        private String id;
        private String type;
        private double length;
        private double width;
        private double unitPrice;
        private String rateType;
        private String dateAudit;
        private String address;
        private int numberOfPerson;
        private ArrayList<Room> listRoom;
        private String describe;
        private String hostId;

        public SaleItemBuilder(String id, String type, double length, double width, double unitPrice, String rateType, String dateAudit, String address, String hostId) {
            this.id = id;
            this.type = type;
            this.length = length;
            this.width = width;
            this.unitPrice = unitPrice;
            this.rateType = rateType;
            this.dateAudit = dateAudit;
            this.address = address;
            this.hostId = hostId;
        }

        public SaleItemBuilder setNumberOfPerson(int numberOfPerson) {
            this.numberOfPerson = numberOfPerson;
            return this;
        }

        public SaleItemBuilder setNumberOfPerson(String describe) {
            this.describe = describe;
            return this;
        }

        public SaleItemBuilder setListRoom(ArrayList<Room> listRoom) {
            this.listRoom = listRoom;
            return this;
        }

        public SaleItem build() {
            return new SaleItem(this);
        }
    }
}

