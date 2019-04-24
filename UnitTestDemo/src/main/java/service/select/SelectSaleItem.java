package service.select;

import dao.SaleItemFile;
import model.saleitem.SaleItem;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectSaleItem implements ISelect<SaleItem> {
    private ArrayList<SaleItem> listSaleItemFile;
    private ArrayList<SaleItem> listSaleItem;

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

    public ArrayList<SaleItem> getByBooking() {
        listSaleItemFile = new SaleItemFile().get();
        listSaleItem = new ArrayList<>();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            SaleItem saleItem = listSaleItemFile.get(i);
            if (!saleItem.isBooking()) {
                listSaleItem.add(saleItem);
            }
        }
        return listSaleItem;
    }

    public void update(SaleItem saleItem) {
        listSaleItemFile = new SaleItemFile().get();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            if (listSaleItemFile.get(i).getId() == saleItem.getId()) {
                listSaleItemFile.remove(i);
                listSaleItemFile.add(saleItem);
                break;
            }
        }
        new SaleItemFile().update(listSaleItemFile);
    }

    @Override
    public SaleItem getById(int id, ArrayList<SaleItem> saleItemsList) {
        SaleItem saleItem = new SaleItem();
        for (int i = 0; i < saleItemsList.size(); i++) {
            if (saleItemsList.get(i).getId() == id) {
                saleItem = saleItemsList.get(i);
                break;
            }
        }
        return saleItem;
    }

    @Override
    public void save(SaleItem saleItem) {
        listSaleItemFile = new SaleItemFile().get();
        listSaleItemFile.add(saleItem);
        new SaleItemFile().update(listSaleItemFile);
    }

    @Override
    public ArrayList<SaleItem> sortByIssueDate(ArrayList<SaleItem> listT) {
        return null;
    }

    @Override
    public void delete(int id) {
        listSaleItemFile = new SaleItemFile().get();
        for (int i = 0; i < listSaleItemFile.size(); i++) {
            if (listSaleItemFile.get(i).getId()==id) {
                listSaleItemFile.remove(i);
                break;
            }
        }
        new SaleItemFile().update(listSaleItemFile);
    }

    public ArrayList<SaleItem> sortByCreatedAudit(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getCreatedAudit));
        return listSaleItem;
    }

    @Override
    public ArrayList<SaleItem> sortById(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getId));
        return listSaleItem;
    }

    public ArrayList<SaleItem> sortByType(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getType));
        return listSaleItem;
    }

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
        listSaleItem.sort(Comparator.comparing(SaleItem::getUnitPrice));
    }


}
