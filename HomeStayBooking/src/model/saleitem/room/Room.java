package model.saleitem.room;

import java.util.ArrayList;

public abstract class Room {
    private String type;
    private double width;
    private double length;
    private int numberOfPerson;
    private ArrayList listFitment;

    public Room() {
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

    public abstract String getTypeRoom();
}
