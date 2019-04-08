package model;

public class Student {
    String name;
    int leaveDay;

    public Student(String name, int leaveDay) {
        this.name = name;
        this.leaveDay = leaveDay;
    }

    public String getName() {
        return name;
    }

    public int getLeaveDay() {
        return leaveDay;
    }
}
