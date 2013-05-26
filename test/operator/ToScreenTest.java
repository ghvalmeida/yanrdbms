package operator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queryprocessor.QueryExecutor;

import accessmethod.TextFileScan;

import util.Pair;

import core.Schema;
import core.Type;
import exception.DatabaseException;

public class ToScreenTest {

	Schema schema;
	
	@Before
	public void setUp() throws Exception {
		final Pair<String, Type> follower = new Pair<String, Type>("follower", Type.INT);
		final Pair<String, Type> followee = new Pair<String, Type>("followee", Type.INT);
		final List<Pair<String, Type>> attrTypes = new ArrayList<Pair<String, Type>>();
		attrTypes.add(follower);
		attrTypes.add(followee);
		schema = new Schema(attrTypes);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws DatabaseException, IOException {
		
		String current = new File( "." ).getCanonicalPath();
        System.out.println("Current dir:" + current);
		TextFileScan textFileScan = new TextFileScan(schema, current + "/data/twitter/twitter.txt", null);
		InnerOperator innerOperator[] = { textFileScan };
		ToScreen toScreen = new ToScreen( innerOperator );
		QueryExecutor queryExecutor = new QueryExecutor( toScreen );
		queryExecutor.execute();
	}

}
