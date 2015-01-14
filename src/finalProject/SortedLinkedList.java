package finalProject;

import java.io.Serializable;
import java.util.Comparator;

public class SortedLinkedList<T extends Serializable & Comparable<T>> extends LinkedList<T> implements Serializable {

	@Override
	public void insert(T data) throws DuplicateDataException {

		Node<T> currNode;
		Node<T> prevNode;
		Node<T> aNode = new Node<T>(data);

		if (head == null) {
			head = new Node<T>(data);
		} else if (head.getNext() == null) {
			if (head.getData().compareTo(data) > 0) {
				currNode = aNode;
				currNode.setNext(head);
				head = currNode;
				return;
			} else {
				head.setNext(aNode);
				return;
			}

		} else {
			currNode = head;
			prevNode = head;

			while (currNode != null) {
				if (data.compareTo(currNode.getData()) == 0) {
					throw new DuplicateDataException();
				}
				if (data.compareTo(currNode.getData()) < 0) {
					if (currNode == head) {
						head = aNode;
						aNode.setNext(currNode);
						return;
					} else {
						prevNode.setNext(aNode);
						aNode.setNext(currNode);
						return;
					}
				} else if (data.compareTo(prevNode.getData()) > 0 && data.compareTo(currNode.getData()) < 0) {
					prevNode.setNext(aNode);
					aNode.setNext(currNode);
					return;
				} else {
					prevNode = currNode;
					currNode = currNode.getNext();

				}
			}
			if (currNode == null) {
				prevNode.setNext(aNode);
			}
		}
	}

	public void insert(T data, Comparator<T> comparator) {

		Node<T> currNode;
		Node<T> prevNode;
		Node<T> aNode = new Node<T>(data);

		if (head == null) {
			head = new Node<T>(data);
		} else if (head.getNext() == null) {
			if (comparator.compare(head.getData(), data) > 0) {
				currNode = aNode;
				currNode.setNext(head);
				head = currNode;
				return;
			} else {
				head.setNext(aNode);
				return;
			}

		} else {
			currNode = head;
			prevNode = head;

			while (currNode != null) {
				if (comparator.compare(currNode.getData(), data) == 0
						|| comparator.compare(currNode.getData(), data) > 0) {
					if (currNode == head) {
						head = aNode;
						aNode.setNext(currNode);
						return;
					} else {
						prevNode.setNext(aNode);
						aNode.setNext(currNode);
						return;
					}
				} else if (comparator.compare(prevNode.getData(), data) > 0
						&& comparator.compare(currNode.getData(), data) < 0) {
					prevNode.setNext(aNode);
					aNode.setNext(currNode);
					return;
				} else {
					prevNode = currNode;
					currNode = currNode.getNext();

				}
			}
			if (currNode == null) {
				prevNode.setNext(aNode);

			}

		}
	}

	public Node<T> find(T data) throws NotFoundException {
		Node<T> currNode = head;
		while (currNode != null) {
			if (data.compareTo(currNode.getData()) == 0) {
				return currNode;
			} else {
				currNode = currNode.getNext();
			}

		}
		throw new NotFoundException();

	}
	
	public LinkedListIterator<T> iterator(){
		return new LinkedListIterator<T>(head);
	}
}