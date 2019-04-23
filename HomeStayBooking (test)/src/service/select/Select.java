//package service.select;
//
//import dao.DaoToFile;
//import model.booking.Booking;
//
//import java.util.ArrayList;
//
//public abstract class Select<T> {
//    private ArrayList<T> listTFile;
//    private ArrayList<T> listT;
//
//    public ArrayList<T> getByHostId(String userId) {
//        listTFile = new DaoToFile<T>().get();
//        listSaleItem = new ArrayList<>();
//        for (int i = 0; i < listSaleItemFile.size(); i++) {
//            SaleItem saleItem = listSaleItemFile.get(i);
//            if (saleItem.getHostId().equalsIgnoreCase(userId)) {
//                listSaleItem.add(saleItem);
//            }
//        }
//        return listSaleItem;
//    }
//}
