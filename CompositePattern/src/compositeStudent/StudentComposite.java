package compositeStudent;

import baseComponent.StudentComponent;

import java.util.ArrayList;
import java.util.List;

public class StudentComposite implements StudentComponent {
    private List<StudentComponent> studentComponents= new ArrayList<>();

    public StudentComposite(List<StudentComponent> studentComponents) {
        this.studentComponents = studentComponents;
    }

    @Override
    public void getName() {
        for (StudentComponent studentComponent:studentComponents){
            studentComponent.getName();
        }
    }

    @Override
    public void getUniversity() {
        for (StudentComponent studentComponent:studentComponents){
            studentComponent.getUniversity();
        }
    }
}
