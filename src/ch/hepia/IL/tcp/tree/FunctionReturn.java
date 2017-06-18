package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.Type;

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
