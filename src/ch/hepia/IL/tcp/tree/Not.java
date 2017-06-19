package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.BoolType;
import ch.hepia.IL.tcp.types.Type;

/**Class Not
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents a boolean not operation (!)
 */
public class Not extends Unary {

	public Not(Expression right) {
		super(right);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return "!"+right;
	}
	
	@Override
	public Type getType() {
		return BoolType.getInstance();
	}

}
