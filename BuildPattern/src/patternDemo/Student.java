package model;

import patternDemo.BuildStudent;

public class Student {
    private String name;
    private int age;
    private int msv;

    public Student(BuildStudent buildStudent) {
        this.name = buildStudent.;
        this.age = age;
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMsv() {
        return msv;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", msv=" + msv +
                '}';
    }
}
