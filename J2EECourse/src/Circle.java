/*
 * 08-600 
 * Homework #3 
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 13, 2012 
 */

public class Circle extends Shape {
	private double radius;

	public Circle(double newRadius) {
		super(3.1415926*newRadius*newRadius,2*3.1415926*newRadius);
		radius = newRadius;
	}
	
	public double getRadius() { return radius; }

	public String toString() {
		return "Circle(radius="+radius+")";
	}

}
