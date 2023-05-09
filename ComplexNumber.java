public class ComplexNumber implements Numbers {
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
      double newReal = this.real + ((ComplexNumber) other).real;
      double newImaginary = this.imaginary + ((ComplexNumber) other).imaginary;
      return new ComplexNumber(newReal, newImaginary);
    }
  
    public Numbers subtract(Numbers other) {
      double newReal = this.real - ((ComplexNumber) other).real;
      double newImaginary = this.imaginary - ((ComplexNumber) other).imaginary;
      return new ComplexNumber(newReal, newImaginary);
    }
  
    public Numbers multiply(Numbers other) {
      double newReal = this.real * ((ComplexNumber) other).real - this.imaginary * ((ComplexNumber) other).imaginary;
      double newImaginary = this.real * ((ComplexNumber) other).imaginary + this.imaginary * ((ComplexNumber) other).real;
      return new ComplexNumber(newReal, newImaginary);
    }
    public Numbers divide(Numbers other) {
      double newReal = this.real * ((ComplexNumber) other).real - this.imaginary * ((ComplexNumber) other).imaginary;
      double newImaginary = this.real * ((ComplexNumber) other).imaginary + this.imaginary * ((ComplexNumber) other).real;
      return new ComplexNumber(newReal, newImaginary);
    }
  
    public Numbers clone() {
      return new ComplexNumber(this.real, this.imaginary);
    }
  
    public Numbers getMultiplicativeInverse() {
      double divisor = (real * real) + (imaginary * imaginary);
      if (divisor != 0) {
        double inverseReal = real / divisor;
        double inverseImaginary = -imaginary / divisor;
        return new ComplexNumber(inverseReal, inverseImaginary);
      } else {
        throw new ArithmeticException("Inverse does not exist");
      }
    }
  
    public Numbers getAdditiveInverse() {
      double inverseReal = -real;
      double inverseImaginary = -imaginary;
      return new ComplexNumber(inverseReal, inverseImaginary);
    }
  }