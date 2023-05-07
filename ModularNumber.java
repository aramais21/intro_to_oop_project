public class ModularNumber implements Numbers<ModularNumber> {
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
    
    public ModularNumber add(ModularNumber other) {
        if (this.base != other.base) {
            throw new IllegalArgumentException("different moduli");
        }
        
        double newValue = (this.value + other.value) % this.base;
        return new ModularNumber(newValue, this.base);
    }
    
    public ModularNumber subtract(ModularNumber other){
        if (this.base != other.base) {
            throw new IllegalArgumentException("different moduli");
        }
        
        double newValue = (this.value - other.value + this.base) % this.base;
        return new ModularNumber(newValue, this.base);
    }
    
    public ModularNumber multiply(ModularNumber other) {
        if (this.base != other.base) {
            throw new IllegalArgumentException("different moduli");
        }
        
        double newValue = (this.value * other.value) % this.base;
        return new ModularNumber(newValue, this.base);
    }
	
	public ModularNumber divide(ModularNumber other){
		if (this.base != other.base) {
            throw new IllegalArgumentException("different moduli");
        }
        
        double newValue = (this.value / other.value) % this.base;
        return new ModularNumber(newValue, this.base);

	}
}
