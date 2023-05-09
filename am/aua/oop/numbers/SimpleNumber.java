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

    //  TODO Implement this
    public Numbers clone() {
        return null;
    }

    //  TODO Implement this
    public Number getMultiplicativeInverse() {
        return null;
    }

    //  TODO Implement this
    public Number getAdditiveInverse() {
        return null;
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