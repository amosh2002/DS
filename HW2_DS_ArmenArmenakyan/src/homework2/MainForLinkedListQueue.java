package homework2;

import hw1_problem5.Circle;
import hw1_problem5.Rectangle;
import hw1_problem5.Shape;

import java.util.Iterator;

public class MainForLinkedListQueue {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(7, 8);
        Shape rect2 = new Rectangle(4, 1);
        Shape rect3 = new Rectangle(7, 5);
        Shape rect4 = new Rectangle(4, 2);
        Shape circle1 = new Circle(8);
        Shape circle2 = new Circle(5);
        Shape circle3 = new Circle(3);
        Shape circle4 = new Circle(2);

        ShapesLinkedListQueue shapesLinkedListQueue = new ShapesLinkedListQueue();

        shapesLinkedListQueue.enqueue(rect1);
        shapesLinkedListQueue.enqueue(rect2);
        shapesLinkedListQueue.enqueue(rect3);
        shapesLinkedListQueue.enqueue(rect4);
        shapesLinkedListQueue.deque();
        shapesLinkedListQueue.deque();
        shapesLinkedListQueue.deque();
        shapesLinkedListQueue.enqueue(rect3);
        shapesLinkedListQueue.enqueue(rect1);
        shapesLinkedListQueue.deque();
        shapesLinkedListQueue.enqueue(circle1);
        shapesLinkedListQueue.enqueue(circle2);
        shapesLinkedListQueue.deque();
        shapesLinkedListQueue.enqueue(circle3);
        shapesLinkedListQueue.enqueue(circle4);
        shapesLinkedListQueue.deque();
        shapesLinkedListQueue.deque();
        shapesLinkedListQueue.deque();

        Iterator<Shape> arrayQueueIterator = shapesLinkedListQueue.iterator();
        while (arrayQueueIterator.hasNext()) {
            arrayQueueIterator.next().describe();
            System.out.println();
        }

    }
}
