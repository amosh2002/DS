package Shapes_ADTs.ArrayList;

import Shape_and_subclasses.Circle;
import Shape_and_subclasses.Rectangle;
import Shape_and_subclasses.Shape;

import java.util.ArrayList;
import java.util.Iterator;

public class MainForArrayList {
    public static void ibsertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    public static void insertionSort(ShapesArrayList arrayList) {
        Iterator<Shape> itr = arrayList.iteratorIndex(1);
        int indexBig = 0;
        while (itr.hasNext()) {
            Shape current = itr.next();
            int indexSmall = indexBig - 1;
            Iterator<Shape> itrSmall = arrayList.reverseIteratorIndex(indexSmall);
            while (itrSmall.hasNext()) {
                Shape currentSmall = itrSmall.next();

            }
            indexBig++;
        }
    }

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
        shapesArrayList.addFirst(circle3);


        //shapesArrayList.print();
        System.out.println(shapesArrayList.size());
        System.out.println(shapesArrayList.lastIndexOf(circle3));

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
            iterator.next().describe();
            System.out.println();
        }
        ArrayList<Integer> arrl = new ArrayList<>();
        arrl.toArray();
        arrl.removeAll(arrl);

        //shapesArrayList.print();


    }
}
