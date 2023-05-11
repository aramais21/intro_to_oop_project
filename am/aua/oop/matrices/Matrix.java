package am.aua.oop.matrices;

import java.util.ArrayList;
import java.util.Collections;

import am.aua.oop.numbers.*;

public class Matrix<T extends Numbers> {
    private ArrayList<ArrayList<T>> matrix;
    private int rowCount;
    private int columnCount;

    public Matrix(int rowCount, int columnCount, ArrayList<ArrayList<T>> base) throws InvalidBaseException {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.matrix = new ArrayList<ArrayList<T>>(rowCount);
        if (base.size() != rowCount) {
            throw new InvalidBaseException();
        }
        for (int i = 0; i < rowCount; i++) {
            ArrayList<T> row = base.get(i);
            if (row.size() < columnCount) {
                throw new InvalidBaseException();
            }
            ArrayList<T> validatedRow = new ArrayList<T>(columnCount);
            Collections.copy(row.subList(0, columnCount - 1), validatedRow);
            matrix.set(i, validatedRow);
        }
    }

    public Matrix(Matrix<T> matrixToCopy) {
        this.rowCount = matrixToCopy.rowCount;
        this.columnCount = matrixToCopy.columnCount;
        this.matrix = new ArrayList<ArrayList<T>>(this.rowCount);
        for (int i = 0; i < this.rowCount; i++) {
            ArrayList<T> row = new ArrayList<T>(this.columnCount);
            ArrayList<T> rowToCopy = matrixToCopy.matrix.get(i);
            for (int j = 0; j < this.columnCount; j++) {
                T numberToCopy = rowToCopy.get(j);
                row.set(j, (T) numberToCopy.clone());
            }
            matrix.set(i, row);
        }
    }

    public void swapRows(int firstRowIndex, int secondRowIndex) {
        if (this.isRowIndexInvalid(firstRowIndex) || this.isRowIndexInvalid(secondRowIndex)) {
            return;
        }
        ArrayList<T> firstRow = this.matrix.get(firstRowIndex);
        ArrayList<T> secondRow = this.matrix.get(secondRowIndex);
        this.matrix.set(firstRowIndex, secondRow);
        this.matrix.set(secondRowIndex, firstRow);
    }

    public void multiplyRowBy(int rowIndex, T scale) {
        if (this.isRowIndexInvalid(rowIndex)) {
            return;
        }
        ArrayList<T> row = this.matrix.get(rowIndex);
        for (int i = 0; i < this.columnCount; i++) {
            T number = row.get(i);
            T scaledNumber = (T) number.multiply(scale);
            row.set(i, scaledNumber);
        }
    }

    public void addRowBy(int rowIndex, int additiveRowIndex, T scale) {
        if (this.isRowIndexInvalid(rowIndex) || isRowIndexInvalid(additiveRowIndex)) {
            return;
        }
        ArrayList<T> row = this.matrix.get(rowIndex);
        ArrayList<T> additiveRow = this.matrix.get(additiveRowIndex);
        for (int i = 0; i < this.columnCount; i++) {
            T number = row.get(i);
            T additiveNumber = additiveRow.get(i);
            T scaledAdditive = (T) additiveNumber.multiply(scale);
            row.set(i, (T) number.add(scaledAdditive));
        }
    }

    public boolean isInRowEchelonForm() {
        int previousLeadingEntryIndex = -2;
        for (int i = 0; i < rowCount; i++) {
            int rowFirstNonZeroEntryIndex = this.getFirstNonZeroEntryIndex(i);
            if ((rowFirstNonZeroEntryIndex >= 0 && rowFirstNonZeroEntryIndex <= previousLeadingEntryIndex) || (rowFirstNonZeroEntryIndex >= 0 && previousLeadingEntryIndex == -1)) {
                return false;
            }
            previousLeadingEntryIndex = rowFirstNonZeroEntryIndex;
        }
        return true;
    }

    public void transformToRowEchelonForm() {
        if (this.isInRowEchelonForm()) {
            return;
        }
        int[][] firsNonZeroEntriesInRows = new int[this.rowCount][2];
        for (int i = 0; i < this.rowCount; i++) {
            int firstNonZeroEntryIndex = this.getFirstNonZeroEntryIndex(i);
            firsNonZeroEntriesInRows[i] = new int[]{firstNonZeroEntryIndex, i};
        }
        Matrix.sortNonZeroEntries(firsNonZeroEntriesInRows);
        ArrayList<ArrayList<T>> newMatrix = new ArrayList<>(this.rowCount);
        for (int i = 0; i < this.rowCount; i++) {
            int[] nonZeroEntry = firsNonZeroEntriesInRows[i];
            int rowIndex = nonZeroEntry[1];
            newMatrix.set(i, this.matrix.get(rowIndex));
        }
        this.matrix = newMatrix;
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            int firstNonZeroEntryIndex = this.getFirstNonZeroEntryIndex(rowIndex);
            if (firstNonZeroEntryIndex == -1) {
                break;
            }
            T coefficiant = this.getCoefficiant(rowIndex, firstNonZeroEntryIndex);
            T multiplicativeInverse = (T) coefficiant.getMultiplicativeInverse();
            this.multiplyRowBy(rowIndex, multiplicativeInverse);
            for (int j = rowIndex + 1; j < rowCount; j++) {
                T localCoefficiant = this.getCoefficiant(j, firstNonZeroEntryIndex);
                if (!localCoefficiant.isNonZero()) {
                    break;
                }
                T additiveInverse = (T) localCoefficiant.getAdditiveInverse();
                this.addRowBy(j, rowIndex, additiveInverse);
            }
        }
    }

    public void transformToReducedRowEchelonForm() {
        if (!isInRowEchelonForm()) {
            this.transformToRowEchelonForm();
        }
        for (int rowIndex = 1; rowIndex < this.rowCount; rowIndex++) {
            int firstNonZeroEntryIndex = this.getFirstNonZeroEntryIndex(rowIndex);
            if (firstNonZeroEntryIndex == -1) {
                break;
            }
            for (int j = rowIndex - 1; j >= 0; j--) {
                T localCoefficiant = this.getCoefficiant(j, firstNonZeroEntryIndex);
                if (!localCoefficiant.isNonZero()) {
                    break;
                }
                T additiveInverse = (T) localCoefficiant.getAdditiveInverse();
                this.addRowBy(j, rowIndex, additiveInverse);
            }
        }
    }

    public ArrayList<Integer> getPivotColumnIndexes() throws InvalidFormException {
        if (!this.isInRowEchelonForm()) {
            throw new InvalidFormException();
        }
        ArrayList<Integer> pivotIndexes = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < this.rowCount; rowIndex++) {
            int firstNonZeroEntryIndex = this.getFirstNonZeroEntryIndex(rowIndex);
            if (firstNonZeroEntryIndex == -1) {
                break;
            }
            pivotIndexes.add(firstNonZeroEntryIndex);
        }
        return pivotIndexes;
    }

    public ArrayList<Integer> getFreeColumnIndexes() throws InvalidFormException {
        ArrayList<Integer> pivotIndexes = this.getPivotColumnIndexes();
        ArrayList<Integer> allIndexes = new ArrayList<>();
        for (int i = 0; i <= this.rowCount; i++) {
            allIndexes.add(i);
        }
        for (Integer pivotIndex : pivotIndexes) {
            allIndexes.remove(pivotIndex);
        }
        return allIndexes;
    }

    private boolean isRowIndexInvalid(int rowIndex) {
        return rowIndex >= this.rowCount || rowIndex < 0;
    }

    private int getFirstNonZeroEntryIndex(int rowIndex) {
        if (!isRowIndexInvalid(rowIndex)) {
            return -1;
        }
        ArrayList<T> row = this.matrix.get(rowIndex);
        for (int i = 0; i < row.size(); i++) {
            T entry = row.get(i);
            if (entry.isNonZero()) {
                return i;
            }
        }
        return -1;
    }

    private static void sortNonZeroEntries(int[][] nonZeroEntries) {
        for (int i = 0; i < nonZeroEntries.length - 1; i++) {
            for (int j = 0; j < nonZeroEntries.length - i - 1; j++) {
                if (nonZeroEntries[j][0] > nonZeroEntries[j + 1][0]) {
                    int[] temp = nonZeroEntries[j].clone();
                    nonZeroEntries[j] = nonZeroEntries[j + 1];
                    nonZeroEntries[j + 1] = temp;
                }
            }
        }
    }

    private T getCoefficiant(int rowIndex, int columnIndex) {
        return this.matrix.get(rowIndex).get(columnIndex);
    }
}
