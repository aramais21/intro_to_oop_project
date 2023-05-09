package am.aua.oop.numbers;

public class InvalidNumberTypeException extends Exception {
    public InvalidNumberTypeException() {
        super("Detected a number with an invalid type");
    }
}
