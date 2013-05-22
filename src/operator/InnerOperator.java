/**
 * 
 */
package operator;

import core.Tuple;

/**
 * @author valmeida
 *
 */
public abstract class InnerOperator extends Operator {
	/*
	 * A flag indicating whether there are still tuples to be returned.
	 */
	private Boolean hasNext;	

	/*
	 * The constructor
	 * 
	 * @param children the children operators.
	 */
	public InnerOperator(final InnerOperator[] children) {
		super(children);
		this.hasNext = false;
	}
	
	/*
	 * Checks whether there are still tuples to be returned.
	 */
	public Boolean hasNext() {
		return hasNext;
	}

	/*
	 * Checks whether there are still tuples to be returned.
	 */
	public void finish() {
		hasNext = false;
	}
	
	/*
	 * Returns the next bunch of tuples.
	 * Remark: hasNext() should be called first.
	 */
	abstract public Tuple next();
}
