package homework2;

import java.util.*;

public class ShapesBoard {
	
	public static <T extends Iterable> void printShapesUsingIterator(T shapes) {
		System.out.println("Printing " + shapes.getClass().getSimpleName() + " collection using Iterator");
		Iterator<Shape> itr = shapes.iterator();
		while (itr.hasNext()) {
			Shape s = itr.next();
			//itr.next().describe();
			System.out.println(s.getName() + " area: " + s.getArea() + " height: " + s.getHeight());
		}
	}
	
	public static void selectionSort(Shape[] shapes) {
		for (int i = 0; i < shapes.length; i++) {
			Shape min = shapes[i];
			int minIndex = i;
			for (int j = i + 1; j < shapes.length; j++) {
				if (shapes[j].compareTo(min) < 0) {
					min = shapes[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Shape tmp = shapes[i];
				shapes[i] = shapes[minIndex]; 
				shapes[minIndex] = tmp;
			}
		}
	}
	public static <T extends ListADT> void selectionSort(T shapes) {
		Shape[] arr = shapes.toArray();
		//arr.sort();
		selectionSort(arr);
		Iterator<Shape> itr = shapes.iterator();
		for (int i = 0; i < arr.length; i++) {
			itr.next();
			itr.set(arr[i]);
		}	
	}
	
	public static <T extends ListADT> void sort(T shapes, Comparator<Shape> cmp) {
		System.out.println("Sorting " + shapes.getClass().getSimpleName() + " collection using Iterator");
		if (cmp != null) {
			System.out.println("Using also Comparator " + cmp.getClass().getSimpleName());
		}
		
		boolean isSorted = false;
		
		while(!isSorted) {
			isSorted = true;
			Iterator<Shape> itr = shapes.iterator();
			Shape prev = null;
			if (itr.hasNext()) {
				prev = itr.next();
			}
			Shape cur = null;
			while (itr.hasNext()) {
				cur = itr.next();
				int compareResult = 0;
				if (cmp != null) { 
					compareResult = cmp.compare(cur,  prev);
				} else {
					compareResult = cur.compareTo(prev);
				}
				if (compareResult < 0) {
					shapes.remove(cur);
					shapes.add(shapes.indexOf(prev), cur);
					isSorted = false;
				} else {
					prev = cur;
				}
			}
		}
	}
	
		
    public static void main(String[] str) {
        ShapesLinkedListQueue lQueue = new ShapesLinkedListQueue();
        lQueue.enqueue(new Square(4));
        lQueue.enqueue(new Circle(5));
        lQueue.enqueue(new Square(3));
        lQueue.enqueue(new Circle(7));
        lQueue.enqueue(new Rectangle(2, 3));
        System.out.println("printing the lQueue");
        for (Shape s: lQueue) {
        	s.describe();
        }
        
        lQueue.dequeue();
        lQueue.dequeue();
        lQueue.enqueue(new Rectangle(3, 3));

        printShapesUsingIterator(lQueue);
        

        ShapesArrayQueue aQueue = new ShapesArrayQueue(4);
        aQueue.enqueue(new Square(3));
        aQueue.enqueue(new Circle(1));
        aQueue.enqueue(new Circle(3));
        aQueue.enqueue(new Square(1));
        aQueue.enqueue(new Rectangle(3, 2));
        aQueue.enqueue(new Rectangle(3, 1));
    	
    	
    	
    	printShapesUsingIterator(aQueue);
    	
    	aQueue.dequeue();
    	
    	aQueue.dequeue();
    	aQueue.enqueue(new Square(7));
    	printShapesUsingIterator(aQueue);
    	
        ShapesLinkedList linkedList = new ShapesLinkedList();
        linkedList.addLast(new Square(4));
        linkedList.addLast(new Circle(5));
        linkedList.add(1, new Square(3));
        linkedList.addFirst(new Circle(7));
        linkedList.add(0, new Rectangle(2, 3));
        
        printShapesUsingIterator(linkedList);
        sort(linkedList, null);
        printShapesUsingIterator(linkedList);
        sort(linkedList, new Shape.ShapeNameComparator());
        printShapesUsingIterator(linkedList);
        sort(linkedList, new Shape.ShapeHeightComparator());
        printShapesUsingIterator(linkedList);
        
        System.out.println("print unsorted array of shapes");
        Shape[] sArr = {new Square(4),new Circle(7),  new Square(5), new Rectangle(3, 5)};
        for (int i = 0; i < sArr.length; i++) {
        	Shape s = sArr[i];
        	System.out.println(s.getName() + " area: " + s.getArea() + " height: " + s.getHeight());
        }
        selectionSort(sArr);
        System.out.println("print sorted array of shapes");
        for (int i = 0; i < sArr.length; i++) {
        	Shape s = sArr[i];
        	System.out.println(s.getName() + " area: " + s.getArea() + " height: " + s.getHeight());
        }
        
        //Collections.sort(linkedList);
        /*
        // Testing shanpshot and lazy iterators below
        Iterator<Shape> itr = linkedList.SnapshotIterator();
        linkedList.removeLast();
        printShapesUsingIterator(linkedList);
        
        System.out.println("Printing the linkedList using snapshot iterator");
        while(itr.hasNext()) {
        	itr.next().describe();
        }
        
        Iterator<Shape> itr1 = linkedList.iterator();
        linkedList.removeFirst();
        System.out.println("Printing the linkedList using iterator after modification");

        while(itr1.hasNext()) {
        	itr1.next().describe();
        }
        System.out.println("Printing the linkedList using iterator after itr recretion");

        itr1 = linkedList.iterator();
        while(itr1.hasNext()) {
        	itr1.next().describe();
        }
        */
    }
}
