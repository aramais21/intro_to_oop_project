package am.aua.oop.solvers;

public class ScalarSolution implements Solution {
    double[] possibleSolutions;
    public ScalarSolution(double[] possibleSolutions) {
        this.possibleSolutions = (double[]) possibleSolutions.clone();
    }


    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Some possible solutions are ");
        for(int i = 0; i < this.possibleSolutions.length; i++) {
            builder.append(this.possibleSolutions[i]);
            if (i != this.possibleSolutions.length - 1 ) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
