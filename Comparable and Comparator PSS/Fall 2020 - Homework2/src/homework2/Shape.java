package homework2;


import java.util.*;

public abstract class Shape implements Movable, Rotatable, Cloneable, Comparable<Shape> {
	private int x;
	private int y;
	public Shape prev;
	public Shape next;
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		prev = next = null;
	}
	public Shape() {
		x = 0;
		y = 0;
	}
	public int getXCoordinate() {
		return x;
	}
	public int getYCoordinate() {
		return y;
	}
	public String rotate() {
		return "Rotating " + getName() + " Shape";
	}
	public abstract int getArea();
	public abstract int getPerimeter();
	public abstract int getHeight();
	public abstract void describe();
	public String getName() {
		return "Shape";
	}
	
	public abstract Object clone();
	
		
	public int compareTo(Shape s) {
		return getArea() - s.getArea();
	}
	
	public static class ShapeNameComparator implements Comparator<Shape> {

		@Override
		public int compare(Shape arg0, Shape arg1) {
			return arg0.getClass().getSimpleName().compareTo(arg1.getClass().getSimpleName());
		}
		
	}
	
	public static class ShapeHeightComparator implements Comparator<Shape> {

		@Override
		public int compare(Shape arg0, Shape arg1) {
			return arg0.getHeight() - arg1.getHeight();
		}	
	}
}
