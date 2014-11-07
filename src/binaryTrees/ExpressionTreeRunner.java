package binaryTrees;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * The expression tree runner creates a binary tree from scanner input and uses
 * its methods to print a prefix postfix and inorer notation
 * 
 * @author Sarah Ford
 * @since October 15,2014
 * @status working properly
 */
public class ExpressionTreeRunner {
	/**
	 * 
	 the main method creates an instance of a binary tree and populates it
	 * with input from the scanner then evaluates it
	 * 
	 * @param args
	 *            an empty array of type string
	 * @return void
	 * 
	 */
	private BinaryExpressionTree<String> tree;

	public static void main(String[] args) {
		ExpressionTreeRunner runner = new ExpressionTreeRunner();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an expression: ");
		String values = input.nextLine();
		String[] valuesArray = values.split(",");

		runner.tree = new BinaryExpressionTree<String>();

		ArrayList<String> items = new ArrayList<String>();
		for (String value : valuesArray) {
			items.add(value);
		}
		runner.tree.root = runner.tree.insert(items);
		System.out.print("Preorder: ");
		runner.tree.preOrder(runner.tree.getRoot());
		System.out.print("\nInorder: ");
		runner.tree.inOrder(runner.tree.getRoot());
		System.out.print("\nPostoder: ");
		runner.tree.postOrder(runner.tree.getRoot());
		System.out.print("\nEvaluates to "
				+ runner.tree.evaluate(runner.tree.getRoot()));

	}

}
