package homework2;

public class IsoscelesTriangle extends Shape {
	private int height;
	private int base;
	public IsoscelesTriangle(int h, int b) {
		super();
		height = h;
		base = b;
	}
	public int getArea() {
		return base * height / 2;
	}
	public int getPerimeter() {
		int side = (int) Math.sqrt(Math.pow(height, 2) + Math.pow(base/2, 2));
		return 2 * side + base;
	}
	public int getHeight() {
		return height;
	}
	public void describe() {
		System.out.println("Triangle :" + height + ", " + base);
	}

	public String rotate() {
		return "Rotating Isosceles Triangle Shape - Custom";
	}
	
	public Object clone() {
		return new IsoscelesTriangle(height, base);
	}
}
