import Shape_and_subclasses.*;
import Shapes_ADTs.ArrayList.ShapesArrayList;

import java.util.Iterator;

public class ShapesShapeBoard {
    public static void main(String[] args) {
        ShapesArrayList shapesArrayList = new ShapesArrayList();

        Shape rect2 = new Rectangle(2, 2);
        Shape rect4 = new Rectangle(4, 4);
        Shape rect3 = new Rectangle(3, 3);
        Shape rect1 = new Rectangle(1, 1);
        Shape circle1 = new Circle(11);
        Shape circle2 = new Circle(12);
        Shape square1 = new Square(13);
        Shape square2 = new Square(3);
        Shape triangle1 = new IsoscelesTriangle(2,14);

        shapesArrayList.addLast(rect4);
        shapesArrayList.addLast(circle1);
        shapesArrayList.addLast(rect3);
        shapesArrayList.addLast(rect1);
        shapesArrayList.addLast(circle2);
        shapesArrayList.addLast(rect2);
        shapesArrayList.addLast(square1);
        shapesArrayList.addLast(square2);
        shapesArrayList.addLast(triangle1);

        Iterator<Shape> shapeIterator = shapesArrayList.iterator();
        while (shapeIterator.hasNext()) {
            shapeIterator.next().describe();
            System.out.println();
        }

        System.out.println("//////////////////");
        shapeIterator = shapesArrayList.rectangleIterator();
        while (shapeIterator.hasNext()){
            shapeIterator.next().describe();
            System.out.println();
        }

        System.out.println("//////////////////");
        shapeIterator = shapesArrayList.circleIterator();
        while (shapeIterator.hasNext()){
            shapeIterator.next().describe();
            System.out.println();
        }

        System.out.println("//////////////////");
        shapeIterator = shapesArrayList.squareIterator();
        while (shapeIterator.hasNext()){
            shapeIterator.next().describe();
            System.out.println();
        }

        System.out.println("//////////////////");
        shapeIterator = shapesArrayList.isoscelesTriangleIterator();
        while (shapeIterator.hasNext()){
            shapeIterator.next().describe();
            System.out.println();
        }

    }
}
