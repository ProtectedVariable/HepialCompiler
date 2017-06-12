package ch.hepia.IL.tcp.tree;

public class Call extends Instruction {

	private Idf idf;
	private EffectiveParameters parameters;
	
	public Call(int line, Idf idf, EffectiveParameters parameters) {
		super(line);
		this.idf = idf;
		this.parameters = parameters;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
}
