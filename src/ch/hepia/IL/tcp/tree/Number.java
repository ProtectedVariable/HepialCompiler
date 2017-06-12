package ch.hepia.IL.tcp.tree;

public class Number extends Expression {
	private int value;

	public Number(int line, int value) {
		super(line);
		this.value = value;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
