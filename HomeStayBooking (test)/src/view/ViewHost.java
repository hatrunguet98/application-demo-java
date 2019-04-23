package view;

import model.booking.Booking;
import model.saleitem.SaleItem;
import model.user.User;
import service.select.SelectBooking;
import service.select.SelectSaleItem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewHost {
    Scanner scanner = new Scanner(System.in);

    private User host;

    public ViewHost(User host) {
        this.host = host;
    }

    public void viewHost() {
        System.out.printf("Show list sale item : 1\n");
        System.out.printf("Show list booking   : 2 \n");
        String consoleIn1 = scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (consoleIn1.equals("1")) {
            this.viewSaleItem();
        }
        if (consoleIn1.equals("2")) {
            this.viewBooking();
        } else {
            this.viewHost();
        }

    }

    public void viewSaleItem() {
        ArrayList<SaleItem> listSaleItems = new SelectSaleItem().getByHostId(this.host.getId());
        if (listSaleItems == null) {
            System.out.printf("List sale item is null : 1\n");
            this.createdSaleItem();
        } else {
            for (SaleItem saleItem : listSaleItems) {
                System.out.printf(saleItem.toString());
                System.out.printf("\n");
            }
        }
        System.out.printf("Created new Sale item : 1\n");
        System.out.printf("Delete Sale item : 2\n");
        System.out.printf("Edit Sale item : 3\n");

        String consoleIn2 = scanner.nextLine();

        if (consoleIn2.equals("1")) {
            this.createdSaleItem();
        }
        if (consoleIn2.equals("2")) {
            System.out.printf("Sale Item's id : \n");
            String consoleIn3 = scanner.nextLine();
            new SelectSaleItem().delete(consoleIn3);
            System.out.printf("\n");
        }
        if (consoleIn2.equals("3")) {

        }
    }

    public void viewBooking() {
        ArrayList<Booking> listBookings = new SelectBooking().getByHostId(this.host.getId());
    }

    public void createdSaleItem() {
        String hostId = this.host.getId();
        System.out.printf("Created new Sale item\n");
        System.out.printf("Sale item's id : ");
        String id = scanner.nextLine();
        System.out.printf("\n");
        System.out.printf("Sale item's type : ");
        String type = scanner.nextLine();
        System.out.printf("\n");
        System.out.printf("Sale item's rateType : ");
        System.out.printf("\n");
        System.out.printf(" Street View : 1");
        System.out.printf("\n");
        System.out.printf(" City view   : 2 ");
        System.out.printf("\n");
        System.out.printf(" Sea view    : 3 ");
        System.out.printf("\n");
        String rateType = scanner.nextLine();
        double rate = 0;
        if (rateType.equals("1")) rate = 1;
        if (rateType.equals("2")) rate = 1.2;
        if (rateType.equals("1")) rate = 1.5;
        LocalDate dateCreated = LocalDate.now();
        ArrayList<LocalDate> listdateAudit = new ArrayList<>();
        listdateAudit.add(dateCreated);
        System.out.printf("Sale item's address : ");
        String address = scanner.nextLine();
        System.out.printf("\n");
        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(id, type, rate, listdateAudit, address, hostId).build());
    }
//    public void createdListRoom(){
//        System.out.printf("Number bathroom : ");
//
//    }
}
