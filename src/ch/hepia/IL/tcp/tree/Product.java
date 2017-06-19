package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.IntType;
import ch.hepia.IL.tcp.types.Type;

/**Class Product
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents an product operation (*)
 */
public class Product extends Arithmetic {

	public Product(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return left +" * "+right;
	}

	@Override
	public Type getType() {
		return IntType.getInstance();
	}
}
