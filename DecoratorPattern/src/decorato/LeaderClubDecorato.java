package decorato;

import component.ClubEnglish;
import concreteComponent.Student;

public class LeaderClubDecorato extends Decorato {
    public LeaderClubDecorato(ClubEnglish student) {
        super(student);
    }
    public void showPosition() {
        System.out.println(student.getName()+"'s position is : Leader");
    }
}
