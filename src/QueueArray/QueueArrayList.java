package QueueArray;

import java.util.ArrayList;

public class QueueArrayList<T> {
	private ArrayList<T> items;

	public QueueArrayList() {
		items = new ArrayList();
	}

	public void enqueue(T newItem) throws QueueFullException {
		items.add(newItem);

	}

	public void dequeue() throws QueueEmptyException {
		items.remove(0);

	}

	public boolean isEmpty() {
		return items.isEmpty();

	}

	public void dequeueAll() {
		for (int i = 0; i < items.size(); i++) {
			items.remove(i);

		}

	}

	public T peek() throws QueueEmptyException {
		if (!isEmpty()) {
			return items.get(0);
		} else
			throw new QueueEmptyException();

	}

	public static void main(String[] args) {
		QueueArrayList<String> myList = new QueueArrayList<String>();
		myList.enqueue("Rachel");
		myList.enqueue("Gabi");
		myList.enqueue("Tzippy");
		myList.enqueue("Rivki");
		myList.enqueue("Avigayl");
		myList.enqueue("Nechama");
		while (!myList.isEmpty()) {
			System.out.println("Serving " + myList.peek());
			myList.dequeue();
		}

	}

}
