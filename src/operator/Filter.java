/**
 * 
 */
package operator;

import core.Predicate;
import core.Schema;
import core.Tuple;

/**
 * The Class Filter.
 * 
 * @author valmeida
 */
public class Filter extends InnerQueryOperator {

	/** The filter predicate. */
	final Predicate predicate;

	/** The next tuple. */
	Tuple next;

	/**
	 * Instantiates a new filter.
	 * 
	 * @param outputSchema the output tuple schema
	 * @param child the child operator
	 * @param predicate the predicate
	 */
	public Filter(final Schema outputSchema, final InnerQueryOperator child,
			final Predicate predicate) {
		super(outputSchema, new InnerQueryOperator[] { child });
		this.predicate = predicate;
		this.next = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see operator.InnerQueryOperator#hasNext()
	 */
	@Override
	public Boolean hasNext() {
		while (getChild().hasNext()) {
			next = getChild().next();
			if (predicate.apply(next)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see operator.InnerQueryOperator#next()
	 */
	@Override
	public Tuple next() {
		assert (next != null);
		return next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see operator.QueryOperator#dispose()
	 */
	@Override
	protected void dispose() {
	}

}
