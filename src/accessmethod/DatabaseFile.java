/**
 * 
 */
package accessmethod;

/**
 * The Class DatabaseFile.
 * 
 * @author valmeida
 */
public class DatabaseFile {

	/**
	 * Instantiates a new database file.
	 */
	public DatabaseFile() {
	}

	/**
	 * Read a page.
	 * 
	 * @param offset the offset
	 * @return the page
	 */
	public Page read(final int offset) {
		return null;
	}

	/**
	 * Write a page.
	 * 
	 * @param offset the offset
	 * @param page the page
	 */
	public void write(final int offset, final Page page) {
	}
	
	/**
	 * Append a page.
	 * 
	 * @param page the page
	 */
	public void append(final Page page) {
	}
}
