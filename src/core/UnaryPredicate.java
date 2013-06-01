/**
 * 
 */
package core;

/**
 * The Class UnaryPredicate.
 * 
 * @author valmeida
 */
public class UnaryPredicate extends UnaryOperator<Boolean> implements Predicate {

	/**
	 * Instantiates a new unary predicate.
	 * 
	 * @param op the op
	 * @param child the child
	 */
	public UnaryPredicate(final String op, final Operator<Boolean> child) {
		super(op, child);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.UnaryOperator#apply(core.Tuple)
	 */
	@Override
	public Boolean apply(Tuple t) {
		if (op == "not") {
			return !child.apply(t);
		}
		return null;
	}
}
