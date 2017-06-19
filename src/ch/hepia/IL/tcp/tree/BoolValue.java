package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.BoolType;
import ch.hepia.IL.tcp.types.Type;

/**Class BoolValue
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents a boolean constant value (true or false)
 */
public class BoolValue extends Expression {

	private boolean value;

	public BoolValue(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	@Override
	public Type getType() {
		return BoolType.getInstance();
	}

	public boolean isValue() {
		return value;
	}

}
