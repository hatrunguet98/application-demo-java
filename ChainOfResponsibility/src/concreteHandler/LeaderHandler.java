package concreteHandler;

import handler.HandlerLeave;
import model.Student;

public class LeaderHandler extends HandlerLeave {
    @Override
    protected boolean checkLeave(int numLeavDay) {
        if(numLeavDay<6){
            return true;
        }
        return false;
    }

    @Override
    protected void getStatus(Student student) {
        System.out.println(student.getName()+"'s day leave is: "+student.getLeaveDay()+"\n");
    }
}
