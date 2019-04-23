package model.saleitem.room;

import java.util.ArrayList;

public class BedRoom extends Room {

    public BedRoom(double width, double length, int numberOfPerson, ArrayList listFitment, double unitPrice) {
        super(width, length, numberOfPerson, listFitment, unitPrice);
    }

    @Override
    public String getTypeRoom() {
        return "Bed room";
    }

}
