/**
 * 
 */
package core;

import java.io.Serializable;
import java.util.List;

/**
 * @author valmeida
 *
 */
public class Tuple implements Serializable {

	/**
	 * Needed for serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The fields.
	 */
	private List<Field<?>> fields;

	/**
	 * First constructor. Sets the field values from a list of fields.
	 */
	public Tuple(final List<Field<?>> fields) {
		this.fields = fields;
	}
	
	/**
	 * Return the field at position i.
	 * 
	 * @param i the position of the field.
	 * @return the field.
	 */
	public Field<?> getField(final int i) {
		return fields.get(i);
	}

	/**
	 * Set the field at position i.
	 * 
	 * @param i the position of the field.
	 */
	public void setField(final int i, final Field<?> field) {
		fields.set(i, field);
	}

}
