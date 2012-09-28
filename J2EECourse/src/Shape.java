/*
 * 08-600 
 * Homework #3 
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 13, 2012 
 */

public class Shape {
	private double area;
	private double perimeter;

	public Shape(double newArea,double newPerimeter) {
		area = newArea;
		perimeter=newPerimeter;
		
	}
	


	public double getArea() { return area; }
	
	public double getPerimeter() { return perimeter; }

	public String toString() {
		return "Shape(area=" + area + ")";
	}

}
