package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.Type;

/**Class FunctionReturn
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents the expression returned by a function after it's execution
 */
public class FunctionReturn extends Expression {

	private Type type;
	
	public FunctionReturn(Type t) {
		this.type = t;
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	@Override
	public Type getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type.toString();
	}

}
