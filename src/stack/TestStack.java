package stack;

import java.util.Date;

/**
 * The testStack class implements and compares the run times of two different
 * implementations of the stack data strucure five times.
 * @author Sarah Ford 
 * @since September 15, 2014
 * @status functioning properly 
 */

public class TestStack {
	private Date timer;

	public TestStack() {
		timer = new Date();
	}

	/**
	 * The testStackA method instantiates an array implementation of stack and
	 * times its run time for pushing and popping n elements
	 * 
	 * @param int n, the number of elements to push or pop
	 * @return long, endTime representing the number of ms taken to execute
	 *         implementation
	 * 
	 */
	public long testStackA(int n) {
		StackA sa = new StackA();
		Date timer = new Date();
		long time = timer.getTime();
		for (int i = 1; i <= n; i++) {
			sa.push(i);
		}
		for (int i = 1; i <= n; i++) {
			sa.pop();
		}
		long endTime = new Date().getTime();
		endTime = endTime - time;
		return endTime;

	}

	/**
	 * The testStackL method instantiates a list implementation of stack and
	 * times its run time for pushing and popping n elements
	 * 
	 * @param int n, the number of elements to push or pop
	 * @return long, endTime representing the number of ms taken to execute
	 *         implementation
	 */
	public double testStackL(int n) {
		StackL sl = new StackL();
		Long time = timer.getTime();
		for (int i = 1; i <= n; i++) {
			sl.push(i);
		}
		for (int i = 1; i <= n; i++) {
			sl.pop();
		}
		Double endTime = (double) new Date().getTime();
		endTime = endTime - time;
		sl.makeEmpty();
		return endTime;
	}

	/**
	 * the main method calls two different stack implementations test methods
	 * with varying numbers of elements five different times each
	 * 
	 * @param String
	 *            [] args, an empty array of type string
	 * @return void
	 **/

	public static void main(String[] args) {
		TestStack tester = new TestStack();
		for (int run = 1; run <= 5; run++) {
			System.out.println("Run " + run + " for array implementation");
			for (int i = 100000; i <= 2000000; i += 100000) {
				double time = tester.testStackA(i);
				System.out.println("To push and pop " + i + " values took "
						+ time + " milliseconds");

			}
			System.out.println("Run " + run + " for the list implementation");
			for (int i = 100000; i <= 2000000; i += 100000) {
				double time = tester.testStackL(i);
				System.out.println("To push and pop " + i + " values took "
						+ time + " milliseconds");

			}
		}
	}
}
