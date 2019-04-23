package model.saleitem.room;

import java.util.ArrayList;

public class BathRoom extends Room {

    public BathRoom(double width, double length, int numberOfPerson, ArrayList listFitment, double unitPrice) {
        super(width, length, numberOfPerson, listFitment, unitPrice);
    }

    @Override
    public String getTypeRoom() {
        return "Bath room";
    }

}
