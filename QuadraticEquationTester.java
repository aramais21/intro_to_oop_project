import am.aua.oop.solvers.QuadraticEquationSolver;

import java.util.*;

public class QuadraticEquationTester {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter a, b, c: ");
    double a = sc.nextDouble();
    double b = sc.nextDouble();
    double c = sc.nextDouble();

    QuadraticEquationSolver quadraticEquation = new QuadraticEquationSolver(a, b, c);
    System.out.println(quadraticEquation.getSolutionAsString());
  }

}