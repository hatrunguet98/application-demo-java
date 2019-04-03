package patternDemo;

public class Demo {
    public static void main(String[] args) {
        Student student =new Student("Trung",21,1605);
        Student student1= (Student) student.clone();
        student1.setName("tu");
        System.out.printf(student1.toString());
        System.out.printf(student.toString());
    }
}

