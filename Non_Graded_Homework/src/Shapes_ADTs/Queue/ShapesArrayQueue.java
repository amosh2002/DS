package Shapes_ADTs.Queue;

import Shape_and_subclasses.Shape;

import java.util.Iterator;

public class ShapesArrayQueue implements ShapesQueue, Iterable<Shape> {
    Shape[] shapes;
    int first, size;

    public ShapesArrayQueue() {
        shapes = new Shape[10];
        first = size = 0;
    }

    public ShapesArrayQueue(int size) {
        shapes = new Shape[size];
        first = this.size = 0;
    }


    private void resize() {
        if (size == shapes.length) {
            Shape[] newShapes = new Shape[shapes.length * 2];
            for (int i = 0; i < size; i++) {
                newShapes[i] = shapes[(first + i) % size];
            }
            shapes = newShapes;
            first = 0;

        }
    }

    @Override
    public void enqueue(Shape e) {
        resize();
        shapes[(first + size++) % shapes.length] = e;
    }

    @Override
    public Shape deque() {
        if (size != 0) {
            Shape tmp = shapes[first];
            shapes[first] = null;
            first = (first + 1) % shapes.length;
            size--;
            return tmp;
        }
        return null;
    }

    @Override
    public Shape first() {
        if (size != 0) {
            return shapes[first];
        }
        return null;
    }

    @Override
    public Shape last() {
        if (size != 0) {
            return shapes[(first + size - 1) % shapes.length];
        }
        return null;
    }

    @Override
    public Shape elementAt(int index) {
        if (index >= 0 && index < size) {
            return shapes[(first + index) % shapes.length];
        }
        return null;
    }

    @Override
    public Iterator<Shape> iterator() {
        return new ShapeIterator();
    }

    public class ShapeIterator implements Iterator<Shape> {
        private int index;

        public ShapeIterator() {
            index = first;
        }

        @Override
        public boolean hasNext() {
            return shapes[index % shapes.length] != null;
        }

        @Override
        public Shape next() {
            if (hasNext()) {
                return shapes[(index++) % shapes.length];
            }
            return null;
        }
/*
        @Override
        public void remove() {
            deque();
            index--;
        }

 */
    }

}
