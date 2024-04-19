/**
 * Author Link Parrish
 * this class tests the point and extended circle object classes
 */
package assg2_parrishl21;

import assg5_parrishl21.ExtendedCircle;
import assg5_parrishl21.Point;

public class ExtendedCircleTest {

	public static void main(String[] args) {
		Point p1 = new Point();
		System.out.println("point 1 created with 0 prams: " + p1);
		
		Point p2 = new Point(1, 1);
		System.out.println("point 2 created with 2 prams: " + p2);
		
		Point p3 = new Point(2, 2);
		System.out.println("point 3 created with 2 prams: " + p3);
		
		p1.setXCoord(2);
		p1.setYCoord(2);
		System.out.println("setter test for point 1: " + p1);
		
		System.out.println("getter test for point 1, x: " + p1.getXCoord() + ", y: " + p1.getYCoord());
		
		System.out.println("distance test p1 to p2: " + p1.distance(p2));
		
		if (p1.equals(p2)) System.out.println("point 1 equals point 2");
		else System.out.println("point 1 does not equals point 2");
		
		if (p1.equals(p3)) System.out.println("point 1 equals point 3");
		else System.out.println("point 1 does not equals point 3");
		
		ExtendedCircle c1 = new ExtendedCircle();
		System.out.println("circle 1 created with 0 prams: " + c1);
		
		ExtendedCircle c2 = new ExtendedCircle(2.5);
		System.out.println("circle 2 created with 1 prams: " + c2);
		
		ExtendedCircle c3 = new ExtendedCircle(3, new Point(3, 3));
		System.out.println("circle 3 created with 2 prams: " + c3);
		
		c1.setRadius(4);
		c1.setCenter(new Point(8, 8));
		System.out.println("setter test for circle 1: " + c1);
		
		System.out.println("getter test for circle 1 radius: " + c1.getRadius() + ", center point: " + c1.getCenter());
		
		System.out.println("circle 1 area: " + c1.compArea());
		System.out.println("circle 1 circumference: " + c1.compCircumference());
		
		System.out.println("position to circle 1 to (5, 5): " + c1.positionToCircle(new Point(6, 6)));
		System.out.println("position to circle 1 to (8, 4): " + c1.positionToCircle(new Point(8, 4)));
		System.out.println("position to circle 1 to (0, 0): " + c1.positionToCircle(new Point(0, 0)));
		
		ExtendedCircle c4 = c1.shift(-4, -4);
		System.out.println("circle 4 is c1 shifted (-4, -4): " + c4);
		
		ExtendedCircle c5 = c4.scale(2);
		System.out.println("circle 5 is c4 scaled by 2: "+ c5);
		
		System.out.println("circle 2 and circle 3 overlap: " + c2.overlap(c3));
		System.out.println("circle 1 and circle 2 overlap: " + c1.overlap(c2));
		
		if (c4.equals(c5)) System.out.println("circle 4 equals circle 5");
		else System.out.println("circle 4 does not equals circle 5");
		
		ExtendedCircle c6 = c5.scale(1);
		System.out.println("circle 6 is: " + c6);
		if (c5.equals(c6)) System.out.println("circle 5 equals circle 6");
		else System.out.println("circle 5 does not equals circle 6");
	}
}
