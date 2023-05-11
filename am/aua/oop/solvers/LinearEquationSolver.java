package am.aua.oop.solvers;

import am.aua.oop.matrices.InvalidFormException;
import am.aua.oop.matrices.Matrix;
import am.aua.oop.numbers.Numbers;

import java.util.ArrayList;

public class LinearEquationSolver<T extends Numbers> implements Solver {
    private Matrix<T> coeefficiantMatrix;

    public LinearEquationSolver(Matrix<T> coeefficiantMatrix) {
        this.coeefficiantMatrix = coeefficiantMatrix;
    }

    public String getSolutionAsString() {
        try {
            this.coeefficiantMatrix.transformToRowEchelonForm();
            this.coeefficiantMatrix.transformToReducedRowEchelonForm();
            int columnCount = this.coeefficiantMatrix.getColumnCount();
            ArrayList<Integer> pivotColumnIndexes = this.coeefficiantMatrix.getPivotColumnIndexes();
            System.out.println(pivotColumnIndexes);
            System.out.println(this.coeefficiantMatrix.toString());
            if (pivotColumnIndexes.get(pivotColumnIndexes.size()-1) == columnCount - 1) {
                return "This Linear System is inconsistent";
            }
            ArrayList<Integer> freeColumnIndexes = this.coeefficiantMatrix.getFreeColumnIndexes();
            if(freeColumnIndexes.size() > 0) {
//                TODO implement so that the solution is shown as a formula
                return "This system has infinitely many solutions";
            }
            StringBuilder sol = new StringBuilder("The solution is { ");
            for (int i = 0; i < pivotColumnIndexes.size(); i++) {
                sol.append(this.coeefficiantMatrix.getCoefficiant(i, columnCount - 1));
                if (i != pivotColumnIndexes.size() -1) {
                    sol.append(", ");
                }
            }
            sol.append("  }");
            return sol.toString();
        } catch (InvalidFormException err) {
            return "Oops, Matrix could not have been solved";
        }
    }
}
