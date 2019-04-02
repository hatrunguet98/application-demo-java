package factoryPatternDemo;

import model.Student;
import model.StudentUet;

public class UetFactory implements AbstractFactory {
    private String name;

    public UetFactory(String name) {
        this.name = name;
    }

    @Override
    public Student creartStudent() {
        return new StudentUet(name);
    }
}
