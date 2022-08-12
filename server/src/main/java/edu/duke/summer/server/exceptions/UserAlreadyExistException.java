package edu.duke.summer.server.exceptions;

public class UserAlreadyExistException extends Exception{
    String errorMessage;

    public UserAlreadyExistException(String errorMessage){
        errorMessage=errorMessage;
    }


    @Override
    public String toString() {
        return "UserAlreadyExistException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }

}
