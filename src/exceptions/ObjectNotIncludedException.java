package exceptions;

public class ObjectNotIncludedException extends Exception {

    public ObjectNotIncludedException(String errorMessage) {
        super(errorMessage + "\n");
    }
}