public class SimpleNumber implements Numbers<SimpleNumber> {
    private double value;
    
    public SimpleNumber(double value) {
        this.value = value;
    }
    
    public double getValueAsDouble() {
        return this.value;
    }
    
    public SimpleNumber add(SimpleNumber other) {
        SimpleNumber newValue = new SimpleNumber(this.value + other.value);
        return newValue;
    }
    
    public SimpleNumber subtract(SimpleNumber other){
        SimpleNumber newValue = new SimpleNumber(this.value - other.value);
        return newValue;
    }
    
    public SimpleNumber multiply(SimpleNumber other) {
        SimpleNumber newValue = new SimpleNumber(this.value * other.value);
        return newValue;
    }
	public SimpleNumber divide(SimpleNumber other){
		SimpleNumber newValue = new SimpleNumber (this.value/other.value);
		return newValue;
	}
}
