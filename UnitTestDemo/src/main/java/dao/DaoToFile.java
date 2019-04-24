package dao;

import java.io.*;
import java.util.ArrayList;

public abstract class DaoToFile<T> implements IDao {
    FileOutputStream fout = null;
    ObjectOutputStream bout = null;
    FileInputStream fin = null;
    ObjectInputStream bin = null;

    @Override
    public void save(ArrayList listT) {
        try {
            fout = new FileOutputStream("./" + this.getClass().getSimpleName() + ".txt", true);
            bout = new ObjectOutputStream(fout);
            bout.writeObject(listT);
            bout.flush();
            bout.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<T> get() {
        ArrayList<T> arrayList = new ArrayList<T>();
        try {
            fin = new FileInputStream("./" + this.getClass().getSimpleName() + ".txt");
            bin = new ObjectInputStream(fin);
            arrayList = (ArrayList<T>) bin.readObject();
            bin.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override
    public void update(ArrayList listT) {
        try {
            fout = new FileOutputStream("./" + this.getClass().getSimpleName() + ".txt", false);
            bout = new ObjectOutputStream(fout);
            bout.flush();
            bout.writeObject(listT);
            bout.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
