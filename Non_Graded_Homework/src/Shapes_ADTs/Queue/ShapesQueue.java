package Shapes_ADTs.Queue;

import Shape_and_subclasses.*;

public interface ShapesQueue{
    void enqueue(Shape e);
    Shape deque();
    Shape first();
    Shape last();
    Shape elementAt(int index);
}
