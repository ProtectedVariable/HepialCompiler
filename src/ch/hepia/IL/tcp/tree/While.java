package ch.hepia.IL.tcp.tree;

import java.util.List;

public class While extends Instruction {

	private Expression condition;
	private List<Instruction> instructions;
	
	public While(int line, Expression condition, List<Instruction> instructions) {
		super(line);
		this.condition = condition;
		this.instructions = instructions;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Expression getCondition() {
		return condition;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}
}
