package factoryPatternDemo;

import model.Student;
import model.StudentUet;
import model.StudentUlis;

public class FactyoryClass {
    public static Student creartStudent(AbstractFactory factory) {
        return factory.creartStudent() ;
    }
}
