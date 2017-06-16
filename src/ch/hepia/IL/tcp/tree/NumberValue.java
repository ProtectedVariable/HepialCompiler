package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class NumberValue extends Expression {
	private int value;

	public NumberValue(int value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
}
