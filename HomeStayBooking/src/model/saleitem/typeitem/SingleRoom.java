package model.saleitem.typeitem;

import model.saleitem.room.Room;

import java.util.ArrayList;

public class SingleRoom extends SaleItem {
    public SingleRoom(String id, double length, double width, double unitPrice, String rateType, String dateAudit, String address, int numberOfPerson, ArrayList<Room> listRoom, String describe) {
        super(id, length, width, unitPrice, rateType, dateAudit, address, numberOfPerson, listRoom, describe);
    }
}