package Generic_ADTs.Deque;

import Generic_ADTs.LinkedList.GenericsLinkedList;
import Shape_and_subclasses.*;


import java.util.Iterator;

public class MainForGenericsLinkedListDeque {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(1, 1);
        Shape rect2 = new Rectangle(2, 2);
        Shape rect3 = new Rectangle(3, 3);
        Shape rect4 = new Rectangle(4, 4);
        Shape circle1 = new Circle(11);
        Shape circle2 = new Circle(12);
        Shape circle3 = new Circle(13);
        Shape circle4 = new Circle(14);

        GenericsLinkedListDeque<Shape> shapesLinkedListDeque = new GenericsLinkedListDeque<>();

        shapesLinkedListDeque.push_front(rect1);
        shapesLinkedListDeque.push_front(rect2);
        shapesLinkedListDeque.push_front(rect3);
        shapesLinkedListDeque.push_front(rect4);
        shapesLinkedListDeque.push_front(circle1);
        shapesLinkedListDeque.push_front(circle2);


        shapesLinkedListDeque.push_back(circle4);
        //shapesLinkedListDeque.print();
        //System.out.println(shapesLinkedListDeque.size());

        shapesLinkedListDeque.push_back(circle3);
        shapesLinkedListDeque.pop_back();
        shapesLinkedListDeque.pop_front();
        //System.out.println(shapesLinkedListDeque.size());
        //shapesLinkedListDeque.clear();
        //shapesLinkedListDeque.print();
        //System.out.println(shapesLinkedListDeque.size());


        //shapesLinkedListDeque.remove(rect3);

        Iterator<Shape> iterator = shapesLinkedListDeque.iterator();
        while (iterator.hasNext()) {
            iterator.next().describe();
            System.out.println();
        }
    }
}
