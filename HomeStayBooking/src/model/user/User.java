package model.user;

import model.booking.Booking;
import model.saleitem.typeitem.SaleItem;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String id;
    private String userName;
    private String fullName;
    private String address;
    private int numberTelephone;
    private int numberBankAccount;
    private int indexPrestige;
    private ArrayList<String> listBooking;
    private ArrayList<String> listSaleItem;

    public User() {
    }

    public User(String id, String userName, String fullName, String address, int numberTelephone, int numberBankAccount, int indexPrestige) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.address = address;
        this.numberTelephone = numberTelephone;
        this.numberBankAccount = numberBankAccount;
        this.indexPrestige = indexPrestige;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberTelephone() {
        return numberTelephone;
    }

    public void setNumberTelephone(int numberTelephone) {
        this.numberTelephone = numberTelephone;
    }

    public int getNumberBankAccount() {
        return numberBankAccount;
    }

    public void setNumberBankAccount(int numberBankAccount) {
        this.numberBankAccount = numberBankAccount;
    }

    public int getIndexPrestige() {
        return indexPrestige;
    }

    public void setIndexPrestige(int indexPrestige) {
        this.indexPrestige = indexPrestige;
    }

    public void setListBooking(String idBooking) {
        this.listBooking.add(idBooking);
    }

    public void setGetListSaleItem(String idSaleItem) {
        this.listSaleItem.add(idSaleItem);
    }

    public ArrayList<String> getListBooking() {
        return listBooking;
    }

    public ArrayList<String> getListSaleItem() {
        return listSaleItem;
    }
}
