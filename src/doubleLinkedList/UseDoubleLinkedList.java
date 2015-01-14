package doubleLinkedList;

public class UseDoubleLinkedList {

	public static void main(String[] args) {

		DoubleLinkedList<Integer> numbers = new DoubleLinkedList<Integer>();

		try {
			numbers.insert(3);
			numbers.insert(6);
			numbers.insert(1);
			numbers.insert(4);

		} catch (Exception e) {
			System.out.println("something went wrong - start to cry!");
		}

		DoubleLinkedListIterator<Integer> oneIter = numbers.iterator();
		oneIter.reset();
		while (oneIter.hasNext()) {
			System.out.println(oneIter.next());
		}

	}

}
