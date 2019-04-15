package service.dao;

import java.util.ArrayList;

public interface IDao<T> {
    public void save(ArrayList<T> listT);

    public ArrayList<T> get();
}
