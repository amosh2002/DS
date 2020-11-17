package Generic_ADTs;

import Shape_and_subclasses.Describeable;
import Shape_and_subclasses.Shape;

import java.util.Iterator;

public interface CustomGenericIterators<E extends Describeable & Comparable<E> & Cloneable> {
    Iterator<E> startIndexIterator(int index);

    Iterator<E> endIndexIterator(int index);

    Iterator<E> reverseEndIndexIterator(int index);


}
