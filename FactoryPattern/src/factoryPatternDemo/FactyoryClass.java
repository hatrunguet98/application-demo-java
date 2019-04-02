package factoryPatternDemo;

import model.Student;
import model.StudentUet;
import model.StudentUlis;

public class FactyoryClass {
    public static Student getStudent(String university, String name){
        if(university.equalsIgnoreCase("uet")){
            return new StudentUet(name);
        }
        if(university.equalsIgnoreCase("ulis")){
            return new StudentUlis(name);
        }
        else{
            return null;
        }
    }
}
