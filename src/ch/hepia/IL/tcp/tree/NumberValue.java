package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.IntType;
import ch.hepia.IL.tcp.types.Type;

/**Class NumberValue
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents an integer constant value
 */
public class NumberValue extends Expression {
	private int value;

	public NumberValue(int value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	@Override
	public Type getType() {
		return IntType.getInstance();
	}

	public int getValue() {
		return value;
	}
}
