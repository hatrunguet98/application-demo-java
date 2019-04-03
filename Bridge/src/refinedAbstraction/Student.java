package refinedAbstraction;

import abstraction.Club;

public abstract class Student {
    protected Club club;
    private String name;

    public Student(Club club, String name) {
        this.club = club;
        this.name = name;
    }

    public abstract void addStudent();
}
