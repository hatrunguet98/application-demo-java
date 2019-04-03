package adapter;

import oject.Location;
import oject.Student;
import oject.UetLocation;
import oject.UlisLocation;

public class StudentAdapter implements Student {
    Location location1;
    public StudentAdapter(String university){
        if(university.equalsIgnoreCase("uet")){
            location1 = new UetLocation();
        }else if(university.equalsIgnoreCase("ulis")){
            location1 = new UlisLocation();
        }
    }
    @Override
    public void study(String university, String location) {
        if(university.equalsIgnoreCase("uet")){
            location1.locaeUet(location);
        }else if(university.equalsIgnoreCase("ulis")){
            location1.locaeUlis(location);
        }
    }
}
