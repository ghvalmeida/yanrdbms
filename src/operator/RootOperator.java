/**
 * 
 */
package operator;

import core.Tuple;


/**
 * @author valmeida
 *
 */
abstract public class RootOperator extends Operator {

	/*
	 * The constructor
	 * 
	 * @param children the child operators.
	 */
	public RootOperator(final InnerOperator[] children) {
		super(children);
	}
	
	/*
	 * The consume operation.
	 * Calls the consumeTo to actually write a bunch of tuples.
	 */
	public void consume() {
		assert(children.length == 1);
		while(children[0].hasNext()) {
			final Tuple tuple = children[0].next();
			consumeTuple(tuple);
		}
	}
	
	/*
	 * Consumes a bunch of tuples.
	 * 
	 * @param tb the bunch of tuples.
	 * @param to where to write to.
	 */
	abstract protected void consumeTuple(final Tuple tuple);
}
