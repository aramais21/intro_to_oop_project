package am.aua.oop.numbers;

public interface Numbers {
    double getValueAsDouble();

    Numbers add(Numbers other);

    Numbers subtract(Numbers other);

    Numbers multiply(Numbers other);

    Numbers clone();

    Numbers getMultiplicativeInverse() throws ArithmeticException;

    Numbers getAdditiveInverse();

    boolean isNonZero();

    String toString();
}
