package view.host;

import dao.BookingFile;
import dao.SaleItemFile;
import service.select.SelectBooking;
import service.select.SelectSaleItem;

import java.util.Scanner;

public class ViewHost {
    Scanner scanner = new Scanner(System.in);

    private String userId;

    public ViewHost(String userId) {
        this.userId = userId;
    }

    public void viewHost() {
        System.out.printf(" 1 : Show list sale item \n");
        System.out.printf(" 2 : Show list booking\n");
        System.out.printf(" 3 : View report\n");
        String consoleIn1 = scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (consoleIn1.equals("1")) {
            new ViewSaleItemOfHost(userId).viewSaleItem(new SelectSaleItem().getByHostId(userId));
        }
        if (consoleIn1.equals("2")) {
            new ViewBookingOfHost(userId).viewBooking(new BookingFile().get());
        }
        if (consoleIn1.equals("3")) {
            new ViewReport(userId).viewReport();
        }
        else {
            this.viewHost();
        }
    }
}
