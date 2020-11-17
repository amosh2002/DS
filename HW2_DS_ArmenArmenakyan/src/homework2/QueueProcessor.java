package homework2;

import hw1_problem5.Circle;
import hw1_problem5.Rectangle;
import hw1_problem5.Shape;
import Utils.*;

import java.util.Iterator;

public class QueueProcessor {
    public static <T extends Iterable<Shape>> void printQueue(T shapes) {
        System.out.println(ConsoleColors.PURPLE + "Printing " + shapes.getClass().getSimpleName() + ConsoleColors.CYAN);
        Iterator<Shape> iterator = shapes.iterator();
        while (iterator.hasNext()) {
            iterator.next().describe();
            System.out.println();
        }
    }

    public static <T extends Iterable<Shape> & ShapesQueue> void reverseQueue(T shapes) {
        Iterator<Shape> iterator = shapes.iterator();
        if (!iterator.hasNext()) {
            return;
        }
        Shape element = iterator.next();
        shapes.deque();
        reverseQueue(shapes);
        shapes.enqueue(element);
    }

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
        ShapesArrayQueue shapesArrayQueue = new ShapesArrayQueue();

        //Enqueue 3 elements and check the first(), last() and enqueue() functions
        shapesLinkedListQueue.enqueue(rect1);
        shapesLinkedListQueue.enqueue(circle1);
        shapesLinkedListQueue.enqueue(circle2);
        shapesLinkedListQueue.enqueue(rect2);
        shapesLinkedListQueue.enqueue(rect3);

        shapesArrayQueue.enqueue(rect1);
        shapesArrayQueue.enqueue(circle1);
        shapesArrayQueue.enqueue(circle2);
        shapesArrayQueue.enqueue(rect2);
        shapesArrayQueue.enqueue(rect3);

        if (shapesLinkedListQueue.first().equals(rect1) && shapesArrayQueue.first().equals(rect1)) {
            System.out.println(ConsoleColors.GREEN + "TEST first() - Success");
        } else {
            System.out.println(ConsoleColors.RED + "TEST first() - Fail");
        }

        if (shapesLinkedListQueue.first().equals(rect1) && shapesArrayQueue.first().equals(rect1)) {
            System.out.println(ConsoleColors.GREEN + "TEST last() - Success");
        } else {
            System.out.println(ConsoleColors.RED + "TEST last() - Fail");
        }

        if (shapesLinkedListQueue.first().equals(rect1) && shapesLinkedListQueue.last().equals(rect3)
                && shapesArrayQueue.first().equals(rect1) && shapesArrayQueue.last().equals(rect3)) {
            System.out.println(ConsoleColors.GREEN + "TEST enqueue() - Success");
        } else {
            System.out.println(ConsoleColors.RED + "TEST enqueue() - Fail");
        }

        //Dequeue 2 elements and check the dequeue() function
        shapesLinkedListQueue.deque();
        shapesLinkedListQueue.deque();

        shapesArrayQueue.deque();
        shapesArrayQueue.deque();

        if (shapesLinkedListQueue.first().equals(circle2) && shapesLinkedListQueue.last().equals(rect3)
                && shapesArrayQueue.first().equals(circle2) && shapesArrayQueue.last().equals(rect3)) {
            System.out.println(ConsoleColors.GREEN + "TEST dequeue() - Success");
        } else {
            System.out.println(ConsoleColors.RED + "TEST dequeue() - Fail");
        }

        //Check the elementAt() function by calling the first, last, 2nd and 5th elements
        if (shapesLinkedListQueue.elementAt(0).equals(circle2) && shapesLinkedListQueue.elementAt(1).equals(rect2)
                && shapesLinkedListQueue.elementAt(2).equals(rect3) && shapesLinkedListQueue.elementAt(5) == null
                && shapesArrayQueue.elementAt(0).equals(circle2) && shapesArrayQueue.elementAt(1).equals(rect2)
                && shapesArrayQueue.elementAt(2).equals(rect3) && shapesArrayQueue.elementAt(5) == null) {
            System.out.println(ConsoleColors.GREEN + "TEST elementAt() - Success");
        } else {
            System.out.println(ConsoleColors.RED + "TEST elementAt() - Fail");
        }


        //Check the reverseQueue(T) function by checking if the old first is new last after reverse, as well as if the middle element remains on its same position
        //(The queues have 3 elements, so the element at index 1 will remain on its place after reverse)
        Shape temp1 = shapesLinkedListQueue.first();
        Shape temp2 = shapesLinkedListQueue.elementAt(1);

        Shape temp3 = shapesArrayQueue.first();
        Shape temp4 = shapesArrayQueue.elementAt(1);

        reverseQueue(shapesLinkedListQueue);
        reverseQueue(shapesArrayQueue);

        if (temp1.equals(shapesLinkedListQueue.last()) && temp2.equals(shapesLinkedListQueue.elementAt(1))
                && temp3.equals(shapesArrayQueue.last()) && temp4.equals(shapesArrayQueue.elementAt(1))) {
            System.out.println(ConsoleColors.GREEN + "TEST reverseQueue() - Success" + ConsoleColors.PURPLE);
        } else {
            System.out.println(ConsoleColors.RED + "TEST reverseQueue() - Fail" + ConsoleColors.PURPLE);
        }

        //Print the results and check the printQueue(T) function
        System.out.println();
        printQueue(shapesArrayQueue);
        System.out.println(ConsoleColors.WHITE + "-----------------------");
        printQueue(shapesLinkedListQueue);


    }
}
