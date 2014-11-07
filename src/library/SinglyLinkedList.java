package library;

/**
 * The Singly Linked List class implements the List interface to allow for
 * storage of the Node ADT. It depends on the Node class
 * 
 * @author Sarah Ford
 * @since September 2,2014
 * 
 */
public class SinglyLinkedList<E> implements ListInterface<E> {
	private int size;
	private Node<E> first;
	private Node<E> last;

	public SinglyLinkedList(int size, Node<E> first, Node<E> last) {
		super();
		this.size = size;
		this.first = first;
		this.last = last;
	}
	public SinglyLinkedList(){
		size=0;
		first=null;
		last=null;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	public E getFirst() {
		if (this.size != 0)
			return this.first.getElement();
		else
			return null;
	}

	public E getLast() {
		if (this.last == null)
			return null;
		else
			return this.last.getElement();

	}

	public void addFirst(E e) {
		Node<E> newFirst = new Node<E>(e, first);
		first = newFirst;
		first.setNext(newFirst);
		this.size++;
		if (size == 1) {
			last = newFirst;
		}
	}

	public void addLast(E e) {
		if (size == 0) {
			addFirst(e);
		} else {
			Node<E> newNode = new Node<E>(e, null);
			last.setNext(newNode);
			last = newNode;
			size++;
		}

	}

	public E removeElementAtPosition(int listPosition) {
		Node<E> previousNode = first;
		Node<E> currentNode = first;
		if (listPosition > size || listPosition <= 0) {
			return null;
		}
		if (listPosition == 1) {
			size--;
			return first.getElement();
			
		} else if(listPosition==size){
			E currentLast=last.getElement();
			last.setElement(getElementAtPosition(size-1));
			System.out.println("removing last");
			size--;
			return currentLast;
			
		}
		else {
			for (int i = 1; i < listPosition; i++) {
				previousNode = currentNode;
				currentNode = currentNode.getNext();// updates and saves the one
													// before it
			}
			previousNode.setNext(currentNode.getNext());
			size--;
			return currentNode.getElement();
		}
	}

	public E getElementAtPosition(int listPosition) {
		if (listPosition > size || listPosition <= 0) {
			return null;
		}
		if (listPosition == 1) {
			return first.getElement();
		} else {
			Node<E> startNode = first;
			for (int i = 1; i < listPosition; i++) {
				startNode = startNode.getNext();
			}
			return startNode.getElement();
		}

	}

}
