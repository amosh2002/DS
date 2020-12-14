package Generic_ADTs.Deque;

import Generic_ADTs.LinkedList.GenericsLinkedList;
import Shape_and_subclasses.Describable;

import java.util.Iterator;

public class GenericsLinkedListDeque<T extends Describable & Cloneable & Comparable<T>> implements GenericsDeque<T>, Iterable<T> {
    GenericsLinkedList<T> tList;

    public GenericsLinkedListDeque() {
        tList = new GenericsLinkedList<T>();
    }

    @Override
    public void push_front(T tItem) {
        tList.addFirst(tItem);
    }

    @Override
    public T pop_front() {
        T first = front();
        tList.removeFirst();
        return first;

    }

    @Override
    public void push_back(T tItem) {
        tList.addLast(tItem);
    }

    @Override
    public T pop_back() {
        T last = back();
        tList.removeLast();
        return last;

    }

    @Override
    public T front() {
        return tList.getFirst();
    }

    @Override
    public T back() {
        return tList.getLast();
    }

    @Override
    public boolean isEmpty() {
        return tList.isEmpty();
    }

    public int size() {
        return tList.size();
    }

    @Override
    public Iterator<T> iterator() {
        return tList.iterator();
    }

    public Iterator<T> reverseIterator() {
        return tList.reverseEndIndexIterator(size() - 1);
    }

}
