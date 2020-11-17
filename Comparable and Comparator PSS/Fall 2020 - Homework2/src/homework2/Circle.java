package homework2;

public class Circle extends Shape {
	int radius;
	public Circle(int r) {
		super();
		radius = r;
	}
	public int getArea() {
		return (int) (Math.PI * Math.pow(radius, 2));
	}
	public int getPerimeter() {
		return (int) (2 * Math.PI * radius);
	}
	public int getHeight() {
		return 2 * radius;
	}
	public void describe() {
		System.out.println("Circle :" + radius);
	}
	
	public String getName() {
		return "Circle";
	}
	
	public Object clone() {
		return new Circle(radius);
	}
}
