/**
 * 
 */
package core;

// TODO: Auto-generated Javadoc
/**
 * The Class ConstOperand.
 * 
 * @param <T> the generic type
 * @author valmeida
 */
public class ConstOperand<T> implements Operand<T> {

	/**
	 * The constant value.
	 */
	private final T constValue;

	/**
	 * The constructor.
	 * 
	 * @param constValue the value.
	 */
	public ConstOperand(final T constValue) {
		this.constValue = constValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.Operator#apply(core.Tuple)
	 */
	@Override
	public T apply(Tuple t) {
		return constValue;
	}

}
