package ch.hepia.IL.tcp.tree;

import java.util.List;

public class Condition extends Instruction {
	private Expression condition;
	private List<Instruction> then,_else;
	
	public Condition(int line, Expression condition, List<Instruction> then, List<Instruction> _else) {
		super(line);
		this.condition = condition;
		this.then = then;
		this._else = _else;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("if("+condition+") {").append("\n");
		for (Instruction instruction : then) {
			sb.append(instruction).append("\n");
		}
		sb.append(" } else {");
		for (Instruction instruction : _else) {
			sb.append(instruction).append("\n");
		}
		sb.append("}");
		return sb.toString();
	} 
	
}
