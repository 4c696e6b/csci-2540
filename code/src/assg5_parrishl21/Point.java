/**
 * Author: Link Parrish
 * This class defines a point object with an x and y coordinate
 */
package assg5_parrishl21;

public class Point {
	private int x;
	private int y;
	
	/**
	 * Default constructor
	 */
	public Point() {
		this(0, 0);
	}
	/**
	 * Constructor with given coordinates
	 * @param x The given x-coordinate
	 * @param y The given y-coordinate
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Retrieves the x-coordinate
	 * @return The value of x
	 */
	public int getXCoord() {
		return this.x;
	}
	
	/**
	 * Retrieves the y-coordinate
	 * @return The value of y
	 */
	public int getYCoord() {
		return this.y;
	}
	
	/**
	 * Modify the x-coordinate
	 * @param x The new x-coordinate
	 */
	public void setXCoord(int x) {
		this.x = x;
	}
	
	/**
	 * Modify the y-coordinate
	 * @param y The new y-coordinate
	 */
	public void setYCoord(int y) {
		this.y = y;
	}
	
	/**
	 * Returns a string with both coordinates in the form (x, y)
	 * @return The string with the coordinates
	 */
	public String toString() {
		return "("+ this.x + ", " + this.y + ")";
	}
	
	/**
	 * Calculates the distance between 2 points
	 * @param otherPoint The point to calculate the distance between
	 * @return The distance between the two points
	 */
	public double distance(Point otherPoint) {
		return Math.abs(Math.sqrt((Math.pow((this.getXCoord() - otherPoint.getXCoord()), 2)) + (Math.pow((this.getYCoord() - otherPoint.getYCoord()), 2))));	
	}
	
	/**
	 * Checks if the Point object is equal to another Point object
	 * @param otherPoint Point object to compare
	 * @return True if the objects are equal, otherwise false
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Point) {
			Point temp = (Point)obj;
			return (this.x == temp.x && this.y == temp.y);
		}
		else
			return false;
	}
}