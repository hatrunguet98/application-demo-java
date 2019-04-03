package patternDemo;


public class Student implements Cloneable {
    private String name;
    private int age;
    private int msv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMsv() {
        return msv;
    }

    public void setMsv(int msv) {
        this.msv = msv;
    }

    public Student(String name, int age, int msv) {
        this.name = name;
        this.age = age;
        this.msv = msv;
    }

    public Student() {
    }

    @Override
    protected Object clone(){
        try {
            return super.clone();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", msv=" + msv +
                '}';
    }
}
