package am.aua.oop.numbers;

public class ComplexNumber implements Numbers, Cloneable {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getValueAsDouble() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public Numbers add(Numbers other) {
        try {
            ComplexNumber otherAsComplex = this.covertNumberToComplexNumber(other);
            double newReal = this.real + otherAsComplex.real;
            double newImaginary = this.imaginary + otherAsComplex.imaginary;
            return new ComplexNumber(newReal, newImaginary);
        } catch (InvalidNumberTypeException err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return other;
        }
    }

    public Numbers subtract(Numbers other) {
        try {
            ComplexNumber otherAsComplex = this.covertNumberToComplexNumber(other);
            double newReal = this.real - otherAsComplex.real;
            double newImaginary = this.imaginary - otherAsComplex.imaginary;
            return new ComplexNumber(newReal, newImaginary);
        } catch (InvalidNumberTypeException err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return other;
        }
    }

    public Numbers multiply(Numbers other) {
        try {
            ComplexNumber otherAsComplex = this.covertNumberToComplexNumber(other);
            double newReal = this.real * otherAsComplex.real - this.imaginary * otherAsComplex.imaginary;
            double newImaginary = this.real * otherAsComplex.imaginary + this.imaginary * otherAsComplex.real;
            return new ComplexNumber(newReal, newImaginary);
        } catch (InvalidNumberTypeException err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return other;
        }
    }

    public Numbers clone() {
        return new ComplexNumber(this.real, this.imaginary);
    }

    public Numbers getMultiplicativeInverse() throws ArithmeticException {
        double divisor = (real * real) + (imaginary * imaginary);
        if (divisor == 0) {
            throw new ArithmeticException("Inverse does not exist");
        }
        double inverseReal = real / divisor;
        double inverseImaginary = -imaginary / divisor;
        return new ComplexNumber(inverseReal, inverseImaginary);
    }

    public Numbers getAdditiveInverse() {
        double inverseReal = -real;
        double inverseImaginary = -imaginary;
        return new ComplexNumber(inverseReal, inverseImaginary);
    }

    public boolean isNonZero() {
        return real != 0 && imaginary != 0;
    }

    private ComplexNumber covertNumberToComplexNumber(Numbers num) throws InvalidNumberTypeException {
//        TODO we can later implement this so that it does not throw an error but rather creates a new complex number based on the num passed. for simple and modular numbers as well
        if (!(num instanceof ComplexNumber)) {
            throw new InvalidNumberTypeException();
        }
        return (ComplexNumber) num;
    }
}
