package hw1_problem5;

public abstract class Shape implements Cloneable, Moveable, Rotatable, Describeable {
    public Shape prev, next;

    public abstract String getName();

    @Override
    public void describe() {
        System.out.print(this.getName() + ": " + this.getArea());
    }

    public abstract int getHeight();

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
}
