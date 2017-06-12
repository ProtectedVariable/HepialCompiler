package ch.hepia.IL.tcp.tree;

public class And extends Arithmetic {

	public And(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return left+" & "+right;
	}

}
