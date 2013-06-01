/**
 * 
 */
package accessmethod;

import java.io.IOException;

import core.Tuple;

/**
 * The Class Page.
 * 
 * @author valmeida
 */
public abstract class Page {

	/** The page data. */
	protected byte[] data;

	/**
	 * Append a tuple to the page
	 * 
	 * @param t the tuple
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws IndexOutOfBoundsException the index out of bounds exception
	 */
	abstract void append(final Tuple t) throws IOException,
			IndexOutOfBoundsException;

	/**
	 * Gets the num of tuples.
	 * 
	 * @return the num of tuples
	 */
	abstract int getNumTuples();
}
