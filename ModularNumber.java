public class ModularNumber implements Numbers {
    private double value;
    private double base;
  
    public ModularNumber(double value, double base) {
      this.value = value % base;
      this.base = base;
    }
  
    public double getValueAsDouble() {
      return this.value;
    }
  
    public double getBase() {
      return this.base;
    }
  
    public Numbers add(Numbers other) {
      if (this.base != ((ModularNumber) other).base) {
        throw new IllegalArgumentException("different moduli");
      }
  
      double newValue = (this.value + ((ModularNumber) other).value) % this.base;
      return new ModularNumber(newValue, this.base);
    }
  
    public Numbers subtract(Numbers other) {
      if (this.base != ((ModularNumber) other).base) {
        throw new IllegalArgumentException("different moduli");
      }
  
      double newValue = (this.value - ((ModularNumber) other).value + this.base) % this.base;
      return new ModularNumber(newValue, this.base);
    }
  
    public Numbers multiply(Numbers other) {
      if (this.base != ((ModularNumber) other).base) {
        throw new IllegalArgumentException("different moduli");
      }
  
      double newValue = (this.value * ((ModularNumber) other).value) % this.base;
      return new ModularNumber(newValue, this.base);
    }
  
    public Numbers divide(Numbers other) {
      if (this.base != ((ModularNumber) other).base) {
        throw new IllegalArgumentException("different moduli");
      }
  
      double newValue = (this.value / ((ModularNumber) other).value) % this.base;
      return new ModularNumber(newValue, this.base);
  
    }
  
    public Numbers clone() {
      return new
      ModularNumber(this.value, this.base);
    }
    public Numbers getMultiplicativeInverse() {
      double gcd = gcdExtended(value, base);
      if (gcd != 1) {
        throw new ArithmeticException("Modular inverse does not exist");
      }
      double multiplicativeInverse = (modInverse(value, base) + base) % base;
      return new ModularNumber(multiplicativeInverse, base);
    }
  
    private double gcdExtended(double a, double b) {
      if (a == 0) {
        return b;
      }
      double gcd = gcdExtended(b % a, a);
      return gcd;
    }
  
    // Modular inverse using extended Euclidean algorithm
    private double modInverse(double a, double m) {
      double m0 = m;
      double y = 0, x = 1;
  
      if (m == 1) {
        return 0;
      }
  
      while (a > 1) {
        double q = a / m;
        double t = m;
        m = a % m;
        a = t;
        t = y;
        y = x - q * y;
        x = t;
      }
  
      if (x < 0) {
        x += m0;
      }
  
      return x;
    }
  
    public Numbers getAdditiveInverse() {
      double additiveInverse = (base - value) % base;
      return new ModularNumber(additiveInverse, base);
    }
  
  }