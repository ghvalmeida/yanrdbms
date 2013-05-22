/**
 * 
 */
package operator;

import exception.DatabaseException;
import memorymanager.TupleBuffer;

/**
 * @author valmeida
 *
 */
public abstract class Operator {
	/*
	 * The children operators.
	 */
	protected final InnerOperator[] children;

	/*
	 * The constructor
	 * 
	 * @param children the children operators.
	 */
	public Operator(final InnerOperator[] children) {
		this.children = children;
	}
	
	/*
	 * Opens the operator.
	 * Calls open() for every child operator.
	 */
	public void open() throws DatabaseException {
		for(InnerOperator child: children) {
			child.open();
		}
	}
	
	/*
	 * Closes the operator. 
	 * Calls dispose() to clean up contents of this operator.
	 * Calls close() for every child operator.
	 * 
	 */
	public void close() {
		dispose();
		for(InnerOperator child: children) {
			child.close();
		}
	}
	
	/*
	 * Disposes any resources. 
	 * Called automatically by close().
	 */
	abstract protected void dispose();
}
