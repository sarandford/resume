package binaryTrees;

/**
 * The bunaryTreeNode<E> class implements the BinaryTreeNodeInterface. It allows
 * generic objects to be stored in nodes and used in a binary tree
 * 
 * @author Sarah Ford
 * @param <E>
 * @since October 15, 2014
 */
public class BinaryTreeNode<E> implements BinaryTreeNodeInterface<E> {

	private BinaryTreeNode<E> left;
	private BinaryTreeNode<E> right;
	private BinaryTreeNode<E> parent;
	private E element;

	public BinaryTreeNode() {
		left = null;
		right = null;
		parent = null;
		element = null;

	}

	public BinaryTreeNode(E element, BinaryTreeNode<E> left,
			BinaryTreeNode<E> right, BinaryTreeNode<E> parent) {

		this.left = left;
		this.right = right;
		this.parent = parent;
		this.element = element;
	}

	/**
	 * the getElement method returns the element stored in the node
	 * 
	 * @param void
	 * @return E a generic type
	 */
	public E getElement() {
		return element;
	}

	/**
	 * the set element method allows the binary node element to be assigned
	 * 
	 * @param data
	 *            a generic type E
	 * @return void
	 */
	public void setElement(E data) {
		element = data;

	}

	/**
	 * the get parent method rerutrns the parent node
	 * 
	 * @param void
	 * @return parent a BinaryTreeNode of type E
	 */
	public BinaryTreeNode<E> getParent() {
		return parent;
	}

	/**
	 * the set parent method sets the parent node of the current node
	 * 
	 * @param p
	 *            a BinaryTreeNode of type E
	 * @return void
	 */
	public void setParent(BinaryTreeNode<E> p) {
		parent = p;

	}

	/**
	 * the getLeft method returns the left BinaryTreeNode of type E
	 * 
	 * @param void
	 * @reutn left a BinaryTreeNode of type E
	 */
	public BinaryTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * the getRight method returns the right BinaryTreeNode of type E
	 * 
	 * @param void
	 * @reutn right a BinaryTreeNode of type E
	 */
	public BinaryTreeNode<E> getRight() {
		return right;
	}

	/**
	 * the setLeft method sets the left BinaryTreeNode of the current node
	 * 
	 * @param child
	 *            a BinaryTreeNode of type E
	 * @return void
	 */
	public void setLeft(BinaryTreeNode<E> child) {
		child.setParent(this);
		left = child;

	}

	/**
	 * the setRight method sets the right BinaryTreeNode of the current node
	 * 
	 * @param child
	 *            a BinaryTreeNode of type E
	 * @return void
	 */
	public void setRight(BinaryTreeNode<E> child) {
		child.setParent(this);
		right = child;
	}

	/**
	 * the remove from parent method removes the node from its parent by making
	 * its parent null
	 * 
	 * @param void
	 * @reutn void
	 */
	public void removeFromParent() {
		parent = null;

	}

	/**
	 * the toString method overrides the object.toString method to print out an
	 * element of a BinaryTreeNode as a string
	 * 
	 * @param void
	 * @reutn String of the element contained in the ndoe
	 */
	public String toString() {
		return element.toString();
	}

}