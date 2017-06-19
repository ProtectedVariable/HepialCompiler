package ch.hepia.IL.tcp.tree;

/**Class Unary
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Parent to all unary operations
 */
public abstract class Unary extends Expression {
	protected Expression right;

	public Unary(Expression right) {
		this.right = right;
	}

	public Expression getRight() {
		return right;
	}
}
