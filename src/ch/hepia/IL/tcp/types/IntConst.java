package ch.hepia.IL.tcp.types;

import ch.hepia.IL.tcp.tree.Expression;

public class IntConst extends Const {

	
	public IntConst(int bloc, int line, Expression value) {
		super(IntType.getInstance(), bloc, line, value);
	}

	public String toString() {
		return "("+getValue().toString()+")";
	}
	
}
