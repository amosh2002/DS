package Generic_ADTs.Deque;

import Shape_and_subclasses.Circle;
import Shape_and_subclasses.Rectangle;
import Shape_and_subclasses.Shape;

import java.util.Iterator;

public class MainForGenericsArrayListDeque {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(1, 1);
        Shape rect2 = new Rectangle(2, 2);
        Shape rect3 = new Rectangle(3, 3);
        Shape rect4 = new Rectangle(4, 4);
        Shape circle1 = new Circle(11);
        Shape circle2 = new Circle(12);
        Shape circle3 = new Circle(13);
        Shape circle4 = new Circle(14);

        GenericsArrayListDeque<Shape> shapesArrayListDeque = new GenericsArrayListDeque<>();

        shapesArrayListDeque.push_front(rect1);
        shapesArrayListDeque.push_front(rect2);
        shapesArrayListDeque.push_front(rect3);
        shapesArrayListDeque.push_front(rect4);
        shapesArrayListDeque.push_front(circle1);
        shapesArrayListDeque.push_front(circle2);


        shapesArrayListDeque.push_back(circle4);
        //shapesArrayListDeque.print();
        //System.out.println(shapesArrayListDeque.size());

        shapesArrayListDeque.push_back(circle3);
        shapesArrayListDeque.pop_back();
        shapesArrayListDeque.pop_front();
        //System.out.println(shapesArrayListDeque.size());
        //shapesArrayListDeque.clear();
        //shapesArrayListDeque.print();
        //System.out.println(shapesArrayListDeque.size());


        //shapesArrayListDeque.remove(rect3);

        Iterator<Shape> iterator = shapesArrayListDeque.iterator();
        while (iterator.hasNext()) {
            iterator.next().describe();
            System.out.println();
        }
    }
}
