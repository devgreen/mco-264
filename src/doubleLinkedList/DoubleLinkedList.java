package doubleLinkedList;

import java.io.Serializable;

public class DoubleLinkedList<T extends Serializable & Comparable<T>> implements Serializable {

	protected DoubleLinkNode<T> head;
	protected DoubleLinkNode<T> tail;

	public DoubleLinkedList() {
		head = null;
		tail = head;

	}

	public void insert(T data) throws Exception {

		DoubleLinkNode<T> currNode;
		DoubleLinkNode<T> prevNode;
		DoubleLinkNode<T> aNode = new DoubleLinkNode<T>(data);

		if (head == null) {
			head = new DoubleLinkNode<T>(data);
			tail = head;
			return;
		} else if (head.getNext() == null) {
			if (head.getData().compareTo(data) > 0) {
				currNode = aNode;
				currNode.setNext(head);
				head.setPrev(aNode);
				head = currNode;
				tail = currNode.getNext();
				return;
			} else {
				head.setNext(aNode);
				aNode.setPrev(head);
				tail = aNode;
				return;
			}

		} else {
			currNode = head;
			prevNode = head;

			while (currNode != null) {
				if (data.compareTo(currNode.getData()) == 0 || data.compareTo(currNode.getData()) < 0) {
					if (currNode == head) {
						head = aNode;
						aNode.setNext(currNode);
						currNode.setPrev(aNode);
						return;
					} else {
						currNode.getPrev().setNext(aNode);
						aNode.setNext(currNode);
						aNode.setPrev(currNode.getPrev());
						currNode.setPrev(aNode);
						return;
					}
				} else if (data.compareTo(prevNode.getData()) > 0 && data.compareTo(currNode.getData()) < 0) {
					currNode.getPrev().setNext(aNode);
					aNode.setNext(currNode);
					aNode.setPrev(currNode.getPrev());
					currNode.setPrev(aNode);
					return;
				} else {
					prevNode = currNode;
					currNode = currNode.getNext();

				}
			}
			if (currNode == null) {
				prevNode.setNext(aNode);
				aNode.setPrev(prevNode);
				tail = aNode;

			}

		}

	}

	public void remove(T data) throws Exception {
		DoubleLinkNode<T> currNode;
		DoubleLinkNode<T> prevNode;
		if (head == null) {
			throw new Exception("list empty");
		} else {
			currNode = head;
			prevNode = head;
			while (currNode != null) {
				if (currNode.getData().compareTo(data) == 0) {
					if (currNode == head) {
						head = head.getNext();
						return;
					} else {
						prevNode.setNext(currNode.getNext());
						return;

					}
				} else if (currNode.getData().compareTo(data) < 0) {
					prevNode = currNode;
					currNode = currNode.getNext();
				}

				else if (currNode.getData().compareTo(data) > 0) {
					throw new Exception("not found");

				}

			}

		}

	}

	public void removeAll() {
		head = null;
	}

	public DoubleLinkNode<T> getFirst() {
		return head;
	}

	public DoubleLinkedListIterator<T> iterator() {
		return new DoubleLinkedListIterator<T>(tail);
	}
}
