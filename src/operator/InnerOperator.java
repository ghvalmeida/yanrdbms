/**
 * 
 */
package operator;

import core.Schema;
import core.Tuple;

/**
 * @author valmeida
 *
 */
public abstract class InnerOperator extends Operator {
	/*
	 * The schema of the output tuples.
	 */
	private final Schema outputSchema;	
	/*
	 * A flag indicating whether there are still tuples to be returned.
	 */
	private Boolean hasNext;	

	/*
	 * The constructor
	 * 
	 * @param children the children operators.
	 */
	public InnerOperator(final Schema outputSchema, final InnerOperator[] children) {
		super(children);
		this.outputSchema = outputSchema;
		this.hasNext = false;
	}
	
	/**
	 * Getter for attribute outputSchema.
	 * 
	 * @return the outputSchema
	 */
	public final Schema getOutputSchema() {
		return outputSchema;
	}

	/*
	 * Checks whether there are still tuples to be returned.
	 */
	public final Boolean hasNext() {
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
