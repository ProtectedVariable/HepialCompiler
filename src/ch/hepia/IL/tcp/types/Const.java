package ch.hepia.IL.tcp.types;

import ch.hepia.IL.tcp.SymbolHEPIAL;
import ch.hepia.IL.tcp.tree.Expression;

public abstract class Const extends SymbolHEPIAL {

	private Expression value;
	
	protected Const(Type t, int bloc, int line, Expression value) {
		super(t, bloc, line);
		this.value = value;
	}
	
	public Expression getValue() {
		return this.value;
	}

}
