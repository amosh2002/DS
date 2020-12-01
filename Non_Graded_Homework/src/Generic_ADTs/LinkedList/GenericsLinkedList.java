package Generic_ADTs.LinkedList;

import Generic_ADTs.CustomGenericIterators;
import Generic_ADTs.GenericsList;
import Shape_and_subclasses.Describable;

import java.util.Iterator;

public class GenericsLinkedList<T extends Describable & Cloneable & Comparable<T>> implements GenericsList<T>, Iterable<T>, CustomGenericIterators<T> {
    private Node<T> first, last;
    private int size;

    public GenericsLinkedList() {
        first = new Node<T>(null);
        last = new Node<T>(null);
        size = 0;
    }

    public static class Node<T extends Describable> {
        protected T data;
        protected Node<T> prev, next;

        public Node(T data) {
            this.data = data;
            prev = next = null;
        }

        public void describe() {
            data.describe();
        }

    }


    @Override
    public int addLast(T tItem) {
        Node<T> newNode = new Node<>(tItem);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
            last.next = null;
        }
        size++;
        return size;
    }

    @Override
    public void addFirst(T tItem) {
        Node<T> newNode = new Node<>(tItem);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
            first.prev = null;
        }
        size++;
    }

    @Override
    public void removeLast() {
        if (!isEmpty()) {
            last = last.prev;
            last.next = null;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            first = first.next;
            first.prev = null;
            size--;
        }
    }

    @Override
    public void add(int index, T tItem) {
        Node<T> newNode = new Node<>(tItem);
        if (isEmpty()) {
            addLast(tItem);
        }
        Node<T> cur = first;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        newNode.prev = cur;
        newNode.next = cur.next;
        (cur.next).prev = newNode;
        cur.next = newNode;
        size++;
    }

    @Override
    public void remove(T tItem) {
        if (!isEmpty()) {
            Node<T> newNode = new Node<>(tItem);
            Node<T> cur = first;
            while (cur != null) {
                if (cur.equals(newNode)) {
                    (cur.next).prev = cur.prev;
                    (cur.prev).next = cur.next;
                    cur.next = null;
                    cur.prev = null;
                    size--;
                }
                cur = cur.next;
            }

        }
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
        Node<T> cur = first;
        for (int i = 0; i < size; i++) {
            cur.prev = null;
            Node<T> tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public int indexOf(T tItem) {
        if (isEmpty()) {
            return -1;
        }
        Node<T> cur = first;
        for (int i = 0; i < size; i++) {
            if (cur.data.equals(tItem)) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    public T getElementAt(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        if (isEmpty()) {
            return null;
        }
        Node<T> cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public void changeValueAt(int index, T element) {
        Node<T> cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = element;
    }


    public Node<T> getElementAtAsNode(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        if (isEmpty()) {
            return null;
        }
        Node<T> cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Empty");
        }
        Node<T> cur = first;
        while (cur != null) {
            cur.describe();
            System.out.println();
            cur = cur.next;
        }

    }

    @Override
    public T getFirst() {
        return first.data;
    }

    @Override
    public T getLast() {
        return last.data;
    }


    //Normal Iterator
    @Override
    public Iterator<T> iterator() {
        return new GenericsLLIterator();
    }

    public class GenericsLLIterator implements Iterator<T> {
        private Node<T> cur;

        public GenericsLLIterator() {
            cur = first;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                Node<T> s = cur;
                cur = cur.next;
                return s.data;
            }
            return null;
        }
    }

    //Starting Index Iterator
    @Override
    public Iterator<T> startIndexIterator(int index) {
        return new GenericsLLStartingIndexIterator(index);
    }

    public class GenericsLLStartingIndexIterator implements Iterator<T> {
        Node<T> cur;

        public GenericsLLStartingIndexIterator(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            cur = getElementAtAsNode(index);
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                Node<T> s = cur;
                cur = cur.next;
                return s.data;
            }
            return null;
        }
    }

    //Ending Index Iterator
    @Override
    public Iterator<T> endIndexIterator(int index) {
        return null;
    }

    public class GenericsLLEndIndexIterator implements Iterator<T> {
        Node<T> cur;
        Node<T> target;

        public GenericsLLEndIndexIterator(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            cur = first;
            target = getElementAtAsNode(index);
        }

        @Override
        public boolean hasNext() {
            return !cur.equals(target);
        }

        @Override
        public T next() {
            if (hasNext()) {
                Node<T> s = cur;
                cur = cur.next;
                return s.data;
            }
            return null;
        }
    }


    //Reverse End Index Iterator
    @Override
    public Iterator<T> reverseEndIndexIterator(int index) {
        return new GenericsLLSReverseEndIndexIterator(index);
    }

    public class GenericsLLSReverseEndIndexIterator implements Iterator<T> {
        Node<T> cur;

        public GenericsLLSReverseEndIndexIterator(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            cur = getElementAtAsNode(index);
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }


        @Override
        public T next() {
            if (hasNext()) {
                Node<T> s = cur;
                cur = cur.prev;
                return s.data;
            }
            return null;
        }
    }


}
