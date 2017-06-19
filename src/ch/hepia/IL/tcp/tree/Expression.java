package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.types.Type;

/**Class Expression
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Parent of all expressions
 */
public abstract class Expression implements AbstractTree {
	
	public abstract Type getType();
}
