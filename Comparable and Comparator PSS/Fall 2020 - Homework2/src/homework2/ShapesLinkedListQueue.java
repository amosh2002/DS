package homework2;

import java.util.Iterator;

public class ShapesLinkedListQueue implements QueueADT {
	ShapesLinkedList list;
	
	public ShapesLinkedListQueue() {
		list = new ShapesLinkedList();
	}

	@Override
	public Iterator<Shape> iterator() {
		return new LinkedListQueueIterator();
	}
	
	public class LinkedListQueueIterator implements Iterator<Shape> {
		Shape current = list.getFirst();
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Shape next() {
			if (!hasNext()) {
				return null;
			}
			Shape s = current;
			current = current.next;
			return s;
		}
		
	}

	@Override
	public void enqueue(Shape e) {
		list.addLast(e);	
	}

	@Override
	public void dequeue() {
		list.removeFirst();
	}

	@Override
	public Shape first() {
		return list.getFirst();
	}

	@Override
	public Shape last() {
		return list.getLast();
	}

	@Override
	public Shape elementAt(int index) {
		return list.elementAt(index);
	}
}
