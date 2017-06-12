package ch.hepia.IL.tcp.tree;

public class Superior extends Relation {

	public Superior(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return left+" > "+right;
	}

}
