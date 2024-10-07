package kr.co.sh.labor.labor_core.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message);
    }
}