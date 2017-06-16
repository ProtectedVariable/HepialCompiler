package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class Call extends Instruction {

	private Idf idf;
	private EffectiveParameters parameters;
	
	public Call(int line, Idf idf, EffectiveParameters parameters) {
		super(line);
		this.idf = idf;
		this.parameters = parameters;
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "Call to"+idf.getName();
	}
}
