package ch.hepia.IL.tcp.types;

/**Class Const
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Class representing a constant
 */

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
