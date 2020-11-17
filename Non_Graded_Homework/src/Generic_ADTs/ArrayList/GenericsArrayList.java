package Generic_ADTs.ArrayList;

import Generic_ADTs.CustomGenericIterators;
import Generic_ADTs.GenericsList;
import Shape_and_subclasses.Describeable;

import java.util.Iterator;

public class GenericsArrayList<T extends Describeable & Cloneable & Comparable<T>> implements GenericsList<T>, Iterable<T>, CustomGenericIterators<T> {
    private Object[] array;
    private int size;

    public GenericsArrayList(int size) {
        array = new Object[size];
        this.size = 0;
    }

    public GenericsArrayList() {
        array = new Object[10];
        size = 0;
    }

    private void resize() {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @Override
    public int addLast(T tItem) {
        resize();
        array[size] = tItem;
        size++;
        return size;
    }

    @Override
    public void addFirst(T tItem) {
        resize();
        if (size >= 0) System.arraycopy(array, 0, array, 1, size);
        array[0] = tItem;
        size++;
    }

    @Override
    public void removeLast() {
        Object[] newArray = new Object[size - 1];
        System.arraycopy(array, 0, newArray, 0, size - 1);
        array = newArray;
        size--;
    }

    @Override
    public void removeFirst() {
        Object[] newArray = new Object[size - 1];
        System.arraycopy(array, 1, newArray, 0, size - 1);
        array = newArray;
        size--;
    }

    @Override
    public void add(int index, T tItem) {
        resize();
        if (size == index) {
            addLast(tItem);
            return;
        }
        if (0 == index) {
            addFirst(tItem);
            return;
        }
        Object[] newArray = new Object[size + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = tItem;
        for (int i = index + 1; i <= size; i++) {
            newArray[i] = array[i - 1];
        }
        array = newArray;
        size++;

    }

    @Override
    public void remove(T tItem) {
        Object[] newArray = new Object[size - 1];
        int index = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (array[i].equals(tItem)) {
                index = i;
                break;
            }
        }
        System.arraycopy(array, 0, newArray, 0, index);
        if (size - index >= 0) {
            for (int i = index + 1; i < size; i++) {
                newArray[i - 1] = array[i];
            }
        }

        array = newArray;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        new GenericsArrayList<T>();
    }

    @Override
    public int indexOf(T tItem) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(tItem)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            T lul = (T) array[i];
            lul.describe();
            //System.out.print(array[i]);
            if (size - 1 != i) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    @Override
    public T getFirst() {
        return (T) array[0];
    }

    @Override
    public T getLast() {
        return (T) array[size - 1];
    }

    @Override
    public T getElementAt(int index) {
        return (T) array[index];
    }

    @Override
    public void changeValueAt(int index, T element) {
        array[index] = element;
    }

    //Normal Iterator
    @Override
    public Iterator<T> iterator() {
        return new GenericsALIterator();
    }

    public class GenericsALIterator implements Iterator<T> {
        private int index;

        public GenericsALIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return array[index] != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) array[index++];
            }
            return null;
        }
    }

    //Starting Index Iterator
    @Override
    public Iterator<T> startIndexIterator(int index) {
        return new GenericsALStartingIndexIterator(index);
    }

    public class GenericsALStartingIndexIterator implements Iterator<T> {
        private int index;

        public GenericsALStartingIndexIterator(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) array[index++];
            }
            return null;
        }
    }

    //Ending Index Iterator
    @Override
    public Iterator<T> endIndexIterator(int index) {
        return new GenericsALEndIndexIterator(index);
    }

    public class GenericsALEndIndexIterator implements Iterator<T> {
        private int index;
        private int target;

        public GenericsALEndIndexIterator(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            this.index = 0;
            this.target = index;
        }

        @Override
        public boolean hasNext() {
            return index < target;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) array[index++];
            }
            return null;
        }
    }


    //Reverse End Index Iterator
    @Override
    public Iterator<T> reverseEndIndexIterator(int index) {
        return new GenericsALReverseEndIndexIterator(index);
    }

    public class GenericsALReverseEndIndexIterator implements Iterator<T> {
        private int index;

        public GenericsALReverseEndIndexIterator(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) array[index--];
            }
            return null;
        }
    }


}
