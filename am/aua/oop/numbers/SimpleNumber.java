package am.aua.oop.numbers;

public class SimpleNumber implements Numbers, Cloneable {
    private double value;

    public SimpleNumber(double value) {
        this.value = value;
    }

    public double getValueAsDouble() {
        return this.value;
    }

    public Numbers add(Numbers other) {
        try {
            SimpleNumber otherAsSimple = this.covertNumberToSimpleNumber(other);
            SimpleNumber newValue = new SimpleNumber(this.value + otherAsSimple.value);
            return newValue;
        } catch (InvalidNumberTypeException err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return null;
        }
    }

    public Numbers subtract(Numbers other){
        try {
            SimpleNumber otherAsSimple = this.covertNumberToSimpleNumber(other);
            SimpleNumber newValue = new SimpleNumber(this.value - otherAsSimple.value);
            return newValue;
        } catch (InvalidNumberTypeException err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return null;
        }
    }

    public Numbers multiply(Numbers other) {
        try {
            SimpleNumber otherAsSimple = this.covertNumberToSimpleNumber(other);
            SimpleNumber newValue = new SimpleNumber(this.value * otherAsSimple.value);
            return newValue;
        } catch (InvalidNumberTypeException err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return null;
        }
    }

    public SimpleNumber clone() {
        return new SimpleNumber(this.value);
    }

    public SimpleNumber getMultiplicativeInverse() throws ArithmeticException {
        if (value == 0.0) {
            throw new ArithmeticException("Cannot calculate multiplicative inverse of zero");
        }
        return new SimpleNumber(1.0 / value);
    }
    public SimpleNumber getAdditiveInverse() {
        return new SimpleNumber(-1 * value);
    }

    //    TODO check if this is needed
//    public Numbers divide(Numbers other){
//        SimpleNumber newValue = new SimpleNumber(this.value/other.value);
//        return newValue;
//    }

    private SimpleNumber covertNumberToSimpleNumber(Numbers num) throws InvalidNumberTypeException {
        if(!(num instanceof SimpleNumber)) {
            throw new InvalidNumberTypeException();
        }
        return (SimpleNumber) num;
    }
}