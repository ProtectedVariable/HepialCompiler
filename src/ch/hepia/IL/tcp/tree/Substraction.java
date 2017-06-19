package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.IntType;
import ch.hepia.IL.tcp.types.Type;

/**Class Subtraction
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents a subtraction operation
 */
public class Substraction extends Arithmetic {

	public Substraction(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		return left+" - "+right;
	}
	
	@Override
	public Type getType() {
		return IntType.getInstance();
	}
}
