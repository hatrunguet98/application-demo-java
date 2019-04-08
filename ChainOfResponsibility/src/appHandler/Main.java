package appHandler;

import model.Student;

public class Main {
    public static void main(String[] args) {
        Student student= new Student("Trung",5);
        Student student1= new Student("Tu",15);
        CreatChainHandler.setHandler().checkLeaveDay(student);
        CreatChainHandler.setHandler().checkLeaveDay(student1);
    }

}
