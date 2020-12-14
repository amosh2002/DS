package Shapes_ADTs.BST;

import Shape_and_subclasses.Shape;
import Shape_and_subclasses.Square;

import java.util.Iterator;

public class MainForBST {
    public static void main(String[] args) {
        Shape square1 = new Square(10);
        Shape square2 = new Square(5);
        Shape square3 = new Square(3);
        Shape square4 = new Square(2);
        Shape square5 = new Square(1);
        Shape square6 = new Square(7);
        Shape square7 = new Square(6);
        Shape square8 = new Square(8);
        Shape square9 = new Square(9);
        Shape square10 = new Square(11);

        ShapesBST btree = new ShapesBST();
        btree.insertNonRec(square1);
        btree.insertNonRec(square2);
        btree.insertNonRec(square3);
        btree.insertNonRec(square4);
        btree.insert(square5);
        btree.insert(square6);
        btree.insert(square7);
        btree.insert(square8);
        btree.insert(square9);
        btree.insert(square10);

        System.out.println("In order Iterator");
        for (Shape shape : btree) {
            shape.describe();
            System.out.println();
        }

        System.out.println("Post order Iterator");
        Iterator<Shape> postOrderIterator = btree.postOrderIterator();
        while (postOrderIterator.hasNext()) {
            postOrderIterator.next().describe();
            System.out.println();
        }

        System.out.println("Pre order Iterator");
        Iterator<Shape> preOrderIterator = btree.preOrderIterator();
        while (preOrderIterator.hasNext()) {
            preOrderIterator.next().describe();
            System.out.println();
        }

        System.out.println(btree.isComplete());
        System.out.println(btree.isFull());
        System.out.println(btree.contains(square2));

        ShapesBST btree2 = new ShapesBST();
        btree2.insertNonRec(square2);
        btree2.insertNonRec(square3);
        btree2.insertNonRec(square4);
        btree2.insertNonRec(square6);
        btree2.insertNonRec(square7);
        btree2.insertNonRec(square8);
        //System.out.println(btree.isSubtree(btree2));
        System.out.println("Post order stack Iterator");
        Iterator<Shape> postStack = btree.postOrderIterator();
        while (postStack.hasNext()) {
            postStack.next().describe();
            System.out.println();
        }
        System.out.println("Post order Iterator");
        Iterator<Shape> postNorm = btree.postOrderIteratorNormal();
        while (postNorm.hasNext()) {
            postNorm.next().describe();
            System.out.println();
        }

    }
}
