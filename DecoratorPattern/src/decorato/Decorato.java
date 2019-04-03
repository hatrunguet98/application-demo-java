package decorato;

import component.ClubEnglish;
import concreteComponent.Student;

public class Decorato implements ClubEnglish {
    protected ClubEnglish student;

    public Decorato(ClubEnglish student) {
        this.student = student;
    }

    @Override
    public String getName() {
        return student.getName();
    }

    @Override
    public void getUniversity() {

    }
    @Override
    public void showPosition() {

    }
}
