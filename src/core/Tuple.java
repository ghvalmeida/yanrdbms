/**
 * 
 */
package core;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
	 * The tuple schema
	 */
	private transient Schema schema;
	
	/**
	 * First constructor. Sets the field values from a list of fields.
	 */
	public Tuple(final Schema schema, final List<Field<?>> fields) {
		Objects.requireNonNull(schema);
		Objects.requireNonNull(fields);
		
		assert(schema.matches(fields));
		this.fields = fields;
		this.schema = schema;
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

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		for(int i = 0; i < fields.size(); i++) {
			sb.append(schema.getAttrName(i) + ":" + schema.getAttrType(i).toString() + "=" + fields.get(i).toString());
			if(i!=fields.size()-1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
