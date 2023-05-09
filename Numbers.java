public interface Numbers {

    double getValueAsDouble();
    Numbers add(Numbers other);
    Numbers subtract(Numbers other);
    Numbers multiply(Numbers other);
    Numbers divide(Numbers other);
  
    Numbers clone();
  
    Numbers getMultiplicativeInverse();
  
    Numbers getAdditiveInverse();
  }