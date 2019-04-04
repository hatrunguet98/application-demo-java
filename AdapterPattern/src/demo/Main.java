package demo;

import adapter.StudentAdapter;
import oject.Location;
import oject.Student;

public class Main {
    public static void main(String[] args) {
        Student student= new StudentAdapter(new Location("G2"));
        student.study("uet");
    }

}
