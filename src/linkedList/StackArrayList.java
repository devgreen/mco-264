package linkedList;

import java.util.ArrayList;

public class StackArrayList<T> {
	
	ArrayList <T> list = new ArrayList<T>();
	
	public void push(T value) {
		list.add(value);
		
	}
	
	public void pop(){
		list.remove(list.size()-1);
		
	}
	
	public T top(){
		 return list.get(list.size()-1);
	
		
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
		
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
