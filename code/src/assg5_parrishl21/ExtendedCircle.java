/**
 * Author: Link Parrish
 * This class defines a circle object with a center point and a radius
 */
package assg5_parrishl21;

public class ExtendedCircle {
	
	private double radius;
	private Point center;
	
	private static final double PI = 3.14;
	
	/**
	 * Default constructor
	 */
	public ExtendedCircle() {
		this(1, new Point(0, 0));
	}
	
	/**
	 * Constructor with a given radius 
	 * @param radius The given radius
	 */
	public ExtendedCircle(double radius) {
		this(radius, new Point(0, 0));
	}
	
	/**
	 * Constructor with a given radius and center point
	 * @param radius The given radius
	 * @param x The given center point
	 */
	public ExtendedCircle(double radius, Point center) {
		this.radius = radius;
		this.center = center;
	}

	/**
	 * Retrieves the radius
	 * @return the value of the radius
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * Modify the radius
	 * @param radius The new radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Retrieves the center point
	 * @return The center point object
	 */
	public Point getCenter() {
		return this.center;
	}
	
	/**
	 * Modify the center point
	 * @param center The new center point
	 */
	public void setCenter(Point center) {
		this.center = center;
	}
	
	/**
	 * Computes the area of the circle
	 * @return The area of the circle
	 */
	public double compArea() {
		return PI * this.radius * this.radius;
	}
	
	/**
	 * Computes the circumference of the circle
	 * @return The circumference of the circle
	 */
	public double compCircumference() {
		return PI * this.radius * 2;
	}
	
	/**
	 * Returns a string with the radius and center point
	 * @return A string with the radius and center point
	 */
	public String toString() {
		return "Radius: " + this.radius + "\nCenter: " + this.center;
	}
	
	/**
	 * Determines if a Point is inside, on the edge, or outside a circle
	 * @param p The Point to test
	 * @return -1 if the point is inside, 0 if it is on the edge, or 1 if it is outside the circle
	 */
	public int positionToCircle(Point p) {
		
		if (this.radius < this.center.distance(p))
			return -1;
		
		else if (this.radius == this.center.distance(p))
			return 0;
		
		else
			return 1;
	}
	
	/**
	 * Creates a new circle of the same radius shifted over by x and y places
	 * @param shiftX The number of places to shift on the x-axis
	 * @param shiftY The number of places to shift on the y-axis
	 * @return The new shifted circle
	 */
	public ExtendedCircle shift(int shiftX, int shiftY) {
		return new ExtendedCircle(this.radius, new Point(this.center.getXCoord() + shiftX, this.center.getYCoord() + shiftY));
	}
	
	/**
	 * Creates a new circle with a radius multiplied by the scalar at the same point
	 * @param scalar The number the current radius is multiplied by to find the new radius
	 * @return The new scaled circle
	 */
	public ExtendedCircle scale(double scalar) {
		return new ExtendedCircle(this.radius * scalar, this.center);
	}
	
	/**
	 * Determines if 2 circles overlap
	 * @param otherCircle The circle to check
	 * @return true if the circles overlap, false if they do not
	 */
	public boolean overlap(ExtendedCircle otherCircle) {
		if (this.center.distance(otherCircle.getCenter()) < this.radius + otherCircle.getRadius())
			return true;
		else
			return false;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof ExtendedCircle) {
			ExtendedCircle temp = (ExtendedCircle)obj;
			return (this.radius == temp.radius && this.center.equals(temp.center));
		}
		else
			return false;
	}
}

