package homework2;

public interface ListADT extends Iterable<Shape>{
	public void addLast(Shape e);
	public void add(int index, Shape e);
	public Shape getFirst();
	public Shape getLast();
	public void removeFirst();
	public void removeLast();
	public void remove(Shape s);
	public int indexOf(Shape s);
	public Shape elementAt(int index);
	public void clear();
	public int size();
	public boolean isEmpty();
	public Shape[] toArray();
}
