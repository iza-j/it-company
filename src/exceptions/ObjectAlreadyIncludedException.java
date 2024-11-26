package exceptions;

public class ObjectAlreadyIncludedException extends Exception {

    public ObjectAlreadyIncludedException(String errorMessage) {
        super(errorMessage + "\n");
    }
}