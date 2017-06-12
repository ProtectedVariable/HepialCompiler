package ch.hepia.IL.tcp.tree;

public abstract class Binary extends Expression {
	private Expression left, right;

	public Binary(int line, Expression left, Expression right) {
		super(line);
		this.left = left;
		this.right = right;
	}

	
}
