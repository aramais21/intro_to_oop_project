package am.aua.oop.solvers;

public class QuadraticEquationSolver implements Solver {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquationSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public String getSolutionAsString() {
        double Discriminant = getDiscriminant();

        if (Discriminant < 0)
            return ("Negative Discriminant");
        else if (Discriminant == 0)
            return "Root: " + (-b / 2 * a);
        else
            return "Root1: " + ((-b + Math.sqrt(getDiscriminant())) / 2 * a) + " " +
                    "Root2: " + ((-b - Math.sqrt(getDiscriminant())) / 2 * a);
    }
}
