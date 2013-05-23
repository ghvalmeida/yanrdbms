/**
 * 
 */
package accessmethod;

import core.Schema;
import core.Tuple;
import operator.InnerOperator;

/**
 * @author valmeida
 *
 */
public final class TableScan extends InnerOperator {

	public TableScan(final Schema outputSchema, final InnerOperator[] children) {
		super(outputSchema, children);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean hasNext() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Tuple next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

}
