package Shapes_ADTs;

import Shape_and_subclasses.Shape;

import java.util.Iterator;

public interface CustomShapesIterators {
    Iterator<Shape> rectangleIterator();
    Iterator<Shape> circleIterator();
    Iterator<Shape> squareIterator();
    Iterator<Shape> isoscelesTriangleIterator();
}
