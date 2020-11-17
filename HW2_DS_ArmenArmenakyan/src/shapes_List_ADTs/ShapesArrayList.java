package shapes_List_ADTs;

import hw1_problem5.*;

import java.util.Iterator;


public class ShapesArrayList implements ShapesList, Iterable<Shape> {
    private Shape[] shapes;
    private int size;

    public ShapesArrayList() {
        shapes = new Shape[10];
        size = 0;
    }

    public ShapesArrayList(int size) {
        shapes = new Shape[size];
        this.size = 0;
    }

    @Override
    public Iterator<Shape> iterator() {
        return new ShapeIterator();
    }

    public class ShapeIterator implements Iterator<Shape> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Shape next() {
            return shapes[index++];
        }

        @Override
        public void remove() {
            removeElementAt(index--);
        }
    }

    public class ShapeNameIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public String next() {
            return shapes[index++].getName();
        }

    }

    public class ShapeAreaIterator implements Iterator<Double> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Double next() {
            return shapes[index++].getArea();
        }

    }

    private void resize() {
        if (size == shapes.length) {
            Shape[] newShapes = new Shape[shapes.length * 2];
            System.arraycopy(shapes, 0, newShapes, 0, size);
            shapes = newShapes;
        }
    }

    @Override
    public int addLast(Shape shape) {
        resize();
        shapes[size] = shape;
        size++;
        return size;
    }

    @Override
    public void addFirst(Shape shape) {
        resize();
        if (size >= 0) System.arraycopy(shapes, 0, shapes, 1, size);
        shapes[0] = shape;
        size++;
    }

    @Override
    public void removeLast() {
        Shape[] newShapes = new Shape[size - 1];
        for (int i = 0; i < size - 1; i++) {
            newShapes[i] = shapes[i];
        }
        shapes = newShapes;
        size--;
    }

    @Override
    public void removeFirst() {
        Shape[] newShapes = new Shape[size - 1];
        for (int i = 1; i < size; i++) {
            newShapes[i - 1] = shapes[i];
        }
        shapes = newShapes;
        size--;
    }

    @Override
    public void add(int index, Shape e) {
        resize();
        if (size == index) {
            addLast(e);
            return;
        }
        if (0 == index) {
            addFirst(e);
            return;
        }

        Shape[] newShapes = new Shape[size + 1];

        for (int i = 0; i < index; i++) {
            newShapes[i] = shapes[i];
        }
        newShapes[index] = e;
        for (int i = index + 1; i <= size; i++) {
            newShapes[i] = shapes[i - 1];
        }
        shapes = newShapes;
        size++;

    }

    @Override
    public void remove(Shape e) {
        int index = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].equals(e)) {
                index = i;
                break;
            }
        }
        removeElementAt(index);
    }

    @Override
    public void removeElementAt(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size) {
            removeLast();
            return;
        }
        Shape[] newShapes = new Shape[size - 1];
        for (int i = 0; i < index; i++) {
            newShapes[i] = shapes[i];
        }
        for (int i = index; i < size - 1; i++) {
            newShapes[i] = shapes[i + 1];
        }
        shapes = newShapes;
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
        shapes = new Shape[0];
        size = 0;
    }

    @Override
    public int indexOf(Shape e) {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            shapes[i].describe();
            if (size - 1 != i) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

}
