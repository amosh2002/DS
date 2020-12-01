package Generic_ADTs.Deque;

import Shape_and_subclasses.Describable;
import Shape_and_subclasses.Shape;

import java.util.Iterator;

public class GenericsArrayListDeque<T extends Describable> implements GenericsDeque<T>, Iterable<T> {
    Object[] tList;
    int first, size;

    public GenericsArrayListDeque() {
        tList = new Object[10];
        first = size = 0;
    }

    public GenericsArrayListDeque(int size) {
        tList = new Object[size];
        first = this.size = 0;
    }


    private void resize() {
        if (size == tList.length) {
            Object[] newShapes = new Shape[tList.length * 2];
            for (int i = 0; i < size; i++) {
                newShapes[i] = tList[(first + i) % size];
            }
            tList = newShapes;
            first = 0;

        }
    }

    @Override
    public void push_front(T tItem) {
        resize();
        tList[(first - 1 + tList.length) % tList.length] = tItem;
        first = (first - 1 + tList.length) % tList.length;
        size++;
    }

    @Override
    public T pop_front() {
        if (!isEmpty()) {
            T tmp = front();
            tList[first] = null;
            first = (first + 1) % tList.length;
            size--;
            return tmp;
        }
        return null;
    }

    @Override
    public void push_back(T tItem) {
        resize();
        tList[(first + size++) % tList.length] = tItem;
    }

    @Override
    public T pop_back() {
        T tmp = back();
        tList[(first + size - 1) % tList.length] = null;
        size--;
        return tmp;
    }

    @Override
    public T front() {
        if (!isEmpty()) {
            return (T) tList[first];
        }
        return null;
    }

    @Override
    public T back() {
        if (!isEmpty()) {
            return (T) tList[(first + size - 1) % tList.length];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericsALDequeIterator();
    }

    public class GenericsALDequeIterator implements Iterator<T> {
        private int index;

        public GenericsALDequeIterator() {
            index = first;
        }

        @Override
        public boolean hasNext() {
            return tList[index % tList.length] != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) tList[(index++) % tList.length];
            }
            return null;
        }
    }
}
