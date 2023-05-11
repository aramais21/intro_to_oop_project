import am.aua.oop.matrices.InvalidBaseException;
import am.aua.oop.matrices.Matrix;
import am.aua.oop.numbers.ComplexNumber;
import am.aua.oop.numbers.ModularNumber;
import am.aua.oop.numbers.NumbersEnum;
import am.aua.oop.numbers.SimpleNumber;
import am.aua.oop.solvers.LinearEquationSolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LinearEquationTester {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("dataExamples/simple.txt")));
            String numberType = scanner.nextLine();
            int rowCount = scanner.nextInt();
            int columnCount = scanner.nextInt();
            Matrix matrix = null;
            if (numberType.equals(NumbersEnum.SIMPLE.getType())) {
                ArrayList<ArrayList<SimpleNumber>> simpleMatrix = new ArrayList<>(rowCount);
                for (int i = 0; i < rowCount; i++) {
                    ArrayList<SimpleNumber> row = new ArrayList<>();
                    for(int j = 0; j < columnCount; j++) {
                        row.add(new SimpleNumber(scanner.nextDouble()));
                    }
                    simpleMatrix.add(row);
                }
                matrix = new Matrix<>(rowCount, columnCount, simpleMatrix);
            } else if (numberType.equals(NumbersEnum.MODULAR.getType())) {
                int base = scanner.nextInt();
                ArrayList<ArrayList<ModularNumber>> simpleMatrix = new ArrayList<>(rowCount);
                for (int i = 0; i < rowCount; i++) {
                    ArrayList<ModularNumber> row = new ArrayList<>(columnCount);
                    for(int j = 0; j < columnCount; j++) {
                        row.add(new ModularNumber(scanner.nextDouble(), base));
                    }
                    simpleMatrix.add(row);
                }
                matrix = new Matrix<>(rowCount, columnCount, simpleMatrix);
            } else if (numberType.equals(NumbersEnum.COMPLEX.getType())) {
                ArrayList<ArrayList<ComplexNumber>> simpleMatrix = new ArrayList<>(rowCount);
                for (int i = 0; i < rowCount; i++) {
                    ArrayList<ComplexNumber> row = new ArrayList<>(columnCount);
                    for(int j = 0; j < columnCount; j++) {
                        row.add(new ComplexNumber(scanner.nextDouble(), scanner.nextDouble()));
                    }
                    simpleMatrix.add(row);
                }
                matrix = new Matrix<ComplexNumber>(rowCount, columnCount, simpleMatrix);
            }
            System.out.println(new LinearEquationSolver(matrix).getSolution());
        } catch (IOException err) {
            err.printStackTrace();
        } catch (InvalidBaseException e) {
            throw new RuntimeException(e);
        } finally {
            if (scanner != null){
                scanner.close();
            }
        }
    }
}
