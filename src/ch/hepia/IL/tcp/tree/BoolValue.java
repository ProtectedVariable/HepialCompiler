package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.BoolType;
import ch.hepia.IL.tcp.types.Type;

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
