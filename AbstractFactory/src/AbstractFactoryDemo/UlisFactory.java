package factoryPatternDemo;

import model.Student;
import model.StudentUlis;

public class UlisFactory implements AbstractFactory {
    private String name;

    public UlisFactory(String name) {
        this.name = name;
    }

    @Override
    public Student creartStudent() {
        return new StudentUlis(name);
    }
}
