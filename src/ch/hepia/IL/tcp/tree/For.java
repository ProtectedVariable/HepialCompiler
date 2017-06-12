package ch.hepia.IL.tcp.tree;

import java.util.List;

public class For extends Instruction {

	private Idf idf;
	private Expression infLimit, supLimit;
	private List<Instruction> instructions;
	
	public For(int line, Idf idf, Expression infLimit, Expression supLimit, List<Instruction> instructions) {
		super(line);
		this.idf = idf;
		this.infLimit = infLimit;
		this.supLimit = supLimit;
		this.instructions = instructions;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}
}
