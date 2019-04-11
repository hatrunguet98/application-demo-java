package model.user;

import model.booking.Booking;
import model.saleitem.typeitem.SaleItem;

import java.util.ArrayList;

public abstract class AbstractUser {
    private String id;
    private String fullName;
    private String address;
    private int numberTelephone;
    private int numberBankAccount;
    private int indexPrestige;
    private ArrayList<Booking> listBooking;
    private ArrayList<SaleItem> getListSaleItem;

    public abstract void getListBooking();
    public abstract void getListSaleItem();

}
