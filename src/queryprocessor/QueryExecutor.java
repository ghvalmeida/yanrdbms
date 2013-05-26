/**
 * 
 */
package queryprocessor;

import exception.DatabaseException;
import operator.RootOperator;

/**
 * @author valmeida
 *
 */
public class QueryExecutor {

	/**
	 * The root operator to be executed.
	 */
	final RootOperator operator;
	
	/**
	 * The constructor.
	 * 
	 * @param operator the root operator.
	 */
	public QueryExecutor(final RootOperator operator) {
		this.operator = operator;
	}
	
	/**
	 * Execute the root operator.
	 * 
	 * @throws DatabaseException
	 */
	public void execute() throws DatabaseException {
		operator.open();
		operator.consume();
	}
}
