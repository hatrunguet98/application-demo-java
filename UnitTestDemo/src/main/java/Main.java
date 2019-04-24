
import model.saleitem.SaleItem;
import model.user.Host;
import model.user.User;
import service.select.SelectSaleItem;
import view.host.ViewHost;
import view.renter.ViewRenter;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User host = new Host("12", "Trung", "Trung", "Nd", 234, 23452345, 6);
        System.out.println("1: Host");
        System.out.println("2: Renter");
        String consoleIn = scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (consoleIn.equals("1")) {
            new ViewHost("12").viewHost();
        }
        if (consoleIn.equals("2")) {
            System.out.println("Your id");
            String consoleIn1 = scanner.nextLine();
            new ViewRenter(consoleIn1).viewRenter();
        }

//        Date date = new Date();
//        long DAY_IN_MS = 1000 * 60 * 60 * 24;
//        Date date5 = new Date(date.getTime() - (5 * DAY_IN_MS));
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(1, "Villa", 1.1, "Nha Trang", "12", 8, 3000000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(150).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(2, "House", 1.2, "Da Nang", "12", 4, 1500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(80).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(3, "House", 1.1, "Da Nang", "12", 6, 3000000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(100).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(4, "Hotel room", 1.5, "Sam Son", "12", 2, 450000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(40).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(5, "Hotel room", 1.1, "Sam Son", "12", 2, 500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(30).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(6, "Hotel room", 1.1, "Can Tho", "12", 4, 300000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(40).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(7, "Villa", 1.2, "Nha Trang", "12", 10, 3500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(200).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(8, "Villa", 1.8, "Nha Trang", "12", 8, 2500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(150).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(9, "Villa", 1.1, "Nha Trang", "12", 8, 3000000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(150).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(10, "House", 1.2, "Da Nang", "12", 4, 1500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(80).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(11, "House", 1.1, "Da Nang", "12", 6, 3000000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(100).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(20, "Hotel room", 1.5, "Sam Son", "12", 2, 450000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(40).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(23, "Hotel room", 1.1, "Sam Son", "12", 2, 500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(30).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(26, "Hotel room", 1.1, "Can Tho", "12", 4, 300000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(40).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(28, "Villa", 1.2, "Nha Trang", "12", 10, 3500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(200).build());
//        new SelectSaleItem().save(new SaleItem.SaleItemBuilder(30, "Villa", 1.8, "Nha Trang", "12", 8, 2500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(150).build());

    }
}
