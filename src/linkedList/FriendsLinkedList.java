package linkedList;

public class FriendsLinkedList {
	
	public static void main(String [] args){
		
		LinkedList<String> myFriends = new LinkedList<String>();
		
		try {
			myFriends.insert("Avigayil");
			myFriends.insert("Shayna");
			myFriends.insert("RahcelAziza");
			
		} catch (Exception e) {
			System.out.println ("something went wrong - start to cry!");
		}
		myFriends.iter.reset();
		
		while (myFriends.iter.hasNext()){
			System.out.println(myFriends.iter.next());
		}
		
		LinkedListIterator <String> oneIter = myFriends.iterator();
		LinkedListIterator <String> twoIter = myFriends.iterator();
	}

}
