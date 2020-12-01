package Shape_and_subclasses;

public abstract class Shape implements Cloneable, Moveable, Rotatable, Comparable<Shape>, Describable {
    public Shape prev, next;

    public abstract String getName();

    public abstract int getHeight();

    public void describe() {
        System.out.print(getName() + ": " + getArea());
    }
    
    public abstract int getXCoordinate();

    public abstract int getYCoordinate();

    public abstract double getArea();

    @Override
    public String rotate() {
        return "Rotating " + getName() + " Shape";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int compareTo(Shape s) {
        return (int) (getArea() - s.getArea());
    }
}
