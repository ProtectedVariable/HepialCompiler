package ch.hepia.IL.tcp.tree;

import java.util.ArrayList;
import java.util.List;

import ch.hepia.IL.tcp.code.Visitor;

/**Class Block
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents a list of instructions (e.g a function body)
 */
public class Block extends Instruction {

	private List<Instruction> instructions;
	
	public Block(int line) {
		super(line);
		this.instructions = new ArrayList<>();
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
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
