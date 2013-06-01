/**
 * 
 */
package core;

/**
 * The Interface Operator.
 * 
 * @param <T> the generic type
 * @author valmeida
 */
public interface Operator<T> {

	/**
	 * Applies the operator.
	 * 
	 * @param t the tuple
	 * @return the result
	 */
	public T apply(final Tuple t);
}
