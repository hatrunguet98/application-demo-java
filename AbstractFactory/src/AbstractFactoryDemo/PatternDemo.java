package AbstractFactoryDemo;

import model.Student;

import java.util.Scanner;

public class PatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student's name:");
        String name = scanner.nextLine();
        Student student = FactyoryClass.creartStudent(new UetFactory(name));
        student.showInfo();
    }
}