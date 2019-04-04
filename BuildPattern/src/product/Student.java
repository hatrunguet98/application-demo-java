package product;


public  class Student {
    private String name;
    private String age;
    private String msv;
    private String birthday;
    private String university;


    public Student(String name, String age, String msv, String birthday, String university) {
        this.name = name;
        this.age = age;
        this.msv = msv;
        this.birthday = birthday;
        this.university = university;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", msv=" + msv +
                ", birthday='" + birthday + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}
