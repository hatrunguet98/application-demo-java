package service.select;

import dao.SaleItemFile;
import model.saleitem.SaleItem;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectSaleItem {
    private ArrayList<SaleItem> listSaleItemFile;
    private ArrayList<SaleItem> listSaleItem;

    public ArrayList<SaleItem> getByHostId(String userId) {
        listSaleItemFile = new SaleItemFile().get();
        listSaleItem = new ArrayList<>();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            SaleItem saleItem = listSaleItemFile.get(i);
            if (saleItem.getHostId().equalsIgnoreCase(userId)) {
                listSaleItem.add(saleItem);
            }
        }
        return listSaleItem;
    }

    public SaleItem getById(String id) {
        listSaleItemFile = new SaleItemFile().get();
        SaleItem saleItem = new SaleItem();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            saleItem = listSaleItemFile.get(i);
            if (saleItem.getHostId().equalsIgnoreCase(id)) {
                break;
            }
        }
        return saleItem;
    }

    public ArrayList<SaleItem> getByType(String type) {
        listSaleItemFile = new SaleItemFile().get();
        listSaleItem = new ArrayList<>();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            SaleItem saleItem = listSaleItemFile.get(i);
            if (saleItem.getType().equalsIgnoreCase(type)) {
                listSaleItem.add(saleItem);
            }
        }
        return listSaleItem;
    }

    public void delete(String id) {
        listSaleItemFile = new SaleItemFile().get();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            if (listSaleItemFile.get(i).getHostId().equalsIgnoreCase(id)) {
                listSaleItemFile.remove(i);
                break;
            }
        }
        new SaleItemFile().delete(listSaleItemFile);
    }


    public void save(SaleItem saleItem) {
        listSaleItemFile = new SaleItemFile().get();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            if (listSaleItemFile.get(i).getHostId().equalsIgnoreCase(saleItem.getId())) {
                listSaleItemFile.remove(i);
                break;
            }
        }
        listSaleItemFile.add(saleItem);
        new SaleItemFile().delete(listSaleItemFile);
    }

    public void sortByPrice(ArrayList<SaleItem> listSaleItem){
        listSaleItem.sort(Comparator.comparing(SaleItem::getUnitPrice));
    }
    public void sortByIssueDate(ArrayList<SaleItem> listSaleItem){
        listSaleItem.sort(Comparator.comparing(SaleItem::getDateAudit));
    }
}
