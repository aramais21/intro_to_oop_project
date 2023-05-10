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
        if(base.size() != rowCount) {
            throw new InvalidBaseException();
        }
        for(int i = 0; i < rowCount; i++) {
            ArrayList<T> row = base.get(i);
            if(row.size() < columnCount) {
                throw new InvalidBaseException();
            }
            ArrayList<T> validatedRow = new ArrayList<>(columnCount);
            Collections.copy(row.subList(0,columnCount-1), validatedRow);
            matrix.set(i, validatedRow);
        }
    }

    public Matrix(Matrix<T> matrixToCopy) {
        this.rowCount = matrixToCopy.rowCount;
        this.columnCount = matrixToCopy.columnCount;
        this.matrix = new ArrayList<ArrayList<T>>(this.rowCount);
        for(int i = 0; i < this.rowCount; i++) {
            ArrayList<T> row = new ArrayList<T>(this.columnCount);
            ArrayList<T> rowToCopy = matrixToCopy.matrix.get(i);
            for (int j = 0; j < this.columnCount; j++){
                T numberToCopy = rowToCopy.get(j);
                row.set(j, (T) numberToCopy.clone());
            }
            matrix.set(i, row);
        }
    }

    public void swapRows (int firstRowIndex, int secondRowIndex) {
        if (this.isRowIndexInvalid(firstRowIndex) || this.isRowIndexInvalid(secondRowIndex)) {
            return;
        }
        ArrayList<T> firstRow = this.matrix.get(firstRowIndex);
        ArrayList<T> secondRow = this.matrix.get(secondRowIndex);
        this.matrix.set(firstRowIndex, secondRow);
        this.matrix.set(secondRowIndex, firstRow);
    }


    private T createACompatibleScaleBasedOnTheNumber(T number, double scale) {
        if(number instanceof SimpleNumber) {
            return (T) new SimpleNumber(scale);
        } else if (number instanceof ModularNumber) {
            return (T) new ModularNumber(scale, ((ModularNumber) number).getBase());
        }
        return (T) new ComplexNumber(scale);
    }

    public void multiplyRowBy(int rowIndex, double scale) {
        if(this.isRowIndexInvalid(rowIndex)) {
            return;
        }
        ArrayList<T> row = this.matrix.get(rowIndex);
        for(int i = 0; i < this.columnCount; i++) {
            T number = row.get(i);
            T scaledNumber = (T) number.multiply(this.createACompatibleScaleBasedOnTheNumber(number, scale));
            row.set(i, scaledNumber);
        }
    }

    public void addRowBy(int rowIndex, int additiveRowIndex, double scale) {
        if(this.isRowIndexInvalid(rowIndex) || isRowIndexInvalid(additiveRowIndex)) {
            return;
        }
        ArrayList<T> row = this.matrix.get(rowIndex);
        ArrayList<T> additiveRow = this.matrix.get(additiveRowIndex);
        for (int i = 0; i < this.columnCount; i++) {
            T number = row.get(i);
            T additiveNumber = additiveRow.get(i);
            T scaledAdditive = (T) additiveNumber.multiply(this.createACompatibleScaleBasedOnTheNumber(additiveNumber, scale));
            row.set(i, (T) number.add(scaledAdditive));
        }
    }

    private boolean isRowIndexInvalid(int rowIndex) {
        return rowIndex >= this.rowCount || rowIndex < 0;
    }

//    TODO add function called getRowEchelonForm
//    TODO add static function that checks if passed matrix is in row echelon form
}
