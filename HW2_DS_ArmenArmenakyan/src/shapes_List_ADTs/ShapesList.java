package shapes_List_ADTs;

import hw1_problem5.Shape;

public interface ShapesList {
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
