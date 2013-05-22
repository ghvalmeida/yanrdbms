/**
 * 
 */
package accessmethod;

import memorymanager.TupleBuffer;
import operator.InnerOperator;

/**
 * @author valmeida
 *
 */
public final class TableScan extends InnerOperator {

	public TableScan(InnerOperator[] children) {
		super(children);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TupleBuffer next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

}
