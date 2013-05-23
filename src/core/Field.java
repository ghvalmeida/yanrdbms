/**
 * 
 */
package core;

import java.io.Serializable;

/**
 * @author valmeida
 *
 */
public class Field<T> implements Serializable {

	/**
	 * Needed for serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The field value
	 */
	private final T value;
	
	/**
	 * The constructor.
	 */
	public Field(final T value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public final T getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}


}
