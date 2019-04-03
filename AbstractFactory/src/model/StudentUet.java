package model;

public class StudentUet extends Student {
    private String name;
    private String university="UET";

    public StudentUet() {
    }

    public StudentUet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public void showInfo() {
        System.out.println("Name:"+name+" University:"+university);
    }

    public void setName(String name) {
        this.name=name;
    }
}
