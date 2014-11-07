package library;

/**
 * The Node class creates an abstract data type which hold references to generic
 * elements
 * 
 * @author Sarah Ford
 * @since September 2,2014
 */
public class Node<E> {
	private E element;
	private Node<E> next;

	public Node(E element, Node<E> next) {
		this.element = element;
		this.next = next;
	}

	/**
	 * The method returns the an element contained in the node.It does not
	 * depend on any other methods or classes.
	 * 
	 * @param void
	 * @return E a generic element type
	 * 
	 */
	public E getElement() {
		return this.element;
	}

	/**
	 * the setElement method sets the element contained in the node.It does not
	 * depend on any other methods or classes.
	 * 
	 * @param E
	 *            a generic element
	 * @return void
	 * 
	 */
	public void setElement(E newElement) {
		this.element = newElement;
	}

	/**
	 * 
	 the getNext method returns a node representing the next node in the
	 * ADT.It does not depend on any other methods or classes.
	 * 
	 * @param void
	 * @return Node<E> a Node containing a generic element reference
	 * 
	 */
	public Node<E> getNext() {
		return this.next;
	}

	/**
	 * 
	 setNext sets the reference to the nextNode of the current node. It does
	 * not depend on any other methods or classes.
	 * 
	 * @param newNext
	 *            Node<E> a generic element node representing the next node
	 * @return void
	 * 
	 */
	public void setNext(Node<E> newNext) {
		this.next = newNext;
	}

}
