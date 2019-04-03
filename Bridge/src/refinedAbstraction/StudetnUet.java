package refinedAbstraction;

import abstraction.Club;

public class StudetnUet extends Student {
    public StudetnUet(Club club, String name) {
        super(club, name);
    }

    @Override
    public void addStudent() {
        System.out.println("Uet's student is");
        club.addStudent();
    }
}
