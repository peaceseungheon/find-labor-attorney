package kr.co.sh.labor.labor_core.exception;

public class DuplicateException extends RuntimeException{

    public DuplicateException(String message){
        super(message);
    }
}