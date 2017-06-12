package ch.hepia.IL.tcp.tree;

public class Assignment extends Instruction {

	private Expression source, dest;

	public Assignment(int line, Expression source, Expression dest) {
		super(line);
		this.source = source;
		this.dest = dest;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
