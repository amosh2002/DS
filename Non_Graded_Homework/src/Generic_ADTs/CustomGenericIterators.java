package Generic_ADTs;

import Shape_and_subclasses.Describable;

import java.util.Iterator;

public interface CustomGenericIterators<E extends Describable & Comparable<E> & Cloneable> {
    Iterator<E> startIndexIterator(int index);

    Iterator<E> endIndexIterator(int index);

    Iterator<E> reverseEndIndexIterator(int index);


}
