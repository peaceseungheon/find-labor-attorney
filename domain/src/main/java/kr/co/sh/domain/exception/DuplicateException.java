package kr.co.sh.domain.exception;

public class DuplicateException extends RuntimeException{

    public DuplicateException(String message){
        super(message);
    }
}
