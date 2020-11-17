package Shapes_ADTs.Stack;

import Shape_and_subclasses.Circle;
import Shape_and_subclasses.Rectangle;
import Shape_and_subclasses.Shape;

public class MainForArrayStack {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(7, 8);
        Shape rect2 = new Rectangle(4, 2);
        Shape rect3 = new Rectangle(7, 8);
        Shape rect4 = new Rectangle(4, 2);
        Shape circle1 = new Circle(8);
        Shape circle2 = new Circle(3);
        Shape circle3 = new Circle(8);
        Shape circle4 = new Circle(3);

        ShapesArrayStack shapesArrayStack = new ShapesArrayStack();
        shapesArrayStack.print();
        System.out.println(shapesArrayStack.size());
        shapesArrayStack.push(rect1);
        shapesArrayStack.push(rect2);
        shapesArrayStack.push(rect3);
        shapesArrayStack.print();
        System.out.println(shapesArrayStack.size());
        shapesArrayStack.pop();
        shapesArrayStack.print();
        System.out.println(shapesArrayStack.indexOf(rect2));
        shapesArrayStack.top().describe();


    }
}
