package homework2;

public class Rectangle extends Shape implements Cloneable {
    private int length;
    private int width;

    public Rectangle(int l, int w) {
        super();
        length = l;
        width = w;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }

    public int getHeight() {
        return width;
    }

    public void describe() {
        System.out.println("Rectangle :" + length + ", " + width);
    }

    public String getName() {
        return "Rectangle";
    }

    public Object clone() {
        return new Rectangle(length, width);
    }

}
