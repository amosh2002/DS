package homework2;

public interface QueueADT extends Iterable<Shape> {
	void enqueue (Shape e);
	public void dequeue();
	//public Shape dequeue();
	public Shape first();
	public Shape last();
	public Shape elementAt(int index);

}
