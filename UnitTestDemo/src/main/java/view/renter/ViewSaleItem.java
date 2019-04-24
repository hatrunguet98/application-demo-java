package view.renter;

import dao.BookingFile;
import model.booking.Booking;
import model.saleitem.SaleItem;
import service.select.SelectBooking;
import service.select.SelectSaleItem;
import view.CommandLineTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ViewSaleItem {
    private String userId;
    Scanner scanner = new Scanner(System.in);

    public ViewSaleItem(String userId) {
        this.userId = userId;
    }

    public void viewSaleItem(ArrayList<SaleItem> listSaleItems) {
        this.showListInTable(listSaleItems);
        System.out.printf(" 1: Sort by id\n");
        System.out.printf(" 2: Sort by type\n");
        System.out.printf(" 3: Sort by issue date\n");
        System.out.printf(" 4: Sort by address\n");
        System.out.printf(" 5: Add to booking list\n");
        System.out.printf(" 6: Search\n");
        System.out.printf(" 7: Back\n");
        String consoleIn2 = scanner.nextLine();
        if (consoleIn2.equals("1")) {
            this.viewSaleItem(new SelectSaleItem().sortById(listSaleItems));
        }
        if (consoleIn2.equals("2")) {
            this.viewSaleItem(new SelectSaleItem().sortByType(listSaleItems));
        }
        if (consoleIn2.equals("3")) {
            this.viewSaleItem(new SelectSaleItem().sortByIssueDate(listSaleItems));
        }
        if (consoleIn2.equals("4")) {
            this.viewSaleItem(new SelectSaleItem().sortByAddress(listSaleItems));
        }
        if (consoleIn2.equals("5")) {
            System.out.printf("======================Add to list booking===================\n");
            System.out.printf(" Sale item 's id\n");
            String consoleIn3 = scanner.nextLine();
            this.addToBooking(new SelectSaleItem().getById(Integer.valueOf(consoleIn3), listSaleItems), userId);
        }
        if (consoleIn2.equals("6")) {
            this.searchSaleItem(listSaleItems);
        }
        if (consoleIn2.equals("")) {
            new ViewRenter(userId);
        }
    }

    public void addToBooking(SaleItem saleItem, String userId) {
        Date date = new Date();
        Booking booking = new Booking();
        booking = new SelectBooking().getById(Integer.valueOf(userId), new BookingFile().get());
        booking.setId(Integer.valueOf(userId));
        ArrayList listSaleId = booking.getSaleItemId();
        listSaleId.add(saleItem.getId());
        booking.setSaleItemId(listSaleId);
        booking.setTotalPrice(booking.getTotalPrice() + saleItem.getUnitPrice());
        booking.setIssueAudit(date);
        booking.setInfoSaleItem(booking.getInfoSaleItem() + "Type: " + saleItem.getType() + ", Address: " + saleItem.getAddress());
        new SelectBooking().save(booking);
        saleItem.setBooking(true);
        saleItem.setIssueAudit(date);
        new SelectSaleItem().update(saleItem);
    }

    public void showSaleItemInTable(SaleItem saleItem) {
        ArrayList<SaleItem> listSaleItem = new ArrayList<>();
        listSaleItem.add(saleItem);
        this.showListInTable(listSaleItem);
    }

    public void showListInTable(ArrayList<SaleItem> listsaleItem) {
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("Id", "Type", "Unit Price", "Number Preson", "Created Audit", "Update Audit", "Issue Audit", "Address", "Describe");
        for (SaleItem saleItem : listsaleItem) {
            CommandLineTable.addRow(String.valueOf(saleItem.getId()), saleItem.getType(), String.valueOf(saleItem.getUnitPrice()), String.valueOf(saleItem.getNumberOfPerson()), String.valueOf(saleItem.getCreatedAudit()), String.valueOf(saleItem.getUpdateAudit()), String.valueOf(saleItem.getIssueAudit()), saleItem.getAddress(), saleItem.getDescribe());
        }
        CommandLineTable.print();
    }

    public void searchSaleItem(ArrayList<SaleItem> saleItemsList) {
        System.out.println ("============Search Sale item============");
        System.out.println (" 1 : Search by Id : ");
        System.out.println (" 2 : Search by Address : ");
        System.out.println (" 3 : Search by Type : ");
        System.out.println (" 4 : Back ");
        String console5 = scanner.nextLine();
        if (console5.equals("1")) {
            System.out.printf(" Search sale item witd id = ");
            String console6 = scanner.nextLine();
            ArrayList<SaleItem> listSaleItem = new SelectSaleItem().getByAddress(console6, saleItemsList);
            SaleItem saleItem = new SelectSaleItem().getById(Integer.valueOf(console6), saleItemsList);
            listSaleItem.add(saleItem);
            if (saleItem.getId() != 0) {
                this.viewSaleItem(listSaleItem);
            } else {
                System.out.printf(" Sale item is null\n");
                this.viewSaleItem(saleItemsList);
            }
        }
        if (console5.equals("2")) {
            System.out.printf(" Search sale item witd address : ");
            String console6 = scanner.nextLine();
            ArrayList<SaleItem> listSaleItem = new SelectSaleItem().getByAddress(console6, saleItemsList);
            if (!listSaleItem.isEmpty()) {
                this.viewSaleItem(listSaleItem);
            } else {
                System.out.printf(" Sale item is null \n");
                this.viewSaleItem(saleItemsList);
            }

        }
        if (console5.equals("3")) {
            System.out.printf(" Search sale item witd type : ");
            String console6 = scanner.nextLine();
            ArrayList<SaleItem> listSaleItem = new SelectSaleItem().getByType(console6, saleItemsList);
            if (!listSaleItem.isEmpty()) {
                this.viewSaleItem(listSaleItem);
            } else {
                System.out.printf(" Sale item is null");
                this.viewSaleItem(saleItemsList);
            }
        }
        if (console5.equals("4")) {
            this.viewSaleItem(saleItemsList);
        }
    }
}
