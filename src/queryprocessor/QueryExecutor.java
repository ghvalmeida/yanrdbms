/**
 * 
 */
package queryprocessor;

import exception.DatabaseException;
import operator.RootQueryOperator;

/**
 * @author valmeida
 *
 */
public class QueryExecutor {

	/**
	 * The root operator to be executed.
	 */
	final RootQueryOperator operator;
	
	/**
	 * The constructor.
	 * 
	 * @param operator the root operator.
	 */
	public QueryExecutor(final RootQueryOperator operator) {
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
