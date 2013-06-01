/**
 *
 */
package core;

/**
 * The Class AttrOperand.
 * 
 * @param <T> the generic type
 * @author valmeida
 */
public class AttrOperand<T> implements Operand<T> {

	/**
	 * Attribute index on tuple.
	 */
	final int index;

	/**
	 * Instantiates a new attr operand.
	 * 
	 * @param index the index
	 */
	public AttrOperand(final int index) {
		this.index = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.Operator#apply(core.Tuple)
	 */
	@Override
	public T apply(Tuple t) {
		// No type checking here. We force a typecast.
		// Type checking must be done at the level of query parsing.
		@SuppressWarnings("unchecked")
		Field<T> field = (Field<T>) t.getField(index);
		return field.getValue();
	}
}
