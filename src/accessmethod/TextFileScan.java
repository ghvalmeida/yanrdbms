/**
 * 
 */
package accessmethod;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import core.Schema;
import core.Tuple;
import core.Field;
import core.Type;

import exception.DatabaseException;

import operator.InnerOperator;

/**
 * @author valmeida
 *
 */
public class TextFileScan extends InnerOperator {

	private final String filename;
	private final String separator;
	private Scanner scanner;
	private Schema outputSchema;
	
	public TextFileScan(final Schema outputSchema, final String filename, final String separator) {
		super(outputSchema, null);
		Objects.requireNonNull(outputSchema);
		Objects.requireNonNull(filename);
		this.filename = filename;
		this.separator = separator;
		this.scanner = null;
	}

	@Override
	public void open() throws DatabaseException {
		try{
		    scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(filename))));
		    if(separator != null) {
		    	scanner.useDelimiter(separator);
		    }
		} catch(FileNotFoundException e) {
			throw new DatabaseException("File " + filename + " not found.");
		}
	}

	@Override
	public final Tuple next() {
		if (scanner.hasNextLine()) {
			Scanner tokenizer = new Scanner(scanner.nextLine());
			List<Field<?>> fields = new ArrayList<Field<?>>(getOutputSchema().numAttrs());
			for(int i = 0; i < getOutputSchema().numAttrs(); i++) {
				final Field<?> f = getNextAttribute(tokenizer, getOutputSchema().getAttrType(i));
				fields.add(f);
			}
			return new Tuple(outputSchema, fields);
		}
		return null;
	}

	@Override
	protected void dispose() {
		scanner.close();
	}
	
	public final Field<?> getNextAttribute(final Scanner tokenizer, final Type type) {
		if(tokenizer.hasNext()) {
			switch(type) {
			case INT:
				if(tokenizer.hasNextInt()) {
					return new Field<Integer>(tokenizer.nextInt());
				}
				break;
			case BOOL:
				if(tokenizer.hasNextBoolean()) {
					return new Field<Boolean>(tokenizer.nextBoolean());
				}
				break;
			case LONG:
				if(tokenizer.hasNextLong()) {
					return new Field<Long>(tokenizer.nextLong());
				}
				break;
			case FLOAT:
				if(tokenizer.hasNextFloat()) {
					return new Field<Float>(tokenizer.nextFloat());
				}
				break;
			case DOUBLE:
				if(tokenizer.hasNextDouble()) {
					return new Field<Double>(tokenizer.nextDouble());
				}
				break;
			case CHAR:
				// TODO: implement reader for fixed size strings
				break;
			case VARCHAR:
				// TODO: implement reader for variable size strings
				break;
			}
		}
		return null;
	}
}
