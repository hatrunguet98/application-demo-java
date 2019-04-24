package view.renter;

import dao.BookingFile;
import service.select.SelectBooking;
import service.select.SelectSaleItem;
import view.host.ViewBookingOfHost;

import java.util.Scanner;

public class ViewRenter {
    Scanner scanner = new Scanner(System.in);

    private String userId;

    public ViewRenter(String userId) {
        this.userId = userId;
    }

    public void viewRenter() {
        System.out.println("Show list sale item : 1");
        System.out.println("Show list booking   : 2 ");
        String consoleIn1 = scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (consoleIn1.equals("1")) {
            new ViewSaleItem(userId).viewSaleItem(new SelectSaleItem().getByBooking());
        }
        if (consoleIn1.equals("2")) {
            new ViewBookingOfRenter(userId).viewBooking(new SelectBooking().getById(Integer.valueOf(userId), new BookingFile().get()));
        } else {
            this.viewRenter();
        }
    }
}
