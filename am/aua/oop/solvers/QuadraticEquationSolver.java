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

    public Solution getSolution() {
        double Discriminant = getDiscriminant();

        if (Discriminant < 0)
            return null;
        else if (Discriminant == 0)
            return new ScalarSolution(new double[]{(-b / 2 * a)});
        else
            return new ScalarSolution(new double[]{((-b + Math.sqrt(getDiscriminant())) / 2 * a), ((-b - Math.sqrt(getDiscriminant())) / 2 * a) });
    }
}
