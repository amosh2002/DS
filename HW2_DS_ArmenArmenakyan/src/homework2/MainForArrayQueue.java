package homework2;

import hw1_problem5.*;

import java.util.Arrays;
import java.util.Iterator;

public class MainForArrayQueue {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(7, 8);
        Shape rect2 = new Rectangle(4, 1);
        Shape rect3 = new Rectangle(7, 5);
        Shape rect4 = new Rectangle(4, 2);
        Shape circle1 = new Circle(8);
        Shape circle2 = new Circle(5);
        Shape circle3 = new Circle(3);
        Shape circle4 = new Circle(2);

        ShapesArrayQueue shapesArrayQueue = new ShapesArrayQueue();

        shapesArrayQueue.enqueue(rect1);
        shapesArrayQueue.enqueue(rect2);
        shapesArrayQueue.enqueue(rect3);
        shapesArrayQueue.enqueue(rect4);
        shapesArrayQueue.enqueue(rect1);
        shapesArrayQueue.enqueue(rect2);
        shapesArrayQueue.enqueue(rect3);
        shapesArrayQueue.enqueue(rect4);
        shapesArrayQueue.enqueue(rect1);
        shapesArrayQueue.enqueue(rect2);
        shapesArrayQueue.deque();
        shapesArrayQueue.deque();
        shapesArrayQueue.deque();
        shapesArrayQueue.enqueue(rect3);
        shapesArrayQueue.enqueue(rect4);
        shapesArrayQueue.enqueue(rect1);
        shapesArrayQueue.enqueue(rect2);
        shapesArrayQueue.enqueue(rect3);
        shapesArrayQueue.enqueue(rect4);
        shapesArrayQueue.deque();
        shapesArrayQueue.enqueue(circle1);
        shapesArrayQueue.enqueue(circle2);
        shapesArrayQueue.deque();
        shapesArrayQueue.enqueue(circle3);
        shapesArrayQueue.enqueue(circle4);
        shapesArrayQueue.deque();
        shapesArrayQueue.deque();
        shapesArrayQueue.deque();
        shapesArrayQueue.enqueue(rect4);
        shapesArrayQueue.enqueue(circle3);

        Iterator<Shape> arrayQueueIterator = shapesArrayQueue.iterator();
        while (arrayQueueIterator.hasNext()) {
            arrayQueueIterator.next().describe();
            System.out.println();
        }

    }
}
