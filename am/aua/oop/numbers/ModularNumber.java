package am.aua.oop.numbers;

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
