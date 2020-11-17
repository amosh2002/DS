package Shapes_ADTs;

import Shape_and_subclasses.Shape;

public interface ShapesList extends Iterable<Shape> {
    int addLast(Shape shape);
    void addFirst(Shape shape);
    void removeLast();
    void removeFirst();
    void add(int index, Shape e);
    void remove(Shape e);
    int size();
    boolean isEmpty();
    void clear();
    int indexOf(Shape e);
    void print();
    void removeElementAt(int index);
}
