package unittest;

import model.saleitem.SaleItem;
import org.junit.Before;
import org.junit.Test;
import service.select.SelectSaleItem;

import java.util.ArrayList;
import java.util.Date;

public class SelectSaleItemTest {
    ArrayList<SaleItem> saleItems;
    SaleItem saleItem;

    @Before
    private void setUp() {
        saleItems= new ArrayList<>();
        Date date = new Date();
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date date5 = new Date(date.getTime() - (5 * DAY_IN_MS));
        saleItems.add(new SaleItem.SaleItemBuilder(1, "Villa", 1.1, "Nha Trang", "12", 8, 3000000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(150).build());
        saleItems.add(new SaleItem.SaleItemBuilder(2, "House", 1.2, "Da Nang", "12", 4, 1500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(80).build());
        saleItems.add(new SaleItem.SaleItemBuilder(3, "House", 1.1, "Da Nang", "12", 6, 3000000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(100).build());
        saleItems.add(new SaleItem.SaleItemBuilder(4, "Hotel room", 1.5, "Sam Son", "12", 2, 450000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(40).build());
        saleItems.add(new SaleItem.SaleItemBuilder(5, "Hotel room", 1.1, "Sam Son", "12", 2, 500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(30).build());
        saleItems.add(new SaleItem.SaleItemBuilder(6, "Hotel room", 1.1, "Can Tho", "12", 4, 300000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(40).build());
        saleItems.add(new SaleItem.SaleItemBuilder(7, "Villa", 1.2, "Nha Trang", "12", 10, 3500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(200).build());
        saleItems.add(new SaleItem.SaleItemBuilder(8, "Villa", 1.8, "Nha Trang", "12", 8, 2500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(150).build());
        saleItems.add(new SaleItem.SaleItemBuilder(9, "Villa", 1.1, "Nha Trang", "12", 8, 3000000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(150).build());
        saleItems.add(new SaleItem.SaleItemBuilder(10, "House", 1.2, "Da Nang", "12", 4, 1500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(80).build());
        saleItems.add(new SaleItem.SaleItemBuilder(11, "House", 1.1, "Da Nang", "12", 6, 3000000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(100).build());
        saleItems.add(new SaleItem.SaleItemBuilder(20, "Hotel room", 1.5, "Sam Son", "12", 2, 450000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(40).build());
        saleItems.add(new SaleItem.SaleItemBuilder(323, "Hotel room", 1.1, "Sam Son", "12", 2, 500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(30).build());
        saleItems.add(new SaleItem.SaleItemBuilder(261, "Hotel room", 1.1, "Can Tho", "12", 4, 300000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(40).build());
        saleItems.add(new SaleItem.SaleItemBuilder(28, "Villa", 1.2, "Nha Trang", "12", 10, 3500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(200).build());
        saleItems.add(new SaleItem.SaleItemBuilder(30, "Villa", 1.8, "Nha Trang", "12", 8, 2500000).setCreatedAudit(date5).setDescribe("View nhin bien").setAcreage(150).build());
    }

    @Test(timeout = 100)
    public void getListSaleItemByHostTest() {
        saleItems = new SelectSaleItem().getByHostId("12");
    }

}
