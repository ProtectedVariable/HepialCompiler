package ch.hepia.IL.tcp.tree;

import java.util.List;

public class Condition extends Instruction {
	private Expression condition;
	private List<Instruction> then,_else;
	
	public Condition(Expression condition, List<Instruction> then, List<Instruction> _else) {
		this.condition = condition;
		this.then = then;
		this._else = _else;
	}
	
	
}
