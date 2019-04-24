package view.host;

import dao.BookingFile;
import model.booking.Booking;
import model.saleitem.SaleItem;
import service.select.SelectSaleItem;
import view.CommandLineTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ViewReport {
    String userId;
    Scanner scanner = new Scanner(System.in);

    public ViewReport(String userId) {
        this.userId = userId;
    }

    public void viewReport() {
        ArrayList<SaleItem> saleItemsList = new SelectSaleItem().getByHostId(userId);
        ArrayList<Booking> bookingList = new BookingFile().get();
        ArrayList<Booking> booking5DayAgo = this.listBookingDayAgo(bookingList);
        System.out.printf("Total price of salitem : ");
        System.out.printf(String.valueOf(this.getTotalPriceSaleItem(saleItemsList)));
        System.out.printf("\n");
        System.out.printf("Total price of booking : ");
        System.out.printf(String.valueOf(this.getTotalPriceBooking(bookingList)));
        System.out.printf("\n");
        System.out.printf("List sale item in 5 day ago");
        System.out.printf("\n");
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("Id", "Type", "Unit Price", "Booking", "Number Preson", "Created Audit", "Update Audit", "Issue Audit", "Address", "Describe");
        for (SaleItem saleItem : this.listSaleItemDayAgo(saleItemsList)) {
            CommandLineTable.addRow(String.valueOf(saleItem.getId()), saleItem.getType(), String.valueOf(saleItem.getUnitPrice()), String.valueOf(saleItem.isBooking()), String.valueOf(saleItem.getNumberOfPerson()), String.valueOf(saleItem.getCreatedAudit()), String.valueOf(saleItem.getUpdateAudit()), String.valueOf(saleItem.getIssueAudit()), saleItem.getAddress(), saleItem.getDescribe());
        }
        CommandLineTable.print();
        System.out.printf("\n");
        if (!booking5DayAgo.isEmpty()) {
            System.out.printf("List booking in 5 day ago");
            System.out.printf("\n");
            CommandLineTable.removeRow();
            CommandLineTable.setHeaders("Id", "Info about sale item", "Total Price", "Issue Audit");
            for (Booking booking : booking5DayAgo) {
                CommandLineTable.addRow(String.valueOf(booking.getId()), booking.getInfoSaleItem(), String.valueOf(booking.getTotalPrice()), String.valueOf(booking.getIssueAudit()));
            }
            CommandLineTable.print();
        } else {
            System.out.println("List booking in 5 day ago is null");
        }

        System.out.println(" 1 : Export report to file");
        System.out.println(" 2 : Back");
        String consoleIn1 = scanner.nextLine();
        new ViewHost(userId).viewHost();
    }

    public double getTotalPriceSaleItem(ArrayList<SaleItem> saleItemsList) {
        double totalPrice = 0;
        for (SaleItem saleItem : saleItemsList) {
            totalPrice += saleItem.getUnitPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceBooking(ArrayList<Booking> bookingList) {
        double totalPrice = 0;
        for (Booking booking : bookingList) {
            totalPrice += booking.getTotalPrice();
        }
        return totalPrice;
    }

    public ArrayList<SaleItem> listSaleItemDayAgo(ArrayList<SaleItem> saleItemsList) {
        ArrayList<SaleItem> listSaleItem = new ArrayList<>();
        Date date = new Date();
        for (SaleItem saleItem : saleItemsList) {
            long days = date.getTime() - saleItem.getCreatedAudit().getTime();
            long day = TimeUnit.MILLISECONDS.toDays(days);
            if (5 <= day & day <= 6) {
                listSaleItem.add(saleItem);
            }
        }
        return listSaleItem;
    }

    public ArrayList<Booking> listBookingDayAgo(ArrayList<Booking> bookingList) {
        ArrayList<Booking> listBooking = new ArrayList<>();
        Date date = new Date();
        for (Booking booking : bookingList) {
            long days = date.getTime() - booking.getIssueAudit().getTime();
            long day = TimeUnit.MILLISECONDS.toDays(days);
            if (5 <= day & day <= 6) {
                listBooking.add(booking);
            }
        }
        return listBooking;
    }

    public void exportReport() {

    }
}
