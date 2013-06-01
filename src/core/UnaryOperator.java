/**
 * 
 */
package core;

/**
 * The Class UnaryOperator.
 * 
 * @param <T>
 *            the generic type
 * @author valmeida
 */
public abstract class UnaryOperator<T> implements Operator<T> {

	/** The child operator. */
	protected final Operator<T> child;
	/**
	 * The operator symbol, e.g. "not", "-"
	 */
	protected final String op;

	/**
	 * Instantiates a new unary operator.
	 * 
	 * @param op the op
	 * @param child the child operator.
	 */
	public UnaryOperator(final String op, final Operator<T> child) {
		this.op = op;
		this.child = child;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.Operator#apply()
	 */
	@Override
	abstract public T apply(final Tuple t);

}
