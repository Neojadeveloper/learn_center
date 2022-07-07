package neo.setup.learn_center.exception.exception;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(){
        super();
    }

    public ForbiddenException(String message){
        super(message);
    }
}
