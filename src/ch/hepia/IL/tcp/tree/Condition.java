package ch.hepia.IL.tcp.tree;

import java.util.List;

import ch.hepia.IL.tcp.code.Visitor;

/**Class Condition
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents a conditional block (if then else)
 */
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
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("if("+condition+") {").append("\n");
		for (Instruction instruction : then) {
			sb.append(instruction).append("\n");
		}
		sb.append(" } else {\n");
		for (Instruction instruction : _else) {
			sb.append(instruction).append("\n");
		}
		sb.append("}");
		return sb.toString();
	}

	public Expression getCondition() {
		return condition;
	}

	public List<Instruction> getThen() {
		return then;
	}

	public List<Instruction> get_else() {
		return _else;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	} 
	
}
