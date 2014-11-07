
package movies;

import java.util.*;

/**
 * The deque class instantiates an array to serve as a deque and implements
 * methods required by a deque
 * 
 * @author Sarah Ford
 * @since October 3, 2014
 * 
 */
public class Deque<E> {
	ArrayList<E> deque;
	
	public Deque() {
		deque = new ArrayList<E>();
	}
	/**
	 * 
	It retruns the first element in the deque 
	@param void
	@return E a generic type
	*
	 */
	E getFirst() {
		return deque.get(0);

	}
	/**
	 * 
	It retruns the last element in the deque 
	@param void
	@return E a generic type
	*
	 */
	E getLast() {
		return deque.get(deque.size() - 1);

	}
	/**
	 * 
	it removes the first element in a deque. 
	@param void	
	@return	void
	 */
	void removeFirst() {
		deque.remove(0);
	}
	/**
	 * 
	it removes the last element in a deque. 
	@param void	
	@return	void
	 */
	void removeLast() {
		deque.remove(deque.size() - 1);
	}
	/** 
	 * 
	it adds an element to the first position in the dequ
	@param E a generic element to add
	@return void
	*
	 */
	void addFirst(E newFirst) {
		deque.add(newFirst);
	}
	/** 
	 * 
	it adds an element to the last position in the dequ
	@param E a generic element to add
	@return void
	*
	 */
	void addLast(E newLast) {
		deque.add(newLast);
	}
	/**returns the size of the deque ie the number of elements 
	@param void
	@return int representing number of elements
	*
	 */
	int size() {
		return deque.size();
	}
	/**the iterate method returns an instance of the inner iterator class which iterates through the deque
	@param void
	@return DequeIterator , an instance of the DequeIterator class
	 */
	public DequeIterator<E> iterate(){
		return new DequeIterator<E>();
	}
	/**
	 * the inner class DequeIterator implements the Iterator interface for a Deque for a generic type E
	 * @author sarahford
	 * @param <Deque>
	 */
	class DequeIterator<Deque> implements Iterator<E> {
		private int position;
		/**
		 * the public hasNext() method returns a boolean true or false dependent on wheter or not there is an element which the iterator has not seen yet
		 * @param void
		 * @return boolean
		 */
		public boolean hasNext() {
			try{
			deque.get(position);
			return true;
			}
			catch(IndexOutOfBoundsException e){
			return false;
			}
		}
		/**
		 * incremenets the position and returns the element of the next posisition in the Deque
		 * @param void
		 * @return E a generic element type
		 */
		public E next() {
			if (hasNext()) {
				position++;
				return deque.get(position-1);
				
			} else {
				return null;
			}
		}
		/** the remove method allows the iterator to delete elements from the Deque while iterating through
		 * @param void
		 * @return void
		 */
		
		public void remove() {
			deque.remove(position);
			position++;

		}

	}

}
