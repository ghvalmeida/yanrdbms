/**
 * 
 */
package core;

import java.io.Serializable;
import java.util.Iterator;
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
  
  public Iterator<Pair<String, Type>> getAttrTypes() {
	  return attrTypes.iterator();
  }
	
}
