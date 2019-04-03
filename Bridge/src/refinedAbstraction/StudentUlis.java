package refinedAbstraction;

import abstraction.Club;

public class StudentUlis extends Student{

    public StudentUlis(Club club, String name) {
        super(club, name);
    }

    @Override
    public void addStudent() {
        System.out.println("Ulis's student is ");
        club.addStudent();
    }
}
