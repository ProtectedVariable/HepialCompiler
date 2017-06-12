package ch.hepia.IL.tcp.tree;

public class Assignment extends Instruction {

	private Expression source, dest;

	public Assignment(Expression source, Expression dest) {
		this.source = source;
		this.dest = dest;
	}
	
}
