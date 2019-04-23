package service.select;

import java.util.ArrayList;

public interface ISelect<T> {
    public T getById(String id, ArrayList<T> listT);

    public void delete(String id);

    public void save(T t);

    public ArrayList<T> sortByIssueDate(ArrayList<T> listT);

    public ArrayList<T> sortById(ArrayList<T> listT);
}
