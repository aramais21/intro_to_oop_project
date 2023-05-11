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

    public Solution getSolution() {
        try {
            this.coeefficiantMatrix.transformToReducedRowEchelonForm();
            int columnCount = this.coeefficiantMatrix.getColumnCount();
            ArrayList<Integer> pivotColumnIndexes = this.coeefficiantMatrix.getPivotColumnIndexes();
            if (pivotColumnIndexes.size() > 0 && pivotColumnIndexes.get(pivotColumnIndexes.size()-1) == columnCount - 1) {
                System.out.println("This Linear System is inconsistent");
                return null;
            }
            ArrayList<Integer> freeColumnIndexes = this.coeefficiantMatrix.getFreeColumnIndexes();
            if(freeColumnIndexes.size() > 0) {
//                TODO implement so that the solution is shown as a formula
                System.out.println("This system has infinitely many solutions");
                return null;
            }
            ArrayList<ArrayList<T>> vectors = new ArrayList<>();
            ArrayList<T> vector = new ArrayList<>();
            for (int i = 0; i < pivotColumnIndexes.size(); i++) {
                vector.add(this.coeefficiantMatrix.getCoefficiant(i, columnCount - 1));
            }
            vectors.add(vector);
            return new VectorSolution<T>(vectors);
        } catch (InvalidFormException err) {
            System.out.println("Oops, Matrix could not have been solved");
            return null;
        }
    }
}
