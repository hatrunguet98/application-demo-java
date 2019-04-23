package view.host;

import dao.BookingFile;
import model.booking.Booking;
import service.select.SelectBooking;
import view.CommandLineTable;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewBookingOfHost {
    String userId;
    Scanner scanner = new Scanner(System.in);

    public ViewBookingOfHost(String userId) {
        this.userId = userId;
    }

    public void viewBooking(ArrayList<Booking> listBooking) {
        this.showListInTable(listBooking);
        System.out.printf(" 1: Delete Booking\n");
        System.out.printf(" 2: Sort by id\n");
        System.out.printf(" 3: Sort by issue date\n");
        System.out.printf(" 4: Sort by total price p\n");
        System.out.printf(" 5: Back\n");
        String consoleIn2 = scanner.nextLine();
        if (consoleIn2.equals("1")) {
            System.out.printf("==============Delete Booking============= \n");
            System.out.printf("Booking id : \n");
            String consoleIn3 = scanner.nextLine();
            new SelectBooking().delete(consoleIn3);
            System.out.printf("\n");
            this.viewBooking(new BookingFile().get());
        }
        if (consoleIn2.equals("2")) {
            this.viewBooking(new SelectBooking().sortById(listBooking));
        }
        if (consoleIn2.equals("3")) {
            this.viewBooking(new SelectBooking().sortByIssueDate(listBooking));
        }
        if (consoleIn2.equals("4")) {
            this.viewBooking(new SelectBooking().sortByTotal(listBooking));
        }
        if (consoleIn2.equals("5")) {
            new ViewHost(userId).viewHost();
        }
    }


    public void showBookingInTable(Booking booking) {
        ArrayList<Booking> listBooking = new ArrayList<>();
        listBooking.add(booking);
        this.showListInTable(listBooking);
    }

    public void showListInTable(ArrayList<Booking> listBooking) {
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("Id", "Info about sale item", "Total Price", "Issue Audit");
        for (Booking booking : listBooking) {
            CommandLineTable.addRow(booking.getId(), booking.getInfoSaleItem(), String.valueOf(booking.getTotalPrice()), String.valueOf(booking.getIssueAudit()));
        }
        CommandLineTable.print();
    }
}

