package shapes_List_ADTs;

import hw1_problem5.*;


import java.util.Iterator;

public class MainForArrayList {
    public static void main(String[] args) {
        Shape rect1 = new Rectangle(7, 8);
        Shape rect2 = new Rectangle(4, 2);
        Shape rect3 = new Rectangle(7, 8);
        Shape rect4 = new Rectangle(4, 2);
        Shape circle1 = new Circle(8);
        Shape circle2 = new Circle(3);
        Shape circle3 = new Circle(8);
        Shape circle4 = new Circle(3);

        ShapesArrayList shapesArrayList = new ShapesArrayList();

        shapesArrayList.add(0, rect1);
        shapesArrayList.add(1, rect2);
        shapesArrayList.add(2, rect3);
        shapesArrayList.add(3, rect4);
        shapesArrayList.add(4, circle1);
        shapesArrayList.add(5, circle2);
        shapesArrayList.add(6, circle3);
        shapesArrayList.add(7, circle4);


        shapesArrayList.print();
        System.out.println(shapesArrayList.size());

        /*
        shapesArrayList.addFirst(circle4);
        //shapesArrayList.print();
        //System.out.println(shapesArrayList.size());

        shapesArrayList.addLast(circle4);
        //shapesArrayList.print();
        //System.out.println(shapesArrayList.size());

        shapesArrayList.add(1, circle4);
        //shapesArrayList.print();
        //System.out.println(shapesArrayList.size());

        shapesArrayList.removeFirst();
        //shapesArrayList.print();
        //System.out.println(shapesArrayList.size());

        shapesArrayList.removeLast();
        //shapesArrayList.print();
        //System.out.println(shapesArrayList.size());

        System.out.println(shapesArrayList.isEmpty());
        //shapesArrayList.print();
        //System.out.println(shapesArrayList.size());


        System.out.println(shapesArrayList.indexOf(rect1));
        //shapesArrayList.print();
        //System.out.println(shapesArrayList.size());

        shapesArrayList.clear();
        //shapesArrayList.print();
        //System.out.println(shapesArrayList.size());
        */

        Iterator<Shape> iterator = shapesArrayList.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }

        shapesArrayList.print();


    }
}
