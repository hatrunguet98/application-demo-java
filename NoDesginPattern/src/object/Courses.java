package object;

import java.util.ArrayList;

public class Courses {
    private String name;
    private ArrayList<Students> listStudents;

    public Courses() {
    }

    public Courses(String name, ArrayList<Students> listStudents) {
        this.name = name;
        this.listStudents = listStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Students> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Students> listStudents) {
        this.listStudents = listStudents;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", listStudents=" + listStudents +
                '}';
    }
}
