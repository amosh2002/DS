package Shape_and_subclasses;

public class Square extends Shape {
    private int a;
    private int x;
    private int y;

    public Square(int i) {
        super();
        this.a = i;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String getName() {
        return "Square";

    }

    @Override
    public int getHeight() {
        return this.a;
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
        return this.a * this.a;
    }


    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
