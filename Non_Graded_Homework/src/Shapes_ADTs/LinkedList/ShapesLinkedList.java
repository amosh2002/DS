package Shapes_ADTs.LinkedList;

import Shape_and_subclasses.Shape;
import Shapes_ADTs.ShapesList;


import java.util.Iterator;

public class ShapesLinkedList implements ShapesList, Iterable<Shape>, Cloneable {
    private Shape first, last;
    private int size;

    public ShapesLinkedList() {
        this.first = this.last = null;
        size = 0;
    }


    @Override
    public int addLast(Shape e) {
        if (isEmpty()) {
            first = last = e;
        } else {
            e.prev = last;
            e.next = null;
            last.next = e;
            last = e;
        }
        size++;
        return size;
    }

    @Override
    public void addFirst(Shape e) {
        if (isEmpty()) {
            first = last = e;
        } else {
            e.next = first;
            first.prev = e;
            e.prev = null;
            first = e;
        }
        size++;
    }

    @Override
    public void removeLast() {
        if (!isEmpty()) {
            if (size == 1) {
                first = last = null;
            } else {
                last = last.prev;
                last.next.prev = null;
                last.next = null;
            }
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            if (size == 1) {
                first = last = null;
            } else {
                first = first.next;
                first.prev.next = null;
                first.prev = null;
            }
            size--;
        }
    }

    @Override
    public void removeElementAt(int index) {
        if (isEmpty()) {
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Shape cur = getElementAt(index);
        (cur.next).prev = cur.prev;
        (cur.prev).next = cur.next;
        cur.next = null;
        cur.prev = null;
        size--;

    }

    @Override
    public void add(int index, Shape e) {
        if (isEmpty()) {
            last = first = e;
        } else if (index == 0) {
            addFirst(e);
            return;
        } else if (index == size) {
            addLast(e);
            return;
        } else {
            Shape cur = first;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            e.next = cur.next;
            cur.next.prev = e;
            cur.next = e;
            e.prev = cur;
        }
        size++;
    }

    @Override
    public void remove(Shape e) {
        if (!isEmpty()) {
            Shape cur = first;
            while (cur != null) {
                if (cur.equals(e)) {
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
        return first == null && size == 0;
    }

    @Override
    public void clear() {
        Shape cur = first;
        for (int i = 0; i < size; i++) {
            cur.prev = null;
            Shape tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }
        first = last = null;
        size = 0;

    }

    @Override
    public int indexOf(Shape e) {
        if (isEmpty()) {
            return -1;
        }
        Shape cur = first;
        for (int i = 0; i < size; i++) {
            if (cur.equals(e)) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    public Shape getElementAt(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        if (isEmpty()) {
            return null;
        }
        Shape cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public Shape getFirst() {
        return first;
    }

    public Shape getLast() {
        return last;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("Empty");
        }
        Shape cur = first;
        while (cur != null) {
            cur.describe();
            System.out.println();
            cur = cur.next;
        }

    }

    public ShapesLinkedList clone() throws CloneNotSupportedException {
        return (ShapesLinkedList) super.clone();
    }

    @Override
    public Iterator<Shape> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<Shape> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Shape next() {
            return getElementAt(index++);
        }

        @Override
        public void remove() {
            removeElementAt(--index);
        }
    }

    public Iterator<String> namesIterator() {
        return new ShapesLinkedList.ShapeNameIterator();
    }

    public class ShapeNameIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public String next() {
            return getElementAt(index++).getName();
        }
    }

    public Iterator<Double> areasIterator() {
        return new ShapesLinkedList.ShapeAreaIterator();
    }

    public class ShapeAreaIterator implements Iterator<Double> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Double next() {
            return getElementAt(index++).getArea();
        }
    }


}
