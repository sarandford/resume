package binaryTrees;

import java.util.ArrayList;

/**
 * Binary expression tree class contains a sructure of linked binary tree nodes
 * and method for accessing and evlauating them
 * 
 * @author Sarah Ford
 * @param <E>
 * @since October 15, 2014
 */
public class BinaryExpressionTree<E> {
	BinaryTreeNode<E> root;

	/**
	 * 
	 the isLead method accpets a node element of type E and determines whether
	 * or not it is a leaf(an operand) or not (an operator). IT reutns true if
	 * it is an operand and false if it is an operator
	 * 
	 * @param nodeElement
	 *            an element of a BinaryTreeNode of type E
	 * @return
	 * 
	 */
	private boolean isLeaf(E nodeElement) {
		if ((nodeElement.equals("*")) || (nodeElement.equals("/"))
				|| (nodeElement.equals("+")) || (nodeElement.equals("-"))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 The insert method for the BinaryExpresionTree inserts a new node in the
	 * next open posisiton on the tree
	 * 
	 * @param newNode
	 *            a BinaryTreeNode
	 * @return void
	 * 
	 */
	BinaryTreeNode<E> insert(ArrayList<E> values) {
		while (!values.isEmpty()) {
			E token = values.remove(0);
			BinaryTreeNode<E> leftSubTree;
			BinaryTreeNode<E> rightSubTree;
			if (!(isLeaf(token))) {
				leftSubTree = insert(values);
				rightSubTree = insert(values);
				return new BinaryTreeNode<E>(token, leftSubTree, rightSubTree,
						null);
			} else if (isLeaf(token)) {
				return new BinaryTreeNode<E>(token, null, null, null);
			}

		}
		return null;

	}

	/**
	 * 
	 The remove method
	 * 
	 * @param <parameter name> <what the parameter is used for>
	 * @return <what the method returns>
	 * 
	 */
	private void remove(BinaryTreeNode oldNode) {
		oldNode.removeFromParent();
	}

	/**
	 * 
	 It returns a string of its elements in a preorder
	 * 
	 * @param void
	 * 
	 */
	void preOrder(BinaryTreeNode<E> currentNode) {
		if (currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			preOrder(currentNode.getLeft());
			preOrder(currentNode.getRight());

		}
	}

	/**
	 * 
	 It returns a string of its elements in a post-order
	 * 
	 * @param void
	 * @return String of its elements
	 * 
	 */
	void postOrder(BinaryTreeNode<E> currentNode) {
		if (currentNode != null) {
			postOrder(currentNode.getLeft());
			postOrder(currentNode.getRight());
			System.out.print(currentNode.getElement() + " ");
		}
	}

	/**
	 * 
	 It returns a string of its elements in an inorder order
	 * 
	 * @param void
	 * 
	 */
	void inOrder(BinaryTreeNode<E> currentNode) {
		if (currentNode.getLeft() != null
				&& (!(isLeaf(currentNode.getElement())))) {
			System.out.print("(");
			inOrder(currentNode.getLeft());
		}
		System.out.print(" " + currentNode.getElement());
		if (currentNode.getRight() != null) {
			inOrder(currentNode.getRight());
			System.out.print(")");
		}

	}

	/**
	 * 
	 the evaluates takes the inorder string of the tree for an expression from
	 * the inroder method and evaluates its mathematical value based on the
	 * order of operations
	 * 
	 * @param void
	 * @return String representing the value of the exprssion tree
	 * 
	 */
	double evaluate(BinaryTreeNode<E> currentNode) {
		if (isLeaf(currentNode.getElement())) {
			return Double.parseDouble((String) currentNode.getElement());
		}
		double left = evaluate(currentNode.getLeft());
		double right = evaluate(currentNode.getRight());
		if (currentNode.getElement().equals("*")) {
			return left * right;
		} else if (currentNode.getElement().equals("/")) {
			return left / right;
		} else if (currentNode.getElement().equals("+")) {
			return left + right;
		} else {
			return left - right;
		}
	}

	/**
	 * 
	 the get root method is an accesor method for the root of the Binary
	 * expression tree
	 * 
	 * @param <parameter name> <what the parameter is used for>
	 * @return <what the method returns>
	 * 
	 */
	BinaryTreeNode<E> getRoot() {
		return root;
	}

}
