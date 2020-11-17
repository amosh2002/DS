package hw1_problem5;

public class Rectangle extends Shape {
    private int a;
    private int b;
    private int x;
    private int y;

    public Rectangle(int i, int i1) {
        super();
        this.a = i;
        this.b = i1;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public int getHeight() {
        return this.b;
    }

    @Override
    public int getXCoordinate() {
        return this.x;
    }

    @Override
    public int getYCoordinate() {
        return this.y;
    }

    @Override
    public double getArea() {
        return this.a * this.b;
    }

    @Override
    public String rotate() {
        return "Rotating " + this.getName() + " shape - Custom";
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
