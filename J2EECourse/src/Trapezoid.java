/*
 * 08-600 
 * Homework #3 
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 13, 2012 
 */

public class Trapezoid extends Shape {
	private double topWidth;
	private double bottomWidth;
	private double height;

	public Trapezoid(double topWidth, double bottomWidth, double height) {
		super((topWidth + bottomWidth) * height / 2, topWidth
				+ bottomWidth
				+ height
				+ Math.sqrt((bottomWidth - topWidth) * (bottomWidth - topWidth)
						+ height * height));
		this.topWidth = topWidth;
		this.bottomWidth = bottomWidth;
		this.height = height;

	}

	public double getTopWidth() {
		return topWidth;
	}

	public double getBottomWidth() {
		return bottomWidth;
	}

	public double getHeight() {
		return height;
	}
	
	

}
