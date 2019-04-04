package oject;

public class UlisStudent implements Student {

    @Override
    public void study(String university) {
        System.out.println("Student's university :" + university);
    }
}
