package view.host;

import model.saleitem.SaleItem;
import service.select.SelectSaleItem;
import view.CommandLineTable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ViewSaleItemOfHost {
    String userId;
    Scanner scanner = new Scanner(System.in);

    public ViewSaleItemOfHost(String userId) {
        this.userId = userId;
    }

    public void viewSaleItem(ArrayList<SaleItem> listSaleItems) {
        this.showListInTable(listSaleItems);
        System.out.printf(" 1: Created new Sale item\n");
        System.out.printf(" 2: Delete Sale item\n");
        System.out.printf(" 3: Edit Sale item\n");
        System.out.printf(" 4: Sort by id\n");
        System.out.printf(" 5: Sort by type\n");
        System.out.printf(" 6: Sort by created date\n");
        System.out.printf(" 7: Sort by address\n");
//        System.out.printf(" 8: Search\n");
        System.out.printf(" 8: Update\n");
        System.out.printf(" 9: Back\n");
        String consoleIn2 = scanner.nextLine();
        if (consoleIn2.equals("1")) {
            this.createdSaleItem();
            this.viewSaleItem(new SelectSaleItem().getByHostId(userId));
        }
        if (consoleIn2.equals("2")) {
            System.out.printf("Sale Item's id : \n");
            String consoleIn3 = scanner.nextLine();
            new SelectSaleItem().delete(Integer.valueOf(consoleIn3));
            System.out.printf("\n");
            this.viewSaleItem(new SelectSaleItem().getByHostId(userId));
        }
        if (consoleIn2.equals("3")) {
            System.out.printf("Sale Item's id : \n");
            String consoleIn3 = scanner.nextLine();
            SaleItem saleItem = new SelectSaleItem().getById(Integer.valueOf(consoleIn3), listSaleItems);

            this.createdSaleItem();
        }
        if (consoleIn2.equals("4")) {
            this.viewSaleItem(new SelectSaleItem().sortById(listSaleItems));
        }
        if (consoleIn2.equals("5")) {
            this.viewSaleItem(new SelectSaleItem().sortByType(listSaleItems));
        }
        if (consoleIn2.equals("6")) {
            this.viewSaleItem(new SelectSaleItem().sortByCreatedAudit(listSaleItems));
        }
        if (consoleIn2.equals("7")) {
            this.viewSaleItem(new SelectSaleItem().sortByAddress(listSaleItems));
        }
        if (consoleIn2.equals("8")) {
            System.out.printf("Sale Item's id : \n");
            String consoleIn3 = scanner.nextLine();
            this.updateSaleItem(new SelectSaleItem().getById(Integer.valueOf(consoleIn3), listSaleItems));
            System.out.printf("\n");
            this.viewSaleItem(new SelectSaleItem().getByHostId(userId));
        }
//        if (consoleIn2.equals("8")) {
//            this.searchSaleItem(listSaleItems);
//        }
        if (consoleIn2.equals("")) {
            new ViewHost(userId);
        }
    }


    public void showSaleItemInTable(SaleItem saleItem) {
        ArrayList<SaleItem> listSaleItem = new ArrayList<>();
        listSaleItem.add(saleItem);
        this.showListInTable(listSaleItem);
    }

    public void showListInTable(ArrayList<SaleItem> listsaleItem) {
        CommandLineTable.removeRow();
        CommandLineTable.setHeaders("Id", "Type", "Unit Price", "Booking", "Number Preson", "Created Audit", "Update Audit", "Issue Audit", "Address", "Describe");
        for (SaleItem saleItem : listsaleItem) {
            CommandLineTable.addRow(String.valueOf(saleItem.getId()), saleItem.getType(), String.valueOf(saleItem.getUnitPrice()), String.valueOf(saleItem.isBooking()), String.valueOf(saleItem.getNumberOfPerson()), String.valueOf(saleItem.getCreatedAudit()), String.valueOf(saleItem.getUpdateAudit()), String.valueOf(saleItem.getIssueAudit()), saleItem.getAddress(), saleItem.getDescribe());
        }
        CommandLineTable.print();
    }

    public void viewBooking() {
    }


//    public void searchSaleItem(ArrayList<SaleItem> saleItemsList) {
//        System.out.printf("===========Search Sale item============");
//        System.out.printf("\n");
//        System.out.printf(" 1 : Search by Id : ");
//        System.out.printf("\n");
//        System.out.printf(" 2 : Search by Address : ");
//        System.out.printf("\n");
//        System.out.printf(" 3 : Search by Type : ");
//        System.out.printf("\n");
//        System.out.printf(" 4 : Back ");
//        System.out.printf("\n");
//        String console5 = scanner.nextLine();
//        if (console5.equals("1")) {
//            System.out.printf(" Search sale item witd id = ");
//            String console6 = scanner.nextLine();
//            ArrayList<SaleItem> listSaleItem = new SelectSaleItem().getByAddress(console6, saleItemsList);
//            SaleItem saleItem = new SelectSaleItem().getById(console6, saleItemsList);
//            listSaleItem.add(saleItem);
//            if (saleItem.getId() != null) {
//                this.viewSaleItem(listSaleItem);
//            } else {
//                System.out.printf(" Sale item is null\n");
//                this.viewSaleItem(saleItemsList);
//            }
//        }
//        if (console5.equals("2")) {
//            System.out.printf(" Search sale item witd address : ");
//            String console6 = scanner.nextLine();
//            ArrayList<SaleItem> listSaleItem = new SelectSaleItem().getByAddress(console6, saleItemsList);
//            if (!listSaleItem.isEmpty()) {
//                this.viewSaleItem(listSaleItem);
//            } else {
//                System.out.printf(" Sale item is null \n");
//                this.viewSaleItem(saleItemsList);
//            }
//
//        }
//        if (console5.equals("3")) {
//            System.out.printf(" Search sale item witd type : ");
//            String console6 = scanner.nextLine();
//            ArrayList<SaleItem> listSaleItem = new SelectSaleItem().getByType(console6, saleItemsList);
//            if (!listSaleItem.isEmpty()) {
//                this.viewSaleItem(listSaleItem);
//            } else {
//                System.out.printf(" Sale item is null");
//                this.viewSaleItem(saleItemsList);
//            }
//        }
//        if (console5.equals("4")) {
//            this.viewSaleItem(saleItemsList);
//        }
//    }

    public void createdSaleItem() {
        Date date = new Date();
        String hostId = userId;
        System.out.printf("============Created new Sale item============");
        System.out.printf("\n");
        System.out.printf("Sale item's id : ");
        String idConsole = scanner.nextLine();
        int id = Integer.valueOf(idConsole);
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
        System.out.printf("Sale item's Unit Price : ");
        String total = scanner.nextLine();
        double totalPrice = Double.valueOf(total);
        System.out.printf("\n");
        System.out.printf("Sale item's acreageIn(m2) : ");
        String acreageIn = scanner.nextLine();
        double acreage = Double.valueOf(total);
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
        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(id, type, rate, address, hostId, numberOfPerson, totalPrice).setCreatedAudit(date).setDescribe(descride).setAcreage(acreage).build());
    }

    public void updateSaleItem(SaleItem saleItem) {
        Date date = new Date();
        String hostId = userId;
        System.out.printf("============Update new Sale item============");
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
        System.out.printf("Sale item's acreageIn(m2) : ");
        String acreageIn = scanner.nextLine();
        double acreage = Double.valueOf(total);
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
        System.out.printf("Sale item's address : ");
        String address = scanner.nextLine();
        System.out.printf("\n");
        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(saleItem.getId(), type, rate, address, hostId, numberOfPerson, totalPrice).setUpdateAudit(date).setDescribe(descride).setAcreage(acreage).build());
    }
}
