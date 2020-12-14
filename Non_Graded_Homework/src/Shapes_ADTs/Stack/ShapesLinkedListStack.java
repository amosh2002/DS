package Shapes_ADTs.Stack;

import Shape_and_subclasses.Shape;
import Shapes_ADTs.LinkedList.ShapesLinkedList;

import java.util.Iterator;

public class ShapesLinkedListStack implements ShapesStack, Iterable<Shape> {
    ShapesLinkedList shapes;

    public ShapesLinkedListStack() {
        this.shapes = new ShapesLinkedList();
    }

    @Override
    public int size() {
        return shapes.size();
    }

    @Override
    public void push(Shape shape) {
        shapes.addLast(shape);
    }

    @Override
    public Shape pop() {
        Shape tmp = shapes.getLast();
        shapes.removeLast();
        return tmp;
    }

    @Override
    public Shape top() {
        return shapes.getLast();
    }

    @Override
    public Shape bottom() {
        return shapes.getFirst();
    }

    @Override
    public int indexOf(Shape e) {
        return shapes.indexOf(e);
    }

    @Override
    public Iterator<Shape> iterator() {
        return new ShapesLLStackIterator();
    }
    public Iterator<Shape> startingIndexIterator(int index) {
        return new ShapesStartingIndexLLStackIterator(index);
    }
    public Iterator<Shape> reverseIterator() {
        return new ShapesReverseLLStackIterator();
    }
    public Iterator<Shape> reverseIndexIterator(int index) {
        return new ShapesReverseIndexLLStackIterator(index);
    }

    public class ShapesLLStackIterator implements Iterator<Shape> {
        Shape cur;

        public ShapesLLStackIterator() {
            cur = bottom();
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Shape next() {
            Shape tmp = cur;
            cur = cur.next;
            return tmp;
        }
    }
    public class ShapesStartingIndexLLStackIterator implements Iterator<Shape> {
        Shape cur;

        public ShapesStartingIndexLLStackIterator(int index) {
            cur = shapes.getElementAt(index);
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Shape next() {
            Shape tmp = cur;
            cur = cur.next;
            return tmp;
        }
    }
    public class ShapesReverseLLStackIterator implements Iterator<Shape> {
        Shape cur;

        public ShapesReverseLLStackIterator() {
            cur = top();
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Shape next() {
            Shape tmp = cur;
            cur = cur.prev;
            return tmp;
        }
    }
    public class ShapesReverseIndexLLStackIterator implements Iterator<Shape> {
        Shape cur;

        public ShapesReverseIndexLLStackIterator(int index) {
            cur = shapes.getElementAt(index);
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Shape next() {
            Shape tmp = cur;
            cur = cur.prev;
            return tmp;
        }
    }

}
