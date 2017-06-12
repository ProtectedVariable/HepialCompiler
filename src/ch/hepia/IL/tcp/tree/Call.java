package ch.hepia.IL.tcp.tree;

public class Call extends Instruction {

	private Idf idf;
	private EffectiveParameters parameters;
	
	public Call(Idf idf, EffectiveParameters parameters) {
		this.idf = idf;
		this.parameters = parameters;
	}
}
