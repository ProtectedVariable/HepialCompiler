package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.IntType;
import ch.hepia.IL.tcp.types.Type;

/**Class Addition
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents an addition operation
 */
public class Addition extends Arithmetic {

	public Addition(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return left+" + "+right;
	}

	@Override
	public Type getType() {
		return IntType.getInstance();
	}

}
