package oject;

public class UetStudent implements Student{
    @Override
    public void study(String university) {
        System.out.println("Student's university :" + university);
    }
}
