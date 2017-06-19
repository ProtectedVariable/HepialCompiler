package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.IntType;
import ch.hepia.IL.tcp.types.Type;

/**Class And
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents a boolean "and" operation
 */
public class And extends Arithmetic {

	public And(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return left+" & "+right;
	}

	@Override
	public Type getType() {
		return IntType.getInstance();
	}

}
