package ch.hepia.IL.tcp.tree;

public abstract class Instruction implements AbstractTree {

	protected int line;

	public Instruction(int line) {
		this.line = line;
	}
	
}
