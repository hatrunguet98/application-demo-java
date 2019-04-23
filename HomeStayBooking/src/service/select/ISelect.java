package service.select;

import model.saleitem.SaleItem;

import java.util.ArrayList;

public interface ISelect<T> {
    public ArrayList<T> getByHostId(String userId);
    public T getById(String id);
    public void delete(String id);
    public void save(T t,String id);
    public void sortByIssueDate(ArrayList<T> listT);
    public void sortById(ArrayList<T> listT);
    public void sortByType(ArrayList<T> listT);
}
