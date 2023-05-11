package am.aua.oop.solvers;

import am.aua.oop.numbers.Numbers;

import java.util.ArrayList;

public class VectorSolution<T extends Numbers> implements Solution {
    ArrayList<ArrayList<T>> vectors;

    public VectorSolution(ArrayList<ArrayList<T>> vectors) {
        ArrayList<ArrayList<T>> copy = new ArrayList<>();
        for (int i = 0; i < vectors.size(); i++) {
            copy.add(vectors.get(i));
        }
        this.vectors = copy;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("Some possible solutions are ");
        for(int i = 0; i < this.vectors.size(); i++) {
            builder.append("{ ");
            ArrayList<T> vector = this.vectors.get(i);
            for (int  j = 0; j < vector.size(); j++) {
                builder.append(vector.get(j));
                if (j != vector.size() -1) {
                    builder.append(", ");
                }
            }
            builder.append(" },");
        }
        return builder.toString();
    }
}
