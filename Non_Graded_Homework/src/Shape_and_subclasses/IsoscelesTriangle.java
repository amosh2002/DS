package Shape_and_subclasses;

public class IsoscelesTriangle extends Shape {
    private int a;
    private int h;
    private int x;
    private int y;

    public IsoscelesTriangle(int i, int i1) {
        super();
        this.a = i;
        this.h = i1;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String getName() {
        return "Isosceles Triangle";
    }

    @Override
    public int getHeight() {
        return this.h;
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
        return (double) (this.a * this.h) / 2;
    }



    @Override
    public String rotate() {
        return "Rotating " + this.getName() + " Shape - Custom";
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
