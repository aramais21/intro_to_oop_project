public class SimpleNumber implements Numbers {
    private double value;
  
    public SimpleNumber(double value) {
      this.value = value;
    }
  
    public double getValueAsDouble() {
      return this.value;
    }
  
    public Numbers add(Numbers other) {
      SimpleNumber newValue = new SimpleNumber(this.value + ((SimpleNumber) other).value);
      return newValue;
    }
  
    public Numbers subtract(Numbers other) {
      SimpleNumber newValue = new SimpleNumber(this.value - ((SimpleNumber) other).value);
      return newValue;
    }
  
    public Numbers multiply(Numbers other) {
      SimpleNumber newValue = new SimpleNumber(this.value * ((SimpleNumber) other).value);
      return newValue;
    }
    public Numbers divide(Numbers other) {
      SimpleNumber newValue = new SimpleNumber(this.value / ((SimpleNumber) other).value);
      return newValue;
    }
  
    public SimpleNumber clone() {
      return new SimpleNumber(this.value);
    }
  
    public SimpleNumber getMultiplicativeInverse() {
      if (value == 0.0) {
        throw new ArithmeticException("Cannot calculate multiplicative inverse of zero");
      }
      return new SimpleNumber(1.0 / value);
    }
    public SimpleNumber getAdditiveInverse() {
      return new SimpleNumber(-value);
    }
  }