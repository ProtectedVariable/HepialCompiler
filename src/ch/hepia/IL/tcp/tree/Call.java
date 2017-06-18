package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class Call extends Instruction {

	private Idf idf;
	private EffectiveParameters parameters;
	
	public Call(int line, Idf idf, EffectiveParameters parameters) {
		super(line);
		this.idf = idf;
		this.parameters = new EffectiveParameters(parameters);
	}
	
	public Call(int line, Idf idf) {
		this(line, idf, new EffectiveParameters());
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		return "Call to "+idf.getName();
	}

	public Idf getIdf() {
		return idf;
	}

	public EffectiveParameters getParameters() {
		return parameters;
	}
}
