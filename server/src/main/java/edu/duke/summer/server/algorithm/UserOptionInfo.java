package edu.duke.summer.server.algorithm;

public class UserOptionInfo {
    //if object exists, object's gameId
    String gameId;
    //if object exists, object's Id
    String objectId;
    //prompt for users
    String promptMsg;


    public UserOptionInfo(String gi, String oi, String s){
        gameId = gi;
        objectId = oi;
        promptMsg = s;
    }
    public UserOptionInfo(String s){
        promptMsg = s;
    }

    public void printInfo(){
        System.out.println("------UserOptionInfo------");
        System.out.println(gameId + objectId + promptMsg);
    }
}
