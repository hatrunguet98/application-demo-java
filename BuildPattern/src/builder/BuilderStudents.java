package builder;

import concrteBuilder.BuilderStudent;
import product.Student;

public interface BuilderStudents {
    BuilderStudent builderName(String name);
    BuilderStudent builderAge(String age);
    BuilderStudent builderMsv(String msv);
    BuilderStudent builderBirthday(String birthday);
    BuilderStudent builderUniversity(String university);
    Student build();
}
