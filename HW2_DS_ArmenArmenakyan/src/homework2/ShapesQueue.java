package homework2;

import hw1_problem5.*;

public interface ShapesQueue{
    void enqueue(Shape e);
    Shape deque();
    Shape first();
    Shape last();
    Shape elementAt(int index);
}
