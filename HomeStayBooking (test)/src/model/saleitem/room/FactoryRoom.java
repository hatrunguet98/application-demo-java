package model.saleitem.room;

import java.util.ArrayList;

public class FactoryRoom {
    public FactoryRoom() {
    }

    public static final Room createRoom(String roomType, double width, double length, int numberOfPerson,double unitPrice, ArrayList listFitment) {
        switch (roomType) {

            case "BedRoom":
                return new BedRoom(width, length, numberOfPerson, listFitment, unitPrice);

            case "BathRoom":
                return new BathRoom(width, length, numberOfPerson, listFitment, unitPrice);

            case "LivingRoom":
                return new LivingRoom(width, length, numberOfPerson, listFitment, unitPrice);

            default:
                throw new IllegalArgumentException("This room type is unsupported");
        }
    }
}