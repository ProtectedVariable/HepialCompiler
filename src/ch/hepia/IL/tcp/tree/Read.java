package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class Read extends Instruction {

	private Idf dest;
	
	public Read(int line, Idf dest) {
		super(line);
		this.dest = dest;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}
