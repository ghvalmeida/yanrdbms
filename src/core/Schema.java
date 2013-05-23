/**
 * 
 */
package core;

import java.io.Serializable;
import java.util.List;

import util.Pair;

/**
 * @author valmeida
 *
 */
public class Schema implements Serializable {

  /** 
   * Required for Java serialization. 
   **/
  private static final long serialVersionUID = 1L;
  /** 
   * The types of the columns in this relation. 
   **/
  private final List<Pair<String, Type>> attrTypes = null;
  
  /**
   * 
   * @return the # of attribures 
   */
  public int numAttrs() {
	  return attrTypes.size();
  }
  
  /**
   * 
   * @param i index for the inquiry
   * @return the attribute name indexed by i
   */
  public final String getAttrName(final int i) {
	  return attrTypes.get(i).getLeft();
  }

  /**
   * 
   * @param i index for the inquiry
   * @return the attribute type indexed by i
   */
  public final Type getAttrType(final int i) {
	  return attrTypes.get(i).getRight();
  }
  
  public Boolean matches(final List<Field<?>> fields) {
	  // TODO: implement a check whether the fields match the schema.
	  return true;
  }
  
}
