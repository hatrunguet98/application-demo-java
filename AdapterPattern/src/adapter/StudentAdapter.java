package adapter;

import oject.Location;
import oject.Student;

public class StudentAdapter implements Student {
    Location location1;

    public StudentAdapter(Location location1) {
        this.location1 = location1;
    }

    @Override
    public void study(String university) {
        System.out.println("Student's university :" + university);
        System.out.println("Student's location :" + location1.getLocastion());
    }
}
