package service.select;
import dao.SaleItemFile;
import model.saleitem.SaleItem;
import java.util.ArrayList;
import java.util.Comparator;

public class SelectSaleItem implements ISelect<SaleItem> {
    private ArrayList<SaleItem> listSaleItemFile;
    private ArrayList<SaleItem> listSaleItem;

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

    public void sortByPrice(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getTotalPrice));
    }

    @Override
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

    @Override
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

    @Override
    public void sortByIssueDate(ArrayList<SaleItem> listSaleItem) {
        listSaleItem.sort(Comparator.comparing(SaleItem::getDateIssuedAudit));
    }
}
