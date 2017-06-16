package ch.hepia.IL.tcp.tree;

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

	
}
