package appHandler;

import concreteHandler.LeaderHandler;
import concreteHandler.ManagerHandler;
import handler.HandlerLeave;

public class CreatChainHandler {
    public static HandlerLeave setHandler(){
        HandlerLeave handlerLeader= new LeaderHandler();
        HandlerLeave handlerManager= new ManagerHandler();
        handlerLeader.nextHandler(handlerManager);
        return handlerLeader;
    }
}
