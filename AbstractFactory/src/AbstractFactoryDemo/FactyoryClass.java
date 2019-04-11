package AbstractFactoryDemo;

import model.Student;

public class FactyoryClass {
    public static Student creartStudent(AbstractFactory factory) {
        return factory.creartStudent();
    }
}
