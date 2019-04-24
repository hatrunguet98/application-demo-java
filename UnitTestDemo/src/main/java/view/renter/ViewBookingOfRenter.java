package view.renter;

import dao.BookingFile;
import dao.SaleItemFile;
import model.booking.Booking;
import model.saleitem.SaleItem;
import service.select.SelectBooking;
import service.select.SelectSaleItem;
import view.CommandLineTable;
import view.host.ViewBookingOfHost;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewBookingOfRenter {
    String userId;
    Scanner scanner = new Scanner(System.in);

    public ViewBookingOfRenter(String userId) {
        this.userId = userId;
    }

    public void viewBooking(Booking booking) {
        this.showBookingInTable(booking);
        System.out.println(" 1: Delete Booking");
        System.out.println(" 2: Delete Sale item");
        System.out.println(" 3: Back");
        String consoleIn2 = scanner.nextLine();
        if (consoleIn2.equals("1")) {
            System.out.println("============= Delete Booking ============= ");
            System.out.println("Booking id : \n");
            String consoleIn3 = scanner.nextLine();
            new SelectBooking().delete(Integer.valueOf(consoleIn3));
            System.out.printf("\n");
            this.viewBooking(new SelectBooking().getById(Integer.valueOf(userId), new BookingFile().get()));
        }
        if (consoleIn2.equals("1")) {
            System.out.println("============= Delete Sale item ============= ");
            System.out.println("SaleItem id : \n");
            ArrayList listIdSale = new ArrayList();
            listIdSale = booking.getSaleItemId();
            String consoleIn3 = scanner.nextLine();
            for(int i=0;i<listIdSale.size();i++){
                if(listIdSale.get(i)==consoleIn3){
                    listIdSale.remove(i);
                    break;
                }
            }
            System.out.printf("\n");
            new SelectBooking().update(booking);
            this.viewBooking(new SelectBooking().getById(Integer.valueOf(userId), new BookingFile().get()));
        }
        if (consoleIn2.equals("3")) {
            new ViewRenter(userId).viewRenter();
        }
    }


    public void showBookingInTable(Booking booking) {
        SaleItem saleItem = new SaleItem();
        ArrayList<Integer> listIdSaleItem = booking.getSaleItemId();
        ArrayList<SaleItem> listSaleItem = new SaleItemFile().get();
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("Id", "Type", "Unit Price", "Number Preson", "Created Audit", "Update Audit", "Issue Audit", "Address", "Describe");
        for (int i = 0; i < listIdSaleItem.size(); i++) {
            saleItem = new SelectSaleItem().getById(listIdSaleItem.get(i), listSaleItem);
            CommandLineTable.addRow(String.valueOf(saleItem.getId()), saleItem.getType(), String.valueOf(saleItem.getUnitPrice()), String.valueOf(saleItem.getNumberOfPerson()), String.valueOf(saleItem.getCreatedAudit()), String.valueOf(saleItem.getUpdateAudit()), String.valueOf(saleItem.getIssueAudit()), saleItem.getAddress(), saleItem.getDescribe());
        }
        CommandLineTable.print();
        System.out.println("Total Price: " + booking.getTotalPrice());
    }
}
