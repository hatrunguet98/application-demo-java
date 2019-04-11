package model;

public class StudentUlis extends Student {
    private String name;
    private String university = "ULIS";

    public StudentUlis() {
    }

    public StudentUlis(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public void showInfo() {
        System.out.println("Name:" + name + " University:" + university);
    }
}
