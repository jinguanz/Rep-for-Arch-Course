/*
 * 08-600 
 * Homework #3 
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 13, 2012 
 * This class is used to sort 10 different shapes (including Circle, Rectangle, Square, and Trapezoid )
 * in ascending order of area or descending order of  perimeter
 * A better way of compare shapes may be shape implement comparable interface.
 */

public class ShapeSortTest {
	// the predefined number of shapes which will be sorted
	final static int SHAPENUMBER = 10;

	static Shape[] shapeList = new Shape[SHAPENUMBER];

	public static void main(String[] args) {
		
		ShapeSortTest sst = new ShapeSortTest();
		sst.initTenShapes();
		System.out
				.println(" Sort by area,  and the result will be in ascending  order of  area.");
		sst.sortByArea(getShapeList());
		System.out.println();
		System.out
				.println("Take a break, sort by permeter and the result will be in descending  order of  perimeter.");
		System.out.println();
		sst.sortByPerimeter(getShapeList());

	}

	private static Shape[] getShapeList() {
		return shapeList;
	}

	// use the bubble sort example provided by lecture slides
	private void sortByArea(Shape[] sl) {
		// bubble sort
		for (int i = 0; i < SHAPENUMBER; i++) {
			for (int j = i + 1; j < SHAPENUMBER; j++) {
				if (sl[i].getArea() > sl[j].getArea()) {
					Shape temp = sl[i];
					sl[i] = sl[j];
					sl[j] = temp;
				}
			}
		}
		// print out the result
		System.out
				.println("the result of sorts the objects in ascending order of area of Shape:");
		for (Shape s : sl) {
			System.out.println(s.getClass().getName() + ": with area "
					+ s.getArea() + "" + " and the perimeter is "
					+ s.getPerimeter());
		}
	}

	// use the bubble sort example provided by lecture slides
	private void sortByPerimeter(Shape[] sl) {
		// bubble sort
		for (int i = 0; i < SHAPENUMBER; i++) {
			for (int j = i + 1; j < SHAPENUMBER; j++) {
				if (sl[i].getPerimeter() < sl[j].getPerimeter()) {
					Shape temp = sl[i];
					sl[i] = sl[j];
					sl[j] = temp;
				}
			}
		}

		// Print out the result
		System.out
				.println("the result of re-sorts the objects in descending order of perimeter of Shape:");
		for (Shape s : sl) {
			System.out.println(s.getClass().getName() + ":  the perimeter is "
					+ s.getPerimeter() + " and with area " + s.getArea());
		}
	}

	// creates at least 10 objects of type Circle, Rectangle, Square, and
	// Trapezoid, at least one of each.
	// create 10 shape instance first and then put them into the shape array
	// waiting for sort
	private void initTenShapes() {
		Circle c1 = new Circle(1.0);
		Rectangle r1 = new Rectangle(1.1, 1.2);
		Square s1 = new Square(1.1);
		Trapezoid t1 = new Trapezoid(1.0, 1.3, 1.0);
		Circle c2 = new Circle(2.0);
		Rectangle r2 = new Rectangle(1.3, 1.4);
		Square s2 = new Square(1.5);
		Trapezoid t2 = new Trapezoid(2.0, 2.3, 1.0);
		Square s3 = new Square(2.5);
		Trapezoid t3 = new Trapezoid(2.0, 2.3, 2.0);

		shapeList[0] = c1;
		shapeList[1] = r1;
		shapeList[2] = s1;
		shapeList[3] = t1;
		shapeList[4] = c2;
		shapeList[5] = r2;
		shapeList[6] = s2;
		shapeList[7] = t2;
		shapeList[8] = s3;
		shapeList[9] = t3;

	}

}
