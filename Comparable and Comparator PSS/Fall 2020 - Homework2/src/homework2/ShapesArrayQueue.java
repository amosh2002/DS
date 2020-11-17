package homework2;

import java.util.Iterator;

public class ShapesArrayQueue implements QueueADT {
	Shape[] shapes;
	int first;
	int size;
	
	public ShapesArrayQueue() {
		shapes = new Shape[10];
		size = 0;
		first = 0;
	}
	
	public ShapesArrayQueue(int capacity) {
		shapes = new Shape[capacity];
		size = 0;
		first = 0;
	}

	@Override
	public Iterator<Shape> iterator() {
		return new ShapesArrayQueueIterator();
	}
	
    public class ShapesArrayQueueIterator implements Iterator<Shape> {
    	int current = first;
    	
		@Override
		public boolean hasNext() {
			return (current - first) < size;
		}

		@Override
		public Shape next() {
			if (! hasNext()) {
				return null;
			}
			Shape s = shapes[current % shapes.length];
			current++;
			return s;
		}
    }
	
    private void assureCapacity() {
    	if (shapes.length == size) {
    		Shape[] newShapes = new Shape[shapes.length * 2];
            for (int i = 0; i < shapes.length; i++) {
                newShapes[i] = shapes[(first + i) % shapes.length];
            }
            shapes = newShapes;
            first = 0;
         }
    }
	
	@Override
	public void enqueue(Shape e) {
		assureCapacity();
		shapes[(first + size) % shapes.length] = e;
		size++;
	}

	@Override
	public void dequeue() {
		if (size == 0) {
			return;
		}
		first = (first + 1) % shapes.length;
		size--;
	}

	@Override
	public Shape first() {
		if (size == 0) {
			return null;
		}
		return shapes[first];
	}

	@Override
	public Shape last() {
		if (size == 0) {
			return null;
		}
		return shapes[(first + size - 1) % shapes.length];
	}

	@Override
	public Shape elementAt(int index) {
		if (index >= size) {
			return null;
		}
		return shapes[(first + index) % shapes.length];
	}
}
