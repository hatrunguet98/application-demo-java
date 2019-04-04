package patternDemo;

import concrteBuilder.BuilderStudent;
import product.Student;

public class Demo {
    public static void main(String[] args) {
        Student student= new BuilderStudent()
                .builderName("Trung").builderMsv("1605").builderAge("21")
                .builderUniversity("uet").builderBirthday("30/07")
                .build();
        System.out.printf(student.toString());
    }
}

