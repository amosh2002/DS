package shapes_List_ADTs;

import hw1_problem5.*;

public class MainForStack {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(7, 8);
        Shape rect2 = new Rectangle(4, 2);
        Shape rect3 = new Rectangle(7, 8);
        Shape rect4 = new Rectangle(4, 2);
        Shape circle1 = new Circle(8);
        Shape circle2 = new Circle(3);
        Shape circle3 = new Circle(8);
        Shape circle4 = new Circle(3);

        ShapesStack shapesStack = new ShapesStack();
        shapesStack.print();
        System.out.println(shapesStack.size());
        shapesStack.pull(rect1);
        shapesStack.pull(rect2);
        shapesStack.pull(rect3);
        shapesStack.print();
        System.out.println(shapesStack.size());
        shapesStack.pop();
        shapesStack.print();
        System.out.println(shapesStack.indexOf(rect2));
        shapesStack.top().describe();


    }
}
