package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class Write extends Instruction {
	
	private Expression content;
	private String constant;

	public Write(int line, Expression content) {
		super(line);
		this.setContent(content);
	}
	
	public Write(int line, String str) {
		super(line);
		this.constant = str;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	public Expression getContent() {
		return content;
	}

	public void setContent(Expression content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Write "+(content==null?constant:content.toString());
	}
	
}
