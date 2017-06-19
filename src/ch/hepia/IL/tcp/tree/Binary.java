package ch.hepia.IL.tcp.tree;

/**Class Binary
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Parent to all binary (2 operand) operation
 */
public abstract class Binary extends Expression {
	protected Expression left, right;

	public Binary(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public void setLeft(Expression left) {
		this.left = left;
	}

	public void setRight(Expression right) {
		this.right = right;
	}

	
}
