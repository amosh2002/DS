package Shapes_ADTs.BST;

import Shape_and_subclasses.Shape;

import java.util.Iterator;

public interface BSTIterators {
    Iterator<Shape> postOrderIterator();
    Iterator<Shape> preOrderIterator();
}
