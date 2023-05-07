public interface Numbers<T> {
    double getValueAsDouble();
    T add(T other);
    T subtract(T other);
    T multiply(T other);
	T divide(T other);
}
