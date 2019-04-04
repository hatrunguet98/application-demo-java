package concrteBuilder;

import builder.BuilderStudents;
import product.Student;

public class BuilderStudent implements BuilderStudents {
    private String name;
    private String age;
    private String msv;
    private String birthday;
    private String university;

    @Override
    public BuilderStudent builderName(String name) {
        this.name=name;
        return this;
    }

    @Override
    public BuilderStudent builderAge(String age) {
        this.age=age;
        return this;
    }

    @Override
    public BuilderStudent builderMsv(String msv) {
        this.msv=msv;
        return this;
    }

    @Override
    public BuilderStudent builderBirthday(String birthday) {
        this.birthday=birthday;
        return this;
    }

    @Override
    public BuilderStudent builderUniversity(String university) {
        this.university=university;
        return this;
    }

    @Override
    public Student build() {
        return new Student(name,age,msv,birthday,university);
    }
}
