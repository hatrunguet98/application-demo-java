package model.saleitem.room;

import java.util.ArrayList;

public abstract class Room {
    private String type;
    private double width;
    private double length;
    private int numberOfPerson;
    private ArrayList listFitment;
    private double unitPrice;

    public Room() {
    }

    public Room(double width, double length, int numberOfPerson, ArrayList listFitment, double unitPrice) {
        this.width = width;
        this.length = length;
        this.numberOfPerson = numberOfPerson;
        this.listFitment = listFitment;
        this.unitPrice = unitPrice;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public ArrayList getListFitment() {
        return listFitment;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Room(String type, double width, double length, int numberOfPerson, ArrayList listFitment, double unitPrice) {
        this.type = type;
        this.width = width;
        this.length = length;
        this.numberOfPerson = numberOfPerson;
        this.listFitment = listFitment;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return this.getTypeRoom() +": "+
                ", Acreage : %.2f%" + width*length +
                ", numberOfPerson : " + numberOfPerson +
                ", listFitment : " + listFitment +
                ", unitPrice : " + unitPrice;
    }

    public abstract String getTypeRoom();
}
