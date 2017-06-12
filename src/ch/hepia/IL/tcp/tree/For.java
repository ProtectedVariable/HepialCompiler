package ch.hepia.IL.tcp.tree;

import java.util.List;

public class For extends Instruction {

	private Idf idf;
	private Expression infLimit, supLimit;
	private List<Instruction> instructions;
	
	public For(Idf idf, Expression infLimit, Expression supLimit, List<Instruction> instructions) {
		this.idf = idf;
		this.infLimit = infLimit;
		this.supLimit = supLimit;
		this.instructions = instructions;
	}
}
