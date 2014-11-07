package stack;

import library.SinglyLinkedList;
/**
 * The stackL class implements the stack interface using a singly linked list 
 * data structure
 * @author sarahford
 * @since September 15, 2014
 */
public class StackL implements StackInterface{
	SinglyLinkedList linkedList;
	public StackL(){
		linkedList=new SinglyLinkedList();
	}
	
	public boolean isEmpty() {
		if(linkedList.size()==0){
			return true;
		}
		else{
			return false;
		}
	}

	
	public Object peak() {
		return linkedList.getLast();
	}

	public void push(Object x) {
		//adds to head to avoid iterating through the entire list
		linkedList.addFirst(x);
		
	}

	public Object pop() {
		//removes from head because it pushs to the head
		return linkedList.removeElementAtPosition(1);
		
	}

	public void makeEmpty() {
		int oldSize=linkedList.size();
		for (int i=0;i<=oldSize;i++){
			pop();
		}
		
	}


}
