package shapes_List_ADTs;

import hw1_problem5.*;

import java.util.Iterator;

public class MainForLinkedList {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(1, 1);
        Shape rect2 = new Rectangle(2, 2);
        Shape rect3 = new Rectangle(3, 3);
        Shape rect4 = new Rectangle(4, 4);
        Shape circle1 = new Circle(11);
        Shape circle2 = new Circle(12);
        Shape circle3 = new Circle(13);
        Shape circle4 = new Circle(14);

        ShapesLinkedList shapesLinkedList = new ShapesLinkedList();

        shapesLinkedList.addLast(rect1);
        shapesLinkedList.addLast(rect2);
        shapesLinkedList.addLast(rect3);
        shapesLinkedList.addLast(rect4);
        shapesLinkedList.addLast(circle1);
        shapesLinkedList.addLast(circle2);
        //shapesLinkedList.print();
        //System.out.println(shapesLinkedList.size());

        //shapesLinkedList.addFirst(circle4);
        //shapesLinkedList.print();
        //System.out.println(shapesLinkedList.size());

        //shapesLinkedList.add(2,circle3);
        //shapesLinkedList.print();
        //System.out.println(shapesLinkedList.size());

        //System.out.println(shapesLinkedList.indexOf(rect2));
        //shapesLinkedList.clear();
        //shapesLinkedList.print();
        //System.out.println(shapesLinkedList.size());

        //shapesLinkedList.remove(rect3);
        //shapesLinkedList.print();
        //System.out.println(shapesLinkedList.size());

        Iterator<Shape> iterator = shapesLinkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next().describe();
            System.out.println();
        }

        iterator = shapesLinkedList.iterator();
        while (iterator.hasNext()) {
            if ((int) iterator.next().getArea() % 2 == 0) {
                iterator.remove();
            }
        }

        iterator = shapesLinkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next().describe();
            System.out.println();
        }


        /*
        Iterator<String> namesIterator = shapesLinkedList.namesIterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }

        Iterator<Double> areasIterator = shapesLinkedList.areasIterator();
        while (areasIterator.hasNext()) {
            System.out.println(areasIterator.next());
        }
*/

    }
}
