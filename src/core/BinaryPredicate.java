/**
 * 
 */
package core;

/**
 * The Class BinaryPredicate.
 * 
 * @author valmeida
 */
public class BinaryPredicate extends BinaryOperator<Boolean> implements
		Predicate {

	/**
	 * Instantiates a new binary predicate.
	 * 
	 * @param left the left
	 * @param op the op
	 * @param right the right
	 */
	public BinaryPredicate(Operator<?> left, String op, Operator<?> right) {
		super(left, op, right);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.BinaryOperator#apply(core.Tuple)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Boolean apply(Tuple t) {
		if (op == "and") {
			return ((Operator<Boolean>) left).apply(t) && ((Operator<Boolean>) right).apply(t);
		} else if (op == "or") {
			return ((Operator<Boolean>) left).apply(t) || ((Operator<Boolean>) right).apply(t);
		} else if (op == "=") {
			return left.apply(t).equals(right.apply(t));
		} else if (op == "<>") {
			return !left.apply(t).equals(right.apply(t));
		}
		throw new UnsupportedOperationException(
				"No implementation for operator " + op);
	}
}
