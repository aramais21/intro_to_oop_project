package am.aua.oop.numbers;

public class ModularNumber implements Numbers {
    private double value;
    private double base;
    
    public ModularNumber(double value, double base) {
//        Case when value is -1
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
        try {
            ModularNumber otherAsModular = this.covertNumberToModularNumber(other);
            if (this.base != otherAsModular.base) {
                throw new IllegalArgumentException("different moduli");
            }

            double newValue = (this.value + otherAsModular.value) % this.base;
            return new ModularNumber(newValue, this.base);
        } catch (Exception err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return null;
        }
    }
    
    public Numbers subtract(Numbers other) {
        try {
            ModularNumber otherAsModular = this.covertNumberToModularNumber(other);
            if (this.base != otherAsModular.base) {
                throw new IllegalArgumentException("different moduli");
            }

            double newValue = (this.value - otherAsModular.value + this.base) % this.base;
            return new ModularNumber(newValue, this.base);
        } catch (Exception err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return null;
        }
    }
    
    public Numbers multiply(Numbers other) {
        try {
            ModularNumber otherAsModular = this.covertNumberToModularNumber(other);
            if (this.base != otherAsModular.base) {
                throw new IllegalArgumentException("different moduli");
            }

            double newValue = (this.value * otherAsModular.value) % this.base;
            return new ModularNumber(newValue, this.base);
        } catch (Exception err) {
            System.out.println(err.getMessage());
            System.exit(1);
            return null;
        }
    }

    public Numbers clone() {
        return new ModularNumber(this.value, this.base);
    }
    public Numbers getMultiplicativeInverse() throws ArithmeticException {
        if(this.value <= 0 || !NumbersUtil.isPrime(this.base) || !NumbersUtil.areCoPrime(this.value, this.base)) {
            throw new ArithmeticException("Nonexistent inverse");
        }
        double a = this.value % this.base;
        for (double possibleInverse = 1; possibleInverse < this.base; possibleInverse++) {
            if ((a * possibleInverse) % this.base == 1) {
                return new ModularNumber(possibleInverse, this.base);
            }
        }

        throw new ArithmeticException("Nonexistent inverse");
    }

    public Numbers getAdditiveInverse() {
        double additiveInverse = (base - value) % base;
        return new ModularNumber(additiveInverse, base);
    }

//	public ModularNumber divide(ModularNumber other){
//		if (this.base != other.base) {
//            throw new IllegalArgumentException("different moduli");
//        }
//
//        double newValue = (this.value / other.value) % this.base;
//        return new ModularNumber(newValue, this.base);
//	}

    private ModularNumber covertNumberToModularNumber(Numbers num) throws InvalidNumberTypeException {
        if(!(num instanceof ModularNumber)) {
            throw new InvalidNumberTypeException();
        }
        return (ModularNumber) num;
    }
}
