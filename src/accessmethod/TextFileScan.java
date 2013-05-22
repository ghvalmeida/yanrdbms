/**
 * 
 */
package accessmethod;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import exception.DatabaseException;

import memorymanager.TupleBuffer;
import operator.InnerOperator;

/**
 * @author valmeida
 *
 */
public class TextFileScan extends InnerOperator {

	private final String filename;
	private final String separator;
	private Scanner scanner;
	
	public TextFileScan(final String filename, final String separator) {
		super(null);
		this.filename = filename;
		this.separator = separator;
		this.scanner = null;
	}

	@Override
	public void open() throws DatabaseException {
		try{
		    scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(filename))));
		    scanner.useDelimiter("[(\\r\\n)\\n"+separator+"]");
		} catch(FileNotFoundException e) {
			throw new DatabaseException("File " + filename + " not found.");
		}
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
