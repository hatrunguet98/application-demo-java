package handler;

import model.Student;

public abstract class HandlerLeave {
    private Student student;
    protected HandlerLeave handlerLeaveNext;

    public void checkLeaveDay(Student student){
        System.out.println("Cheking by : "+this.getClass().getSimpleName()+"\n");
        if(checkLeave(student.getLeaveDay())){
            this.getStatus(student);
        }
        else{
            handlerLeaveNext.checkLeaveDay(student);
        }
    }

    public void nextHandler(HandlerLeave handlerLeaveNext){
        this.handlerLeaveNext = handlerLeaveNext;
    }

    protected abstract boolean checkLeave(int numLeavDay);

    protected abstract void getStatus(Student student);
}
