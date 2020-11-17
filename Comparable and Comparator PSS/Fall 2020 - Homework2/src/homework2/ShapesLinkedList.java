package homework2;

import java.util.Iterator;

public class ShapesLinkedList implements ListADT {
    private Shape first;
    private Shape last;
    private int size;
    
    public void ShapesLinkedList( ) {
        first = last = null;
    }
    
    public void addLast(Shape e) {
        if (null == last) {
            last = first = e;
        } else {
            e.prev = last;
            e.next = null;
            last.next = e;
            last = e;
        }
        size++;
    }
    
    public void addFirst(Shape e) {
        if (null == last) {
            last = first = e;
        } else {
            e.next = first;
            first.prev = e;
            e.prev = null;
            first = e;
        }
        size++;
    }
    
    public Shape getFirst() {
    	return first;
    }
    
    public Shape getLast() {
    	return last;
    }

	// Task1: Implement the add function
	public void add(int index, Shape e) {
		if (index > size) {
			return;
		}
		if (size == 0 || index == 0) {
			addFirst(e);
		} else if (index == size) {
			addLast(e);
		} else {
			Shape s = first;
			for (int i = 0; i < index; i++) {
				s = s.next;
			}
			s.prev.next = e;
			e.prev = s.prev;
			e.next = s;
			s.prev = e;
			size++;
		}
	}

	//Task2: Implement the remove function
	public void removeFirst() {
		if (size == 1) {
			first = last = null;
		} else {
			first = first.next;
			first.prev.next = null;
			first.prev = null;
		}
		size--;
	}

	//Task2: Implement the remove function
	public void removeLast() {
		if (size == 1) {
			first = last = null;
		} else {
			last = last.prev;
			last.next = null;
		}
		size--;
	}
	
	public void remove(Shape e) {
		Shape current = first;
		while (current != null) {
			if (current.equals(e)) {
				Shape tmp = current;
				current = current.next;
				if (tmp.equals(first)) {
					removeFirst();
				} else if (tmp.equals(last)) {
					removeLast();
				} else {
					tmp.prev.next = tmp.next;
					tmp.next.prev = tmp.prev;
					size--;
				}
				break;
			} else {
				current = current.next;
			}
		}
	}

	//Task3: Implement the elementAt function, which returns the element at given index
	public Shape elementAt(int index) {
		//TODO check if index is within boundaries
		Shape cur = first;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	public int indexOf(Shape s) {
		Shape cur = first;
		for (int i = 0; i < size; i++) {
			if (cur.equals(s)) {
				return i;
			}
			cur = cur.next;
		}
		return -1;
	}

	public void clear() {
		last = first = null;
		size = 0;	
	}

	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<Shape> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	public Iterator<Shape> SnapshotIterator() {
		// TODO Auto-generated method stub
		return new LinkedListSnapshotIterator();
	}

	public class LinkedListIterator implements Iterator<Shape> {
		Shape current = first;
		Shape lastReturned = null;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Shape next() {
			if (!hasNext()) {
				return null;
			}
			Shape tmp = current;
			lastReturned = tmp;
			current = current.next;
			return tmp;
		}
		
		public void remove() {
			if (lastReturned == null) {
				return;
				// through exception
			}
			ShapesLinkedList.this.remove(lastReturned);
			lastReturned = null;
		}
		
		public void set(Shape s) {
			if (lastReturned == null) {
				return;
			}
			lastReturned.prev.next = s;
			s.prev = lastReturned.prev;
			lastReturned.next.prev = s;
			s.next = lastReturned.next;
			lastReturned = null;
		}
	}
	public Iterator<Shape> ReverseIterator() {
		return new LinkedListReverseIterator();
	}
	
	public class LinkedListReverseIterator implements Iterator<Shape> {
		Shape current = last;
		Shape lastReturned = null;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Shape next() {
			if (!hasNext()) {
				return null;
			}
			Shape tmp = current;
			lastReturned = tmp;
			current = current.prev;
			return tmp;
		}
		
		public void remove() {
			if (lastReturned == null) {
				return;
				// through exception
			}
			ShapesLinkedList.this.remove(lastReturned);
			lastReturned = null;
		}
	}
	
	public class LinkedListSnapshotIterator implements Iterator<Shape> {
		Shape current;
		Shape lastReturned = null;
		ShapesLinkedList newList;
		
		public LinkedListSnapshotIterator() {
			Shape cur = first;
			newList = new ShapesLinkedList();
			while (cur != null) {
				newList.addLast((Shape)cur.clone());
				cur = cur.next;
			}
			current = newList.getFirst();
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Shape next() {
			if (!hasNext()) {
				return null;
			}
			Shape tmp = current;
			lastReturned = tmp;
			current = current.next;
			return tmp;
		}
		
		public void remove() {
			if (lastReturned == null) {
				return;
				// through exception
			}
			newList.remove(lastReturned);
			lastReturned = null;
		}
	}
	@Override
	public Shape[] toArray() {
		Shape[] arr = new Shape[size];
		Shape cur = first;
		for (int i = 0; i < size; i++) {
			arr[i] = cur;
			cur = cur.next;
		}
		return arr;
	}
}
