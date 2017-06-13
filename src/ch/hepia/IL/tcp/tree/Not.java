package ch.hepia.IL.tcp.tree;

public class Not extends Unary {

	public Not(Expression right) {
		super(right);
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "!"+right;
	}

}
