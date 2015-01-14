package finalProject;

import java.io.Serializable;
import java.util.Comparator;

public class PriorityQueue<T extends Serializable & Comparable<T>> implements Serializable {

	private SortedLinkedList<T> list;
	private Comparator<T> comparator;

	public PriorityQueue(Comparator<T> comparator) {
		list = new SortedLinkedList<T>();
		this.comparator = comparator;

	}

	public void enqueue(T data) {
		list.insert(data, comparator);
	}

	public T dequeue() throws Exception {
		Node<T> getNode = list.getFirst();
		T data = getNode.getData();
		list.remove(data);
		return data;
	}

	public T peek() {
		Node<T> getNode = list.getFirst();
		T data = getNode.getData();
		return data;
	}

	public void remove(T data) throws Exception {
		list.remove(data);
	}

	public LinkedListIterator<T> getIteratior() {
		return list.iterator();

	}

}
