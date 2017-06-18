package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.Type;

public class Return extends Instruction {

	private Expression value;
	
	public Return(int line, Expression e) {
		super(line);
		this.value = e;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	public Expression getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "return "+value;
	}
}
