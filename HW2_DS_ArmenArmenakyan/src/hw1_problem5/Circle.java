package hw1_problem5;

public class Circle extends Shape {
    private int r;
    private int x;
    private int y = 0;

    public Circle(int i) {
        super();
        this.r = i;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public int getHeight() {
        return this.r;
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
        return Math.PI * this.r * this.r;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
