package Shapes_ADTs.Stack;

import Shape_and_subclasses.Circle;
import Shape_and_subclasses.Rectangle;
import Shape_and_subclasses.Shape;

import java.util.Iterator;

public class MainForLinkedListStack {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(7, 8);
        Shape rect2 = new Rectangle(4, 2);
        Shape rect3 = new Rectangle(7, 8);
        Shape rect4 = new Rectangle(4, 2);
        Shape circle1 = new Circle(8);
        Shape circle2 = new Circle(3);
        Shape circle3 = new Circle(8);
        Shape circle4 = new Circle(3);

        ShapesLinkedListStack shapesLinkedListStack = new ShapesLinkedListStack();

        Iterator<Shape> shapesLLStackIterator = shapesLinkedListStack.iterator();
        while (shapesLLStackIterator.hasNext()){
            shapesLLStackIterator.next().describe();
            System.out.println();
        }

        System.out.println(shapesLinkedListStack.size());
        shapesLinkedListStack.push(rect1);
        shapesLinkedListStack.push(rect2);
        shapesLinkedListStack.push(rect3);

        shapesLLStackIterator = shapesLinkedListStack.iterator();
        while (shapesLLStackIterator.hasNext()){
            shapesLLStackIterator.next().describe();
            System.out.println();
        }

        System.out.println(shapesLinkedListStack.size());
        shapesLinkedListStack.pop();

        shapesLLStackIterator = shapesLinkedListStack.iterator();
        while (shapesLLStackIterator.hasNext()){
            shapesLLStackIterator.next().describe();
            System.out.println();
        }

        System.out.println(shapesLinkedListStack.indexOf(rect2));
        shapesLinkedListStack.top().describe();


    }
}
