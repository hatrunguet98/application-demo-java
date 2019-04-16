package service.select;

import model.saleitem.SaleItem;

import java.util.ArrayList;

public interface ISelect<T> {
    public ArrayList<T> getByHostId(String userId);
//    public T getById(String id);
    public void delete(String id);
    public void save(T t,String id);
    public ArrayList<T> sortByIssueDate(ArrayList<T> listT);
    public ArrayList<T> sortById(ArrayList<T> listT);
    public ArrayList<T> sortByType(ArrayList<T> listT);
    public ArrayList<T> sortByAddress(ArrayList<T> listT);
}
