import Generic_ADTs.ArrayList.GenericsArrayList;
import Generic_ADTs.GenericsList;
import Shape_and_subclasses.Circle;
import Shape_and_subclasses.Describeable;
import Shape_and_subclasses.Rectangle;
import Shape_and_subclasses.Shape;
import Utils.CustomSortingAlgorithms;

import java.util.Iterator;

public class GenericsShapesBoard {


    public static void main(String[] args) {
        GenericsArrayList<Shape> genericsArrayList = new GenericsArrayList<>();

        Shape rect2 = new Rectangle(2, 2);
        Shape rect4 = new Rectangle(4, 4);
        Shape rect3 = new Rectangle(3, 3);
        Shape rect1 = new Rectangle(1, 1);
        Shape circle1 = new Circle(11);
        Shape circle2 = new Circle(12);
        Shape circle3 = new Circle(13);
        Shape circle4 = new Circle(14);

        genericsArrayList.addLast(rect4);
        genericsArrayList.addLast(circle1);
        genericsArrayList.addLast(rect3);
        genericsArrayList.addLast(rect1);
        genericsArrayList.addLast(circle2);
        genericsArrayList.addLast(rect2);

        Iterator<Shape> iterator = genericsArrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next().describe();
            System.out.println();
        }
        //CustomSortingAlgorithms.selectionSort(genericsArrayList);
        //CustomSortingAlgorithms.insertionSort(genericsArrayList);
        //CustomSortingAlgorithms.bubbleSort(genericsArrayList);
        //CustomSortingAlgorithms.selectionSortRecursive(genericsArrayList);
        //CustomSortingAlgorithms.insertionSortRecursive(genericsArrayList);
        CustomSortingAlgorithms.bubbleSortRecursive(genericsArrayList);


        System.out.println("///////");
        iterator = genericsArrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next().describe();
            System.out.println();
        }


    }
}
