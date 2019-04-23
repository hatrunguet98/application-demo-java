package view;

import dao.SaleItemFile;
import model.saleitem.SaleItem;
import model.user.User;
import service.select.SelectSaleItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
            this.viewSaleItem(new SelectSaleItem().getByHostId(this.host.getId()));
        }
        if (consoleIn1.equals("2")) {
            this.viewBooking();
        } else {
            this.viewHost();
        }
    }

    public void viewSaleItem(ArrayList<SaleItem> listSaleItems) {
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("Id", "Type", "Total Price", "Created Audit", "UpdateAudit", "Issue Audit", "Address", "Describe");
        for (SaleItem saleItem : listSaleItems) {
            CommandLineTable.addRow(saleItem.getId(), saleItem.getType(), String.valueOf(saleItem.getTotalPrice()), String.valueOf(saleItem.getCreatedAudit()), String.valueOf(saleItem.getUpdateAudit()), String.valueOf(saleItem.getIssueAudit()), saleItem.getAddress(), saleItem.getDescribe());
        }
        CommandLineTable.print();

        System.out.printf(" 1: Created new Sale item\n");
        System.out.printf(" 2: Delete Sale item\n");
        System.out.printf(" 3: Edit Sale item\n");
        System.out.printf(" 4: Sort by id\n");
        System.out.printf(" 5: Sort by type\n");
        System.out.printf(" 6: Sort by issue date\n");
        System.out.printf(" 7: Back\n");

        String consoleIn2 = scanner.nextLine();

        if (consoleIn2.equals("1")) {
            this.createdSaleItem();
            this.viewSaleItem(new SelectSaleItem().getByHostId(this.host.getId()));
        }
        if (consoleIn2.equals("2")) {
            System.out.printf("Sale Item's id : \n");
            String consoleIn3 = scanner.nextLine();
            new SelectSaleItem().delete(consoleIn3);
            System.out.printf("\n");
            this.viewSaleItem(new SelectSaleItem().getByHostId(this.host.getId()));
        }
        if (consoleIn2.equals("3")) {
            System.out.printf("Sale Item's id : \n");
            String consoleIn3 = scanner.nextLine();
            CommandLineTable.removeRow();
            SaleItem saleItem = new SelectSaleItem().getById(consoleIn3);
            CommandLineTable.setHeaders("Id", "Type", "Total Price", "Created Audit", "UpdateAudit", "Issue Audit", "Address", "Describe");
            CommandLineTable.addRow(saleItem.getId(), saleItem.getType(), String.valueOf(saleItem.getTotalPrice()), String.valueOf(saleItem.getCreatedAudit()), String.valueOf(saleItem.getUpdateAudit()), String.valueOf(saleItem.getIssueAudit()), saleItem.getAddress(), saleItem.getDescribe());
            CommandLineTable.print();
            this.createdSaleItem();
        }
        if (consoleIn2.equals("4")) {
            new SelectSaleItem().sortById(listSaleItems);
            this.viewSaleItem(new SelectSaleItem().getByHostId(this.host.getId()));
        }
        if (consoleIn2.equals("5")) {
            new SelectSaleItem().sortByType(listSaleItems);
            this.viewSaleItem(new SelectSaleItem().getByHostId(this.host.getId()));
        }
        if (consoleIn2.equals("6")) {
            new SelectSaleItem().sortByIssueDate(listSaleItems);
            this.viewSaleItem(new SelectSaleItem().getByHostId(this.host.getId()));
        }
        if (consoleIn2.equals("7")) {
            this.viewHost();
        }
    }

    public void viewBooking() {
    }

    public void createdSaleItem() {
        Date date = new Date();
        String hostId = this.host.getId();
        System.out.printf("============Created new Sale item============");
        System.out.printf("\n");
        System.out.printf("Sale item's id : ");
        String id = scanner.nextLine();
        System.out.printf("\n");
        System.out.printf("Sale item's type : ");
        String type = scanner.nextLine();
        System.out.printf("\n");
        System.out.printf("Sale item's numberOfPerson : ");
        String nuPer = scanner.nextLine();
        int numberOfPerson = Integer.valueOf(nuPer);
        System.out.printf("\n");
        System.out.printf("Sale item's descride : ");
        String descride = scanner.nextLine();
        System.out.printf("\n");
        System.out.printf("Sale item's totalPrice : ");
        String total = scanner.nextLine();
        double totalPrice = Double.valueOf(total);
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
        if (rateType.equals("1")) rate = 1.1;
        if (rateType.equals("2")) rate = 1.2;
        if (rateType.equals("1")) rate = 1.5;
        else rate = 1;
        LocalDate dateCreated = LocalDate.now();
        ArrayList<LocalDate> listdateAudit = new ArrayList<>();
        listdateAudit.add(dateCreated);
        System.out.printf("Sale item's address : ");
        String address = scanner.nextLine();
        System.out.printf("\n");
        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(id, type, rate, address, hostId, numberOfPerson, totalPrice).setCreatedAudit(date).setIssueAudit(date).setIssueAudit(date).setDescribe(descride).build(), id);
    }
//    public void updateSaleItem(SaleItem saleItem) {
//        Date date = new Date();
//        String hostId = this.host.getId();
//        System.out.printf("============Update Sale item============");
//        System.out.printf("\n");
//        System.out.printf("Sale item's id : ");
//        String id = scanner.nextLine();
//        System.out.printf("\n");
//        System.out.printf("Sale item's type : ");
//        String type = scanner.nextLine();
//        System.out.printf("\n");
//        System.out.printf("Sale item's numberOfPerson : ");
//        String nuPer = scanner.nextLine();
//        int numberOfPerson = Integer.valueOf(nuPer);
//        System.out.printf("\n");
//        System.out.printf("Sale item's descride : ");
//        String descride = scanner.nextLine();
//        System.out.printf("\n");
//        System.out.printf("Sale item's totalPrice : ");
//        String total = scanner.nextLine();
//        double totalPrice=Double.valueOf(total);
//        System.out.printf("\n");
//        System.out.printf("Sale item's rateType : ");
//        System.out.printf("\n");
//        System.out.printf(" Street View : 1");
//        System.out.printf("\n");
//        System.out.printf(" City view   : 2 ");
//        System.out.printf("\n");
//        System.out.printf(" Sea view    : 3 ");
//        System.out.printf("\n");
//        String rateType = scanner.nextLine();
//        double rate = 0;
//        if (rateType.equals("1")) rate = 1.1;
//        if (rateType.equals("2")) rate = 1.2;
//        if (rateType.equals("1")) rate = 1.5;
//        else rate = 1;
//        LocalDate dateCreated = LocalDate.now();
//        ArrayList<LocalDate> listdateAudit = new ArrayList<>();
//        listdateAudit.add(dateCreated);
//        System.out.printf("Sale item's address : ");
//        String address = scanner.nextLine();
//        System.out.printf("\n");
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(id, type, rate, address, hostId, numberOfPerson, totalPrice).setCreatedAudit(date).setIssueAudit(date).setIssueAudit(date).setDescribe(descride).build());
//    }
}
