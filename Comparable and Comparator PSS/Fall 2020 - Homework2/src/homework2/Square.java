package homework2;


public class Square extends Shape{
	private int side;
	public Square(int s) {
		super();
		side = s;
	}
	public int getArea() {
		return (int) Math.pow(side, 2);
	}
	public int getPerimeter() {
		return 4 * side;
	}
	public int getHeight() {
		return side;
	}
	
	public void describe() {
		System.out.println("Square :" + side);
	}
	
	public String getName() {
		return "Square";
	}
	
	public Object clone() {
		return new Square(side);
	}
	

}
