package Generic_ADTs;

import Shape_and_subclasses.Describable;

public interface GenericsList<T extends Describable & Comparable<T> & Cloneable> extends Iterable<T>, CustomGenericIterators<T> {
    int addLast(T tItem);
    void addFirst(T tItem);
    void removeLast();
    void removeFirst();
    void add(int index, T tItem);
    void remove(T tItem);
    int size();
    boolean isEmpty();
    void clear();
    int indexOf(T tItem);
    void print();
    T getFirst();
    T getLast();
    T getElementAt(int index);
    void changeValueAt(int index, T element);
}
