public class ComplexNumber implements Numbers <ComplexNumber> {
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
    
    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }
    
    public ComplexNumber subtract(ComplexNumber other){
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }
    
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }
	public ComplexNumber divide(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }
	
}
