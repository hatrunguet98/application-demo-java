package demo;

import abstraction.ClubEnglish;
import abstraction.ClubJapanese;
import refinedAbstraction.Student;
import refinedAbstraction.StudetnUet;

public class Main {
    public static void main(String[] args) {
        Student studentUet= new StudetnUet(new ClubEnglish(),"trung");
        studentUet.addStudent();
        Student studentUlis= new StudetnUet(new ClubJapanese(),"trung");
        studentUlis.addStudent();
    }
}
