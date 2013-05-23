/**
 * 
 */
package core;

/**
 * @author valmeida
 *
 */
public enum Type {
	BOOL(1), INT(4), LONG(8), FLOAT(4), DOUBLE(8), CHAR(0), VARCHAR(0);
	
	private Integer size;
	
	Type(final Integer size) {
	  this.size = size;	
	}
	
	public Integer getSize() {
		return size;
	}
	
	public void setSize(final Integer size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		switch(this) {
		case BOOL:
			return "bool";
		case INT:
			return "int";
		case LONG:
			return "long";
		case FLOAT:
			return "float";
		case DOUBLE:
			return "double";
		case CHAR:
			return "char(" + size.toString() + ")";
		case VARCHAR:
			return "varchar(" + size.toString() + ")";
		}
		return null;
	}
}
