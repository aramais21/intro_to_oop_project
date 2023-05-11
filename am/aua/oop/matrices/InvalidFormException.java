package am.aua.oop.matrices;

public class InvalidFormException extends Exception {
    public InvalidFormException() {
        super("Matrix was not in the required form");
    }
}
