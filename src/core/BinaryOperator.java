/**
 * 
 */
package core;

// TODO: Auto-generated Javadoc
/**
 * The Class BinaryOperator.
 * 
 * @param <T> the generic type
 * @author valmeida
 */
public abstract class BinaryOperator<T> implements Operator<T> {

	/**
	 * Left and right child operators.
	 */
	protected final Operator<?> left;

	/** The right. */
	protected final Operator<?> right;
	/**
	 * The operator symbol.
	 */
	protected final String op;

	/**
	 * Instantiates a new binary operator.
	 * 
	 * @param left the left
	 * @param op the op
	 * @param right the right
	 */
	public BinaryOperator(final Operator<?> left, final String op,
			final Operator<?> right) {
		this.left = left;
		this.op = op;
		this.right = right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.Operator#apply()
	 */
	@Override
	public abstract T apply(final Tuple t);
}
