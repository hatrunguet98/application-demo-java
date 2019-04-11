package model.saleitem.typeitem;

import model.saleitem.room.Room;
import java.util.ArrayList;


public class SaleItem {
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

    public SaleItem(String id, double length, double width, double unitPrice, String rateType, String dateAudit, String address, int numberOfPerson, ArrayList<Room> listRoom, String describe) {
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
    }

    public static class SaleItemBuilder{
        private String id;
        private double length;
        private double width;
        private double acreage;
        private double unitPrice;
        private String rateType;
        private String dateAudit;
        private String address;
        private int numberOfPerson;
        private ArrayList<Room> listRoom;
        private String describe;

        public SaleItemBuilder(String id, double acreage, double unitPrice, String rateType, String dateAudit, String address, ArrayList<Room> listRoom, String describe) {
            this.id = id;
            this.acreage = acreage;
            this.unitPrice = unitPrice;
            this.rateType = rateType;
            this.dateAudit = dateAudit;
            this.address = address;
            this.listRoom = listRoom;
        }

        public SaleItemBuilder setLength(double length) {
            this.length = length;
            return this;
        }

        public SaleItemBuilder setWidth(double width) {
            this.width = width;
            return this;
        }

        public SaleItemBuilder setNumberOfPerson(int numberOfPerson) {
            this.numberOfPerson = numberOfPerson;
            return this;
        }

        public SaleItem build(){
            SaleItem saleItem = new SaleItem(this.id,this.length,this.width,this.unitPrice,this.rateType,this.dateAudit,this.address,this.numberOfPerson,this.listRoom, this.describe);
            return saleItem;
        }
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "id='" + id + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", unitPrice=" + unitPrice +
                ", rateType='" + rateType + '\'' +
                ", dateAudit='" + dateAudit + '\'' +
                ", address='" + address + '\'' +
                ", numberOfPerson=" + numberOfPerson +
                ", listRoom=" + listRoom +
                '}';
    }
}

