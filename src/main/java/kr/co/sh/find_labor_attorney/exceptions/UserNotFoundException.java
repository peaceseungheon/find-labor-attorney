package kr.co.sh.find_labor_attorney.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message);
    }

}
