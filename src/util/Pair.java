/**
 * 
 */
package util;

import java.io.Serializable;

/**
 * @author valmeida
 *
 */
public class Pair<L, R> implements Serializable {

	/*
	 * Required for Java serialization. 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Left value.
	 */
	private final L l;
	/*
	 * Right value.
	 */
	private final R r;
	
	/*
	 * The constructor.
	 */
	public Pair(final L l, final R r) {
		this.l = l;
		this.r = r;
	}
	
	/**
	 * @return the left value.
	 */
	public final L getLeft() {
		return l;
	}

	/**
	 * @return the right value.
	 */
	public final R getRight() {
		return r;
	}
}
