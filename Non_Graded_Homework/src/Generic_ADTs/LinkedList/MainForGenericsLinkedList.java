package Generic_ADTs.LinkedList;

import Shape_and_subclasses.Circle;
import Shape_and_subclasses.Rectangle;
import Shape_and_subclasses.Shape;

import java.util.Iterator;

public class MainForGenericsLinkedList {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(1, 1);
        Shape rect2 = new Rectangle(2, 2);
        Shape rect3 = new Rectangle(3, 3);
        Shape rect4 = new Rectangle(4, 4);
        Shape circle1 = new Circle(11);
        Shape circle2 = new Circle(12);
        Shape circle3 = new Circle(13);
        Shape circle4 = new Circle(14);

        GenericsLinkedList<Shape> shapesLinkedList = new GenericsLinkedList<>();

        shapesLinkedList.addLast(rect1);
        shapesLinkedList.addLast(rect2);
        shapesLinkedList.addLast(rect3);
        shapesLinkedList.addLast(rect4);
        shapesLinkedList.addLast(circle1);
        shapesLinkedList.addLast(circle2);

        shapesLinkedList.print();
        System.out.println(shapesLinkedList.size());

        shapesLinkedList.addFirst(circle4);
        //shapesLinkedList.print();
        //System.out.println(shapesLinkedList.size());

        shapesLinkedList.add(2, circle3);
        shapesLinkedList.print();
        //System.out.println(shapesLinkedList.size());

        System.out.println(shapesLinkedList.indexOf(rect2));
        //shapesLinkedList.clear();
        //shapesLinkedList.print();
        //System.out.println(shapesLinkedList.size());


        //shapesLinkedList.remove(rect3);
        shapesLinkedList.print();
        System.out.println(shapesLinkedList.size());

        Iterator<Shape> iterator = shapesLinkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next().describe();
            System.out.println();
        }
    }
}
