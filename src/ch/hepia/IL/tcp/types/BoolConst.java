package ch.hepia.IL.tcp.types;

/**Class BoolConst
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Class representing a boolean constant in hepial
 */

import ch.hepia.IL.tcp.tree.Expression;

public class BoolConst extends Const {
	
	public BoolConst(int bloc, int line, Expression value) {
		super(BoolType.getInstance(), bloc, line, value);
	}
	
	public String toString() {
		return "("+getValue().toString()+")";
	}
}
