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
  
  public int numAttrs() {
	  return attrTypes.size();
  }
  
  public final String getAttrName(final int i) {
	  return attrTypes.get(i).getLeft();
  }

  public final Type getAttrType(final int i) {
	  return attrTypes.get(i).getRight();
  }
  
}
