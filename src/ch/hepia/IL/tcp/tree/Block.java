package ch.hepia.IL.tcp.tree;

import java.util.ArrayList;
import java.util.List;

public class Block extends Instruction {

	private List<Instruction> instructions;
	
	public Block(int line) {
		super(line);
		this.instructions = new ArrayList<>();
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

}
