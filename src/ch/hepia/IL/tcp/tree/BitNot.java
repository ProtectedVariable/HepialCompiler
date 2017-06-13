package ch.hepia.IL.tcp.tree;

public class BitNot extends Unary {

	public BitNot(Expression right) {
		super(right);
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "~"+right;
	}
}
