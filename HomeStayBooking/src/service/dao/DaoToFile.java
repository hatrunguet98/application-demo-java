package service.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DaoToFile<T> {
    FileOutputStream fout = null;
    ObjectOutputStream bout = null;

    public void conectToFile(String nameFile) {

    }

    public void addT(String nameFile, T t) {
        try {
            fout = new FileOutputStream("../" + nameFile + ".t");
            bout = new ObjectOutputStream(fout);
            bout.writeObject(t);
            bout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
