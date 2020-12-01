package Shapes_ADTs.Stack;

import Shape_and_subclasses.Shape;

interface ShapesStack {
    int size();
    void push(Shape shape);
    Shape pop();
    Shape top();
    Shape bottom();
    int indexOf(Shape e);

}
