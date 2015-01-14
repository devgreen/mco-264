package doubleLinkedList;

import java.io.Serializable;

public class DoubleLinkedListIterator<T extends Serializable & Comparable<T>> {

	private DoubleLinkNode<T> last;
	private DoubleLinkNode<T> head;

	public DoubleLinkedListIterator(DoubleLinkNode<T> tail) {
		head = tail;
		last = tail;
	}

	public void reset() {
		last = head;
	}

	public boolean hasNext() {
		if (head == null) {
			return false;
		} else if (last != null) {
			return true;
		} else {
			return false;
		}

	}

	public T next() {
		T temp = last.getData();
		last = last.getPrev();
		return temp;
	}

}
