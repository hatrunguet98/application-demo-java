package adapter;

import oject.Student;

public class StudentImpe implements Student {
    StudentAdapter studentAdapter;

    @Override
    public void study(String university, String location) {
        studentAdapter= new StudentAdapter(university);
        studentAdapter.study(university, location);
    }
}
