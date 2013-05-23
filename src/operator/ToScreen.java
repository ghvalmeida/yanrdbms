/**
 * 
 */
package operator;

import core.Tuple;

/**
 * @author valmeida
 *
 */
public class ToScreen extends RootOperator {

	public ToScreen(final InnerOperator[] children) {
		super(children);
	}

	@Override
	protected void consumeTuple(final Tuple tuple) {
		System.out.println(tuple.toString());
	}

	@Override
	protected void dispose() {
	}

}
