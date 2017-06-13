package ch.hepia.IL.tcp.tree;

public abstract class Unary extends Expression {
	protected Expression right;

	public Unary(Expression right) {
		this.right = right;
	}
}
