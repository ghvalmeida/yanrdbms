package operator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queryprocessor.QueryExecutor;
import util.Pair;
import accessmethod.TextFileScan;
import core.AttrOperand;
import core.BinaryPredicate;
import core.ConstOperand;
import core.Schema;
import core.Type;
import exception.DatabaseException;

/**
 * The Class FilterTest.
 */
public class FilterTest {

	/** The schema. */
	Schema schema;

	/**
	 * Sets the up.
	 * 
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		final Pair<String, Type> follower = new Pair<String, Type>("follower",
				Type.INT);
		final Pair<String, Type> followee = new Pair<String, Type>("followee",
				Type.INT);
		final List<Pair<String, Type>> attrTypes = new ArrayList<Pair<String, Type>>();
		attrTypes.add(follower);
		attrTypes.add(followee);
		schema = new Schema(attrTypes);
	}

	/**
	 * Tear down.
	 * 
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test.
	 * 
	 * @throws DatabaseException the database exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void test() throws DatabaseException, IOException {

		final int TEST_OPERAND = 12;
		String current = new File(".").getCanonicalPath();
		System.out.println("Current dir:" + current);
		TextFileScan textFileScan = new TextFileScan(schema, current
				+ "/data/twitter/twitter.txt", null);
		BinaryPredicate predicate = new BinaryPredicate(
				new AttrOperand<Integer>(1), "=", new ConstOperand<Integer>(
						TEST_OPERAND));
		Filter filter = new Filter(schema, textFileScan, predicate);
		ToScreen toScreen = new ToScreen(new InnerQueryOperator[] { filter });
		QueryExecutor queryExecutor = new QueryExecutor(toScreen);
		queryExecutor.execute();
	}
}
