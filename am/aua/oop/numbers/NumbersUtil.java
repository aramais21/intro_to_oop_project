package am.aua.oop.numbers;

public class NumbersUtil {
    public static boolean isPrime(double num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areCoPrime(double num, double other) {
        if (num == 0 || other == 0) {
            return false;
        }
        double gcd = getGCD(num, other);
        return gcd == 1;
    }

    public static double getGCD(double num, double other) {
        if (other == 0) {
            return num;
        } else {
            return getGCD(other, num % other);
        }
    }
}
