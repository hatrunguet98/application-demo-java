package service.select;

import dao.SaleItemFile;
import model.saleitem.SaleItem;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectSaleItem implements ISelect<SaleItem> {
    private ArrayList<SaleItem> listSaleItemFile;
    private ArrayList<SaleItem> listSaleItem;

    @Override
    public ArrayList<SaleItem> getByHostId(String hostId) {
        listSaleItemFile = new SaleItemFile().get();
        listSaleItem = new ArrayList<>();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            SaleItem saleItem = listSaleItemFile.get(i);
            if (saleItem.getHostId().equalsIgnoreCase(hostId)) {
                listSaleItem.add(saleItem);
            }
        }
        return listSaleItem;
    }

    public SaleItem getById(String id, ArrayList<SaleItem> saleItemsList) {
        SaleItem saleItem = new SaleItem();
        for (int i = 0; i < saleItemsList.size(); i++) {
            saleItem = saleItemsList.get(i);
            if (saleItem.getId().equalsIgnoreCase(id)) {
                break;
            }
        }
        return saleItem;
    }

    @Override
    public void save(SaleItem saleItem, String id) {
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

    @Override
    public void delete(String id) {
        listSaleItemFile = new SaleItemFile().get();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            if (listSaleItemFile.get(i).getId().equalsIgnoreCase(id)) {
                listSaleItemFile.remove(i);
                break;
            }
        }
        new SaleItemFile().delete(listSaleItemFile);
    }

    @Override
    public ArrayList<SaleItem> sortByIssueDate(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getIssueAudit));
        return listSaleItem;
    }

    @Override
    public ArrayList<SaleItem> sortById(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getId));
        return listSaleItem;
    }

    @Override
    public ArrayList<SaleItem> sortByType(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getType));
        return listSaleItem;
    }

    @Override
    public ArrayList<SaleItem> sortByAddress(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getAddress));
        return listSaleItem;
    }

    public ArrayList<SaleItem> getByType(String type, ArrayList<SaleItem> saleItemsList) {
        listSaleItem = new ArrayList<>();
        for (int i = 0; i < saleItemsList.size(); i++) {
            SaleItem saleItem = saleItemsList.get(i);
            if (saleItem.getType().equalsIgnoreCase(type)) {
                listSaleItem.add(saleItem);
            }
        }
        return listSaleItem;
    }

    public ArrayList<SaleItem> getByAddress(String address, ArrayList<SaleItem> saleItemsList) {
        listSaleItem = new ArrayList<>();
        for (int i = 0; i < saleItemsList.size(); i++) {
            SaleItem saleItem = saleItemsList.get(i);
            if (saleItem.getAddress().equalsIgnoreCase(address)) {
                listSaleItem.add(saleItem);
            }
        }
        return listSaleItem;
    }

    public void sortByPrice(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getTotalPrice));
    }


}
