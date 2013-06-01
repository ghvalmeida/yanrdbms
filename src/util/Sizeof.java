/**
 * 
 */
package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class Sizeof.
 * 
 * @author valmeida
 */
public class Sizeof {

	/** Precomputed sizeofs. */
	private static Map<String, Integer> preComputed = new HashMap<String, Integer>();

	/**
	 * The sizeof funcion.
	 * 
	 * @param object the object
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static int size(final Serializable object) throws IOException {
		final String className = object.getClass().getName();
		if (className != null) {
			if (preComputed.containsKey(className)) {
				return preComputed.get(className);
			} else {
				final byte[] s = serialize(object);
				preComputed.put(className, s.length);
				return s.length;
			}
		}
		return 0;
	}

	/**
	 * Serialize.
	 * 
	 * @param object the object
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static byte[] serialize(final Serializable object)
			throws IOException {
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
			out = new ObjectOutputStream(bos);
			out.writeObject(object);
			return bos.toByteArray();
		} finally {
			out.close();
			bos.close();
		}
	}

	/**
	 * Deserialize.
	 * 
	 * @param data the data
	 * @return the object
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	Object deserialize(final byte[] data) throws IOException,
			ClassNotFoundException {
		final ByteArrayInputStream bis = new ByteArrayInputStream(data);
		ObjectInput in = null;
		try {
			in = new ObjectInputStream(bis);
			return in.readObject();
		} finally {
			bis.close();
			in.close();
		}
	}
}
