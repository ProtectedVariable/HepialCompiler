package ch.hepia.IL.tcp.types;

import ch.hepia.IL.tcp.tree.Expression;

public class BoolConst extends Const {
	
	public BoolConst(int bloc, int line, Expression value) {
		super(BoolType.getInstance(), bloc, line, value);
	}
	
	public String toString() {
		return "("+getValue().toString()+")";
	}
}
