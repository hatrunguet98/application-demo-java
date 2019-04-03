import component.ClubEnglish;
import concreteComponent.Student;
import decorato.LeaderClubDecorato;

public class Main {
    public static void main(String[] args) {
        ClubEnglish student=new Student("Tu");
        ClubEnglish leader= new LeaderClubDecorato(student);
        leader.showPosition();
    }
}
