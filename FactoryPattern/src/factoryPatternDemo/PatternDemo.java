package factoryPatternDemo;

import model.Student;

import java.util.Scanner;

public class PatternDemo {
    public static void main(String[] args) {
        int i=0;
        while (i==0){
            Scanner scanner=new Scanner(System.in);
            System.out.println("Student's name:");
            String name=scanner.nextLine();
            System.out.println("Student's university:");
            String university=scanner.nextLine();
            Student student= FactyoryClass.getStudent(university,name);
            student.showInfo();
        }
        }
}