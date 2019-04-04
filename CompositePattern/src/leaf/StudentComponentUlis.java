package leaf;

import baseComponent.StudentComponent;

public class StudentComponentUlis implements StudentComponent {
    private String name;
    private int age;

    public StudentComponentUlis(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void getName() {
        System.out.println("Student's name is:"+this.name+"and age is:"+this.age);
    }

    @Override
    public void getUniversity() {
        System.out.println(this.name+"'s university is: Ulis");
    }
}
