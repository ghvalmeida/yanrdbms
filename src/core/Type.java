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
	
	private int size;
	
	Type(final int size) {
	  this.size = size;	
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(final int size) {
		this.size = size;
	}
	
}
