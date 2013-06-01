/**
 * 
 */
package accessmethod;

import core.Schema;
import core.Tuple;
import operator.InnerQueryOperator;

/**
 * @author valmeida
 *
 */
public final class TableScan extends InnerQueryOperator {

	public TableScan(final Schema outputSchema, final InnerQueryOperator[] children) {
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
