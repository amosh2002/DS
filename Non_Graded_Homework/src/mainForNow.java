import Shape_and_subclasses.Rectangle;
import Shape_and_subclasses.Shape;
import Shapes_ADTs.ArrayList.ShapesArrayList;
import Shapes_ADTs.LinkedList.ShapesLinkedList;

import java.util.Iterator;

public class mainForNow {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 5, 3, 8, 6, 5};
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }

        ShapesArrayList shapesArrayList = new ShapesArrayList();
        Shape rect2 = new Rectangle(2, 2);
        Shape rect4 = new Rectangle(4, 4);
        Shape rect3 = new Rectangle(3, 3);

        shapesArrayList.addLast(rect2);
        shapesArrayList.addLast(rect4);
        shapesArrayList.addLast(rect3);

        Iterator<Shape> shapeIterator = shapesArrayList.iterator();
        while (shapeIterator.hasNext()) {
            shapeIterator.next().describe();
            System.out.println();
        }

        for (int i : intArr) {
            System.out.println(i);
        }
    }

}
