import java.util.*;

public class QuadraticEquation{
	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA(){
		return a;
	}

	public double getB(){
		return b;
	}

	public double getC(){
		return c;
	}

	public double getDiscriminant(){
		return b*b-4*a*c;
	}
	
	public String Roots(){
		double Discriminant = getDiscriminant();
		
		if (Discriminant < 0)
			return ("Negative Discriminant");
		else if (Discriminant == 0)
			return "Root: " + (Double.toString(-b/2*a));
		else
			return "Root1: "+ (Double.toString((-b+Math.sqrt(getDiscriminant()))/2*a)) +" "+ 
					"Root2: " + (Double.toString((-b-Math.sqrt(getDiscriminant()))/2*a));
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a, b, c: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();

		QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
		System.out.println(quadraticEquation.Roots()); 
	}
}
