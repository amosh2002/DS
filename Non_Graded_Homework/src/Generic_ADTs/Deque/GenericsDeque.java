package Generic_ADTs.Deque;

import Shape_and_subclasses.Describeable;

public interface GenericsDeque<T extends Describeable> {
    void push_front(T tItem);

    T pop_front();

    void push_back(T tItem);

    T pop_back();

    T front();

    T back();

    boolean isEmpty();
}
