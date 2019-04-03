package patternDemo;

public class Demo {
    public static void main(String[] args) {
        Student student= new Student.BuildStudent("trung",21,1605).creatStudent();
        System.out.printf(student.toString());
    }
}

