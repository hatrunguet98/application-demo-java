package dao;

import java.util.ArrayList;

public interface IDao<T> {
    public void save(ArrayList<T> listT);

    public ArrayList<T> get();

    public void delete(ArrayList<T> listT);

}
