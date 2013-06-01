/**
 * 
 */
package operator;

import exception.DatabaseException;

/**
 * @author valmeida
 *
 */
public abstract class QueryOperator {
	/*
	 * The children operators.
	 */
	protected final InnerQueryOperator[] children;

	/*
	 * The constructor
	 * 
	 * @param children the children operators.
	 */
	public QueryOperator(final InnerQueryOperator[] children) {
		this.children = children;
	}

	
	/*
	 * Returns the child, if there is only one.
	 * @return the child operator.
	 */
	public InnerQueryOperator getChild() {
		assert(children.length == 1);
		return children[0];
	}
	
	/*
	 * Opens the operator.
	 * Calls open() for every child operator.
	 */
	public void open() throws DatabaseException {
		for(InnerQueryOperator child: children) {
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
		for(InnerQueryOperator child: children) {
			child.close();
		}
	}
	
	/*
	 * Disposes any resources. 
	 * Called automatically by close().
	 */
	abstract protected void dispose();
}
