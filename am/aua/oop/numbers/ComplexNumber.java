package am.aua.oop.numbers;

public class ComplexNumber implements Numbers, Cloneable {
	private double real;
	private double imaginary;

	public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
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
    
    public Numbers subtract(Numbers other){
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
//	public Numbers divide(Numbers other) {
//
//        double newReal = this.real * other.real - this.imaginary * other.imaginary;
//        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
//        return new ComplexNumber(newReal, newImaginary);
//    }

    private ComplexNumber covertNumberToComplexNumber(Numbers num) throws InvalidNumberTypeException {
//        TODO we can later implement this so that it does not throw an error but rather creates a new complex number based on the num passed. for simple and modular numbers as well
        if(!(num instanceof ComplexNumber)) {
            throw new InvalidNumberTypeException();
        }
        return (ComplexNumber) num;
    }
}
