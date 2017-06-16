package ch.hepia.IL.tcp.tree;

import java.util.ArrayList;
import java.util.List;

import ch.hepia.IL.tcp.code.Visitor;

public class Block extends Instruction {

	private List<Instruction> instructions;
	
	public Block(int line) {
		super(line);
		this.instructions = new ArrayList<>();
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Instruction instruction : instructions) {
			sb.append(instruction).append("\n");
		}
		return sb.toString();
	}
	
}
