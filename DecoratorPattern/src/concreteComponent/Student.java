package concreteComponent;

import component.ClubEnglish;

public class Student implements ClubEnglish {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void getUniversity() {
        System.out.println("University's student is: UET");
    }

    @Override
    public void showPosition() {

    }
}
