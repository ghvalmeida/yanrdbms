/**
 * 
 */
package accessmethod;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;

import util.Sizeof;
import core.Tuple;

/**
 * The Class NsmPage.
 * 
 * @author valmeida
 */
public class NsmPage extends Page {

	/**
	 * The array of offsets for every tuple. It is written in the end of the
	 * page data, right to left.
	 */
	private LinkedList<Integer> offsetArray;

	/** The page size. */
	public static int PAGE_SIZE = 4096;

	/**
	 * Create a new page.
	 * 
	 */
	public NsmPage() {
		offsetArray = new LinkedList<Integer>();
	}

	/**
	 * Read a page from disk.
	 * 
	 * @param data the data
	 */
	public NsmPage(final byte[] data) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see accessmethod.Page#append(core.Tuple)
	 */
	@Override
	void append(Tuple t) throws IOException, IndexOutOfBoundsException {
		byte[] tdata = Sizeof.serialize(t);
		int sizeofInt = Sizeof.size(Integer.class);
		if (offsetArray.getLast() + tdata.length + (offsetArray.size() + 1)
				* sizeofInt < PAGE_SIZE) {
			System.arraycopy(tdata, 0, data, offsetArray.getLast(),
					tdata.length);
			offsetArray.add(offsetArray.getLast() + tdata.length);
			ByteBuffer b = ByteBuffer.allocate(sizeofInt);
			// optional, the initial order of a byte buffer is always
			// BIG_ENDIAN.
			// b.order(ByteOrder.BIG_ENDIAN);
			b.putInt(tdata.length);
			System.arraycopy(b.array(), 0, data,
					PAGE_SIZE - (offsetArray.size() * sizeofInt), sizeofInt);
		} else {
			throw new IndexOutOfBoundsException("Page full");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see accessmethod.Page#getNumTuples()
	 */
	@Override
	public int getNumTuples() {
		return offsetArray.size();
	}

}
