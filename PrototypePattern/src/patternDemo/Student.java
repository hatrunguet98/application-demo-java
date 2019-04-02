package patternDemo;


public  class Student {
    private String name;
    private int age;
    private int msv;

    public Student(BuildStudent buildStudent) {
        this.name = buildStudent.name;
        this.age = age;
        this.msv = msv;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", msv=" + msv +
                '}';
    }

    public static class BuildStudent {
        private String name;
        private int age;
        private int msv;

        public BuildStudent(String name, int age, int msv) {
            this.name = name;
            this.age = age;
            this.msv = msv;
        }

        public Student creatStudent() {
            return new Student(this);
        }
    }
}
