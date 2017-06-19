package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

/**Interface AbstractTree
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * To be implemented by all language components
 */
public interface AbstractTree {
	
	Object accept(Visitor v);
	
}