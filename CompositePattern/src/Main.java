import baseComponent.StudentComponent;
import compositeStudent.StudentComposite;
import leaf.StudetnComponentUet;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentComponent studentComponentUet=new StudetnComponentUet("Trung",21);
        StudentComponent studentComponentUlis=new StudetnComponentUet("Nga",21);
        List<StudentComponent> studentComponentsList= Arrays.asList(studentComponentUet,studentComponentUlis);
        StudentComponent component=new StudentComposite(studentComponentsList);
        component.getName();
        component.getUniversity();
    }
}
