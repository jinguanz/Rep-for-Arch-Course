/*
 * 08-600 
 * Homework #3 
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 13, 2012 
 */


public class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle(double newWidth, double newHeight) {
		super(newWidth * newHeight,2*(newWidth+newHeight));
		width  = newWidth;
		height = newHeight;
	}

	public double getHeight() { return height; }
	public double getWidth()  { return width;  }

	public String toString() {
		return "Rectangle(width=" + width+", height=" + height + ")";
	}
}
