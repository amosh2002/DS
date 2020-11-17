package Shapes_ADTs.Stack;

import Shape_and_subclasses.Shape;

public class ShapesArrayStack implements ShapesStack {
    private Shape[] shapes;
    private int size;

    public ShapesArrayStack() {
        shapes = new Shape[10];
        size = 0;
    }


    private void resize() {
        if (size == shapes.length) {
            Shape[] newShapes = new Shape[shapes.length * 2];
            System.arraycopy(shapes, 0, newShapes, 0, size);
            shapes = newShapes;
        }
    }

    private boolean checkForZeroSize() {
        return size != 0;
    }

    public int size() {
        return size;
    }

    public void push(Shape shape) {
        resize();
        shapes[size] = shape;
        size++;
    }

    public Shape pop() {
        if (checkForZeroSize()) {
            Shape tmp = shapes[size - 1];
            shapes[size - 1] = null;
            size--;
            return tmp;
        }
        return null;
    }

    public Shape top() {
        if(checkForZeroSize()){
            return shapes[size - 1];
        }
        return null;
    }


    public Shape bottom() {
        if(checkForZeroSize()){
            return shapes[0];
        }
        return null;
    }

    public int indexOf(Shape e) {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

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
