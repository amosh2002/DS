package homework2;

import java.util.Iterator;

public class ShapesArrayList implements ListADT {
	 	private Shape[] shapes;
	    private int size;
	    
	    public ShapesArrayList() {
	        shapes = new Shape[10];
	        size = 0;
	    }
	    
	    public class MyRunner {
	    	int index = 0;
	    	ShapesArrayList shapesSnapshot;
	    	
	    	public MyRunner () {
	    		///Copy the shapes current state into the shapesSnapshot
	    	}
	    	
	    	public Shape returnOngoing() {
	    		Shape tmp = shapes[index];
	    		index++;
	    		return tmp;
	    	}
	    	
	    	public boolean hasOngoing() {
	    		return index < size;
	    	}
	    	
	    	public void reset() {
	    		index = 0;
	    	}
	    }
	    
	    public ShapesArrayList(int initialCapacity) {
	        shapes = new Shape[initialCapacity];
	        size = 0;
	    }
	    
	    public int size() {
	        return size;
	    }
	    
	    private void resize() {
	        if (size == shapes.length) {
	            Shape[] newShapes = new Shape[shapes.length * 2];
	            for (int i = 0; i < shapes.length; i++) {
	                newShapes[i] = shapes[i];
	            }
	            shapes = newShapes;
	        } else {
	            //through exception
	        }
	    }
	    
	    private void assureCapacity() {
	    	if (shapes.length == size) {
	    		resize();
		    }
	    }
	    
	    public void addLast(Shape e) {
	    	assureCapacity();
	        shapes[size] = e;
	        size++;
	    }

		// Task1: Implement the add function
		public void add(int index, Shape e) {
			if (index >= size) {
				return;
			}
			assureCapacity();
			for (int i = size; i > index; i--) {
				shapes[i] = shapes[i - 1];
			}
			shapes[index] = e;
			size++;
		}

		//Task2: Implement the remove function
		public void removeFirst() {
			for (int i = 0; i < size - 1; i++) {
				shapes[i] = shapes[i+1];
			}
			size--;
		}

		//Task2: Implement the remove function
		public void removeLast() {
			size--;
		}
		
		public void remove(int index) {
			if (index >= size) {
				return;
			}
			for (int i = index; i < size - 1; i++) {
				shapes[i] = shapes[i+1];
			}
			size--;
		}
		
		public void remove(Shape e) {
			int index = indexOf(e);
			if (index > -1) {
				remove(index);
			}
		}
		
		public int indexOf(Shape e) {
			for (int i = 0; i < size ; i++) {
				if (shapes[i].equals(e)) {
					return i;
				}
			}
			return -1;
		}

		//Task3: Implement the elementAt function, which returns the element at given index
		public Shape elementAt(int index) {
			if (index >= size) {
				return null;
			}
			return shapes[index];
		}

		/*public int indexOf(Shape s) {
			for (int i = 0; i < size; i++) {
				if (shapes[i].equals(s)) {
					return i;
				}
			}
			return -1;
		}*/
		
		public void clear() {
			size = 0;
		}

		@Override
		public boolean isEmpty() {
			return size == 0;
		}

		@Override
		public Iterator<Shape> iterator() {
			// TODO Auto-generated method stub
			return new ArrayIterator();
		}
		
	    public class ArrayIterator implements Iterator<Shape> {
	    	int index = 0;	    	
	    	boolean isElementVisited = false;

			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public Shape next() {
				if (index >= size) {
					return null;
				}
				Shape tmp = shapes[index];
				isElementVisited = true;
	    		index++;
	    		return tmp;
			}
			
			public void remove() {
				if (!isElementVisited) {
					return;
					// through an exception
				}
				
				int lastIndex = index - 1;
				ShapesArrayList.this.remove(elementAt(lastIndex));
				index--;
				isElementVisited = false;
			}
	    }

		@Override
		public Shape getFirst() {
			if (size > 0) {
				return shapes[0];
			}
			return null;
		}

		@Override
		public Shape getLast() {
			if (size > 0) {
				return shapes[size - 1];
			}
			return null;
		}

		@Override
		public Shape[] toArray() {
			return shapes.clone();
		} 	
}
