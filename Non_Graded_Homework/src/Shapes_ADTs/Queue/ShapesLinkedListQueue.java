package Shapes_ADTs.Queue;

import Shape_and_subclasses.*;
import Shapes_ADTs.LinkedList.ShapesLinkedList;

import java.util.Iterator;

public class ShapesLinkedListQueue implements ShapesQueue, Iterable<Shape> {
    ShapesLinkedList shapes;

    public ShapesLinkedListQueue() {
        this.shapes = new ShapesLinkedList();
    }

    @Override
    public Iterator<Shape> iterator() {
        return new ShapesLinkedListQueue.ShapeIterator();
    }

    public class ShapeIterator implements Iterator<Shape> {
        private Shape cur;

        public ShapeIterator() {
            cur = shapes.getFirst();
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Shape next() {
            if (hasNext()) {
                Shape s = cur;
                cur = cur.next;
                return s;
            }
            return null;
        }

        @Override
        public void remove() {
            if (cur.prev == null && cur.next != null) {
                cur = shapes.getFirst();
            } else {
                cur = cur.prev;
            }
            deque();
        }
    }

    @Override
    public void enqueue(Shape e) {
        shapes.addLast(e);
    }

    @Override
    public Shape deque() {
        Shape first = first();
        shapes.removeFirst();
        return first;
    }

    @Override
    public Shape first() {
        return shapes.getFirst();
    }

    @Override
    public Shape last() {
        return shapes.getLast();
    }

    @Override
    public Shape elementAt(int index) {
        return shapes.getElementAt(index);
    }
}
