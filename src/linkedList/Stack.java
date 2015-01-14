package linkedList;

import java.io.Serializable;

public class Stack<T extends Serializable & Comparable<T> > {
	
	LinkedList <T> list = new LinkedList<T>();
	
	
	public void push(T value) throws Exception{
		list.insert(value);
		
	}
	
	public void pop() throws Exception{
		list.remove(list.getFirst().getData());
		
	}
	
	public T top(){
		 return list.getFirst().getData();
	
		
	}
	public static void main(String[] args){
		StackArrayList<String> list = new StackArrayList<String>();
		
		list.push("new york");
		list.push("new jersey");
		list.push("vermont");
		list.push("maine");
		list.push("new hampshire");
		
		System.out.println(list.top());
		list.pop();
		System.out.println(list.top());
		list.pop();
		System.out.println(list.top());
		list.pop();
		System.out.println(list.top());
		list.pop();
		System.out.println(list.top());
		list.pop();
		
			
			
		
	}
	

}
