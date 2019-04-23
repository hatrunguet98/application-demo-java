package model.saleitem;

import model.saleitem.room.Room;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class SaleItem implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String id;
    private String type;
    private double totalPrice = 0;
    private double rateType;
    private ArrayList<LocalDate> dateAudit;
    private String address;
    private int numberOfPerson = 0;
    private ArrayList<Room> listRoom;
    private String describe;
    private String hostId;

    public SaleItem() {
    }

    public SaleItem(SaleItemBuilder saleItemBuilder) {
        this.id = saleItemBuilder.id;
        this.type = saleItemBuilder.type;
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

    public double getRateType() {
        return rateType;
    }

    public ArrayList<LocalDate> getDateAudit() {
        return dateAudit;
    }

    public StringBuilder getInfoDateAudit() {
        StringBuilder dateAudit = new StringBuilder();
        dateAudit.append("Date created : ").append(this.dateAudit.get(0).toString());
//                .append(",Date update : ").append(this.dateAudit.get(1).toString())
//                .append(",Date issue : ").append(this.dateAudit.get(2).toString());
        return dateAudit;
    }

    public LocalDate getDateIssuedAudit() {
        return this.getDateAudit().get(2);
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfPerson() {
        for (Room room : this.listRoom) {
            this.numberOfPerson += room.getNumberOfPerson();
        }
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

    public double getTotalPrice() {
        for (Room room : this.listRoom) {
            this.totalPrice += room.getUnitPrice();
        }
        return totalPrice * this.rateType;
    }

    public StringBuilder getInFoRoom() {
        StringBuilder infoRoom = new StringBuilder();
        if(listRoom.isEmpty()) return null;
        else {
            for (Room room : this.listRoom) {
                infoRoom.append(room.toString());
            }
            return infoRoom;
        }

    }

    public static class SaleItemBuilder {

        private String id;
        private String type;
        private double rateType;
        private ArrayList<LocalDate> dateAudit;
        private String address;
        private int numberOfPerson;
        private ArrayList<Room> listRoom;
        private String describe;
        private String hostId;

        public SaleItemBuilder(String id, String type, double rateType, ArrayList<LocalDate> dateAudit, String address, String hostId) {
            this.id = id;
            this.type = type;
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

    @Override
    public String toString() {
        return "Id: '" + id + '\'' +
                ", Type: '" + type + '\'' +
                ", Total price: " + totalPrice + '\'' +
                ", Rate type: " + rateType + '\'' +
                ", Date audit: " + this.getInfoDateAudit() + '\'' +
                ", Address: '" + address + '\'' +
                ", Number ofPerson: " + numberOfPerson + '\'' +
//                ", Info about room: " + '\'' + this.getInFoRoom() + '\'' +
                ", Describe: '" + describe + '\'';
    }
}

