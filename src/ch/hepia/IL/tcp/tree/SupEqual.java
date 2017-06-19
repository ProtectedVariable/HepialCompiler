package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.BoolType;
import ch.hepia.IL.tcp.types.Type;

/**Class SupEqual
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents a superior or equal relation (>=)
 */
public class SupEqual extends Relation {

	public SupEqual(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return left +" >= "+right;
	}
	
	@Override
	public Type getType() {
		return BoolType.getInstance();
	}
}
