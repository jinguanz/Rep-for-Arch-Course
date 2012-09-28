/*
 * 08-600 
 * Homework #3 
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 13, 2012 
 */

public class Square extends Rectangle {
	private double side;

	public Square(double newSide) {
		super(newSide,newSide);
		side = newSide;
	}

	public double getSide() { return side; }

	public String toString() {
		return "Square(side="+side+")";
	}
}
