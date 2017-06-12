package ch.hepia.IL.tcp.tree;

public class NumberValue extends Expression {
	private int value;

	public NumberValue(int value) {
		this.value = value;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
}
